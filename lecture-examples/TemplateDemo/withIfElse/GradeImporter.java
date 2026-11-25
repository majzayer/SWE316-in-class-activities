import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Alternative A: one importer, with a switch at every step that varies.
 * The duplication is gone, but adding a format means editing the enum
 * and every switch in this class (violates OCP).
 */
public class GradeImporter {
    private final GradeRepository repository;

    public GradeImporter(GradeRepository repository) {
        this.repository = repository;
    }

    public void importGrades(Format format, String content) {
        System.out.println("Importing from " + format + "...");
        List<String> lines = readLines(content);
        lines = preprocess(format, lines);

        int imported = 0;
        int rejected = 0;
        for (String line : lines) {
            GradeRecord record = parse(format, line);
            String reason = validate(record);
            if (reason == null) {
                repository.save(record);
                imported++;
            } else {
                System.out.println("  rejected (" + reason + "): " + line);
                onRejected(format, line);
                rejected++;
            }
        }
        AuditLog.record(format.toString(), imported, rejected);
    }

    // ---------------- steps that vary: one switch each ----------------

    private List<String> preprocess(Format format, List<String> lines) {
        return switch (format) {
            case CSV    -> dropHeader(lines);
            case JSON   -> dropBrackets(lines);
            case BANNER -> lines;
        };
    }

    private GradeRecord parse(Format format, String line) {
        return switch (format) {
            case CSV    -> parseCsv(line);
            case JSON   -> parseJson(line);
            case BANNER -> parseBanner(line);
        };
    }

    private void onRejected(Format format, String line) {
        switch (format) {
            case CSV, JSON -> { }
            case BANNER    -> System.out.println("    -> written to banner_errors.txt for the registrar");
        }
    }

    // ---------------- steps that never vary ----------------

    private List<String> readLines(String content) {
        List<String> lines = new ArrayList<>();
        for (String line : content.split("\n")) {
            if (!line.isBlank()) {
                lines.add(line);
            }
        }
        return lines;
    }

    private String validate(GradeRecord record) {
        if (!record.getStudentId().matches("\\d{9}")) {
            return "bad ID";
        }
        if (record.getScore() < 0 || record.getScore() > 100) {
            return "bad score";
        }
        if (!repository.isEnrolled(record.getStudentId(), record.getCourse())) {
            return "not enrolled";
        }
        return null;
    }

    // ---------------- format-specific details ----------------

    private List<String> dropHeader(List<String> lines) {
        return lines.subList(1, lines.size());
    }

    private List<String> dropBrackets(List<String> lines) {
        return lines.stream()
                .filter(line -> !line.equals("[") && !line.equals("]"))
                .toList();
    }

    private GradeRecord parseCsv(String line) {
        String[] parts = line.split(",");
        return new GradeRecord(parts[0], parts[1], Integer.parseInt(parts[2]));
    }

    private GradeRecord parseJson(String line) {
        Matcher m = jsonFields(line);
        return new GradeRecord(m.group(1), m.group(2), Integer.parseInt(m.group(3)));
    }

    // fixed-width columns: [0-9) ID, [9-16) course, [16-19) score
    private GradeRecord parseBanner(String line) {
        return new GradeRecord(line.substring(0, 9),
                line.substring(9, 16).trim(),
                Integer.parseInt(line.substring(16, 19).trim()));
    }

    // Pulls studentId, course and score out of one JSON line (groups 1, 2, 3).
    private static Matcher jsonFields(String line) {
        Matcher m = Pattern.compile(
                "\"studentId\":\"(\\w+)\",\"course\":\"(\\w+)\",\"score\":(-?\\d+)")
                .matcher(line);
        if (!m.find()) {
            throw new IllegalArgumentException("Malformed JSON record: " + line);
        }
        return m;
    }
}
