import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LmsJsonImporter {
    private final GradeRepository repository;

    public LmsJsonImporter(GradeRepository repository) {
        this.repository = repository;
    }

    public void importGrades(String content) {
        System.out.println("Importing from LMS JSON...");
        List<String> lines = readLines(content);
        lines = preprocess(lines);

        int imported = 0;
        int rejected = 0;
        for (String line : lines) {
            GradeRecord record = parse(line);
            String reason = validate(record);
            if (reason == null) {
                repository.save(record);
                imported++;
            } else {
                System.out.println("  rejected (" + reason + "): " + line);
                rejected++;
            }
        }
        AuditLog.record("LMS JSON", imported, rejected);
    }

    private List<String> readLines(String content) {
        List<String> lines = new ArrayList<>();
        for (String line : content.split("\n")) {
            if (!line.isBlank()) {
                lines.add(line);
            }
        }
        return lines;
    }

    // drop the [ and ] lines around the records
    private List<String> preprocess(List<String> lines) {
        return lines.stream()
                .filter(line -> !line.equals("[") && !line.equals("]"))
                .toList();
    }

    private GradeRecord parse(String line) {
        Matcher m = jsonFields(line);
        return new GradeRecord(m.group(1), m.group(2), Integer.parseInt(m.group(3)));
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
