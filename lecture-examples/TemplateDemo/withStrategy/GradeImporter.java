import java.util.ArrayList;
import java.util.List;

/**
 * One importer that holds the fixed steps (read, validate, save, audit)
 * and delegates the varying steps to a GradeFormat object.
 */
public class GradeImporter {
    private final GradeRepository repository;
    private GradeFormat format;

    public GradeImporter(GradeRepository repository, GradeFormat format) {
        this.repository = repository;
        this.format = format;
    }

    // Strategy's advantage: the format can be swapped at runtime.
    public void setFormat(GradeFormat format) {
        this.format = format;
    }

    public void importGrades(String content) {
        System.out.println("Importing from " + format.name() + "...");
        List<String> lines = readLines(content);
        lines = format.preprocess(lines);

        int imported = 0;
        int rejected = 0;
        for (String line : lines) {
            GradeRecord record = format.parse(line);
            String reason = validate(record);
            if (reason == null) {
                repository.save(record);
                imported++;
            } else {
                System.out.println("  rejected (" + reason + "): " + line);
                format.onRejected(line);
                rejected++;
            }
        }
        AuditLog.record(format.name(), imported, rejected);
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
}
