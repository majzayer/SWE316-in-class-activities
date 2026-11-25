import java.util.ArrayList;
import java.util.List;

/**
 * Added last semester when the registrar asked us to load the old Banner files.
 */
public class LegacyBannerImporter {
    private final GradeRepository repository;

    public LegacyBannerImporter(GradeRepository repository) {
        this.repository = repository;
    }

    public void importGrades(String content) {
        System.out.println("Importing from Legacy Banner...");
        List<String> lines = readLines(content);

        int imported = 0;
        for (String line : lines) {
            GradeRecord record = parse(line);
            repository.save(record);
            imported++;
        }
        System.out.println("  done, " + imported + " grades loaded");
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

    // fixed-width columns: [0-9) ID, [9-16) course, [16-19) score
    private GradeRecord parse(String line) {
        return new GradeRecord(line.substring(0, 9),
                line.substring(9, 16).trim(),
                Integer.parseInt(line.substring(16, 19).trim()));
    }
}
