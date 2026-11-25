import java.time.LocalDate;

public class GradeAppealRequest {
    private final String studentId;
    private final String course;

    public GradeAppealRequest(String studentId, String course) {
        this.studentId = studentId;
        this.course = course;
    }

    public void process(LocalDate today) {
        System.out.println("Grade appeal request from " + studentId + " (" + course + ")");
        if (!verifyStudent()) return;
        if (!checkDeadline(today)) return;
        if (!checkEligibility()) return;
        chargeFee();
        apply();
        notifyStudent();
    }

    private boolean verifyStudent() {
        if (!StudentRecords.isActive(studentId)) {
            reject("not an active student");
            return false;
        }
        return true;
    }

    private boolean checkDeadline(LocalDate today) {
        LocalDate deadline = LocalDate.of(2026, 12, 1);         // two weeks after grades are out
        if (today.isAfter(deadline)) {
            reject("deadline was " + deadline);
            return false;
        }
        return true;
    }

    private boolean checkEligibility() {
        if (!StudentRecords.gradeReleased(studentId, course)) {
            reject("grade not released yet");
            return false;
        }
        if (StudentRecords.alreadyAppealed(studentId, course)) {
            reject("grade already appealed once");
            return false;
        }
        return true;
    }

    private void chargeFee() {
        System.out.println("  charged 100 SAR appeal fee to " + studentId);
    }

    private void apply() {
        System.out.println("  appeal for " + course + " forwarded to the department committee");
    }

    private void notifyStudent() {
        System.out.println("  SMS to " + studentId + ": your appeal for " + course
                + " was sent to the department. Expect a decision within 10 days.");
    }

    private void reject(String reason) {
        System.out.println("  rejected: " + reason);
    }
}
