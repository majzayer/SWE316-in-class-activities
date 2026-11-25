import java.time.LocalDate;

public class DropCourseRequest {
    private final String studentId;
    private final String course;

    public DropCourseRequest(String studentId, String course) {
        this.studentId = studentId;
        this.course = course;
    }

    public void process(LocalDate today) {
        System.out.println("Drop course request from " + studentId + " (" + course + ")");
        if (!verifyStudent()) return;
        if (!checkDeadline(today)) return;
        if (!checkEligibility()) return;
        if (!getAdvisorApproval()) return;
        apply();
        notifyStudent();
        AuditLog.record("Drop course", studentId);
    }

    private boolean verifyStudent() {
        if (!StudentRecords.isActive(studentId)) {
            reject("not an active student");
            return false;
        }
        return true;
    }

    private boolean checkDeadline(LocalDate today) {
        LocalDate deadline = LocalDate.of(2026, 11, 20);        // last day to drop with W
        if (today.isAfter(deadline)) {
            reject("deadline was " + deadline);
            return false;
        }
        return true;
    }

    private boolean checkEligibility() {
        if (StudentRecords.creditHours(studentId) - 3 < 12) {
            reject("would fall below 12 credit hours");
            return false;
        }
        return true;
    }

    private boolean getAdvisorApproval() {
        if (!Advisor.approves(studentId, course)) {
            reject("advisor did not approve");
            return false;
        }
        return true;
    }

    private void apply() {
        StudentRecords.recordW(studentId, course);
    }

    private void notifyStudent() {
        System.out.println("  SMS to " + studentId + ": your request to drop " + course
                + " was approved. A W will appear on your transcript.");
    }

    private void reject(String reason) {
        System.out.println("  rejected: " + reason);
    }
}
