import java.util.ArrayList;
import java.util.List;

/**
 * AbstractClass in the Template Method pattern.
 *
 * importGrades() is the template method: it fixes the order of the steps
 * and owns the steps that must never vary (validate, save, audit).
 * Subclasses fill in only the steps that differ between formats.
 */
public abstract class GradeImporter {
    private final GradeRepository repository;

    protected GradeImporter(GradeRepository repository) {
        this.repository = repository;
    }

    // ---------------------------------------------------------------
    // The template method. "final" so that no subclass can reorder the
    // steps or skip validation and auditing.
    // ---------------------------------------------------------------
    public final void importGrades(String content) {
        System.out.println("Importing from " + sourceName() + "...");
        List<String> lines = readLines(content);
        lines = preprocess(lines);                  // hook

        int imported = 0;
        int rejected = 0;
        for (String line : lines) {
            GradeRecord record = tryParse(line);    // calls the primitive operation
            String reason = (record == null) ? "unparseable" : validate(record);
            if (reason == null) {
                repository.save(record);
                imported++;
            } else {
                System.out.println("  rejected (" + reason + "): " + line);
                onRejected(line);                   // hook
                rejected++;
            }
        }
        AuditLog.record(sourceName(), imported, rejected);
    }

    // ---------------------------------------------------------------
    // Primitive operations: every subclass MUST implement these.
    // ---------------------------------------------------------------
    protected abstract String sourceName();

    protected abstract GradeRecord parse(String line);

    // ---------------------------------------------------------------
    // Hooks: default behaviour is fine for most subclasses; override
    // only if you need to "hook into" the algorithm at that point.
    // ---------------------------------------------------------------
    protected List<String> preprocess(List<String> lines) {
        return lines;
    }

    protected void onRejected(String line) {
        // do nothing by default
    }

    // ---------------------------------------------------------------
    // Invariant steps: private, so subclasses cannot change them.
    // ---------------------------------------------------------------
    private List<String> readLines(String content) {
        List<String> lines = new ArrayList<>();
        for (String line : content.split("\n")) {
            if (!line.isBlank()) {
                lines.add(line);
            }
        }
        return lines;
    }

    // Guards every subclass, including ones written later: if parse() fails
    // (a malformed line, or a CSV header left in because preprocess() was not
    // overridden), the line is rejected instead of crashing the whole import.
    private GradeRecord tryParse(String line) {
        try {
            return parse(line);
        } catch (RuntimeException e) {
            // return null for simplicity; could also log the exception if desired
            System.out.println("  parse error: " + line);
            return null;
        }
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
