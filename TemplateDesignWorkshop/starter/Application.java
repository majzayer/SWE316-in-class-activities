import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2026, 11, 18);

        new DropCourseRequest("202312340", "MATH201").process(today);
        new DropCourseRequest("202312340", "SWE316").process(today);    // advisor says no
        System.out.println();

        new AbsenceExcuseRequest("202298761", "ICS202", LocalDate.of(2026, 11, 15), true).process(today);
        new AbsenceExcuseRequest("202298761", "ICS202", LocalDate.of(2026, 11, 2), true).process(today);  // too late
        System.out.println();

        new GradeAppealRequest("202298761", "SWE316").process(today);
        new GradeAppealRequest("202298761", "ICS104").process(today);   // already appealed
    }
}
