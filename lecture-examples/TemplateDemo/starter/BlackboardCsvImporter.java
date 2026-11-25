import java.util.ArrayList;
import java.util.List;

public class BlackboardCsvImporter {
    private final GradeRepository repository;

    public BlackboardCsvImporter(GradeRepository repository) {
        this.repository = repository;
    }

    public void importGrades(String content) {
        System.out.println("Importing from Blackboard CSV...");
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
        AuditLog.record("Blackboard CSV", imported, rejected);
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

    // drop the header row
    private List<String> preprocess(List<String> lines) {
        return lines.subList(1, lines.size());
    }

    private GradeRecord parse(String line) {
        String[] parts = line.split(",");
        return new GradeRecord(parts[0], parts[1], Integer.parseInt(parts[2]));
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
