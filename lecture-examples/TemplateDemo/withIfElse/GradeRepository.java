import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Stands in for the department database: it knows who is enrolled in what,
 * and it stores the grades that were imported.
 */
public class GradeRepository {
    private final Map<String, Set<String>> enrollments = new HashMap<>();
    private final List<GradeRecord> savedGrades = new ArrayList<>();

    public GradeRepository() {
        enroll("202312340", "SWE316");
        enroll("202298761", "SWE316");
        enroll("202311111", "SWE316");

        enroll("202312340", "ICS202");
        enroll("202298761", "ICS202");

        enroll("202312340", "MATH201");
        enroll("202298761", "MATH201");
    }

    public void enroll(String studentId, String course) {
        enrollments.computeIfAbsent(studentId, id -> new HashSet<>()).add(course);
    }

    public boolean isEnrolled(String studentId, String course) {
        return enrollments.getOrDefault(studentId, Set.of()).contains(course);
    }

    public void save(GradeRecord record) {
        savedGrades.add(record);
    }

    public void printAll() {
        System.out.println("---- Grades stored in the database ----");
        for (GradeRecord record : savedGrades) {
            System.out.println("  " + record);
        }
        System.out.println("---------------------------------------");
    }
}
