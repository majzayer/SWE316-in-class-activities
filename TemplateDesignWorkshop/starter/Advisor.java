// Stand-in for the academic advisor's approval in the e-services portal.
public class Advisor {
    public static boolean approves(String studentId, String course) {
        return !course.equals("SWE316");                // the advisor says: keep SWE316!
    }
}
