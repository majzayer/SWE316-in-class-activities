// Stand-in for the university's student information system.
public class StudentRecords {
    public static boolean isActive(String studentId) {
        return !studentId.equals("201900001");          // graduated student
    }

    public static int creditHours(String studentId) {
        return studentId.equals("202312340") ? 15 : 12;
    }

    public static boolean gradeReleased(String studentId, String course) {
        return true;
    }

    public static boolean alreadyAppealed(String studentId, String course) {
        return course.equals("ICS104");
    }

    public static void recordW(String studentId, String course) {
        System.out.println("  recorded W for " + studentId + " in " + course);
    }

    public static void excuseAbsence(String studentId, String course, java.time.LocalDate date) {
        System.out.println("  absence on " + date + " in " + course + " marked as excused");
    }
}
