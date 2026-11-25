import java.time.LocalDate;

public class AbsenceExcuseRequest {
    private final String studentId;
    private final String course;
    private final LocalDate absenceDate;
    private final boolean hasMedicalReport;

    public AbsenceExcuseRequest(String studentId, String course,
                                LocalDate absenceDate, boolean hasMedicalReport) {
        this.studentId = studentId;
        this.course = course;
        this.absenceDate = absenceDate;
        this.hasMedicalReport = hasMedicalReport;
    }

    public void process(LocalDate today) {
        System.out.println("Absence excuse request from " + studentId + " (" + course + ")");
        if (!verifyStudent()) return;
        if (!checkDeadline(today)) return;
        if (!checkEligibility()) return;
        apply();
        notifyStudent();
        AuditLog.record("Absence excuse", studentId);
    }

    private boolean verifyStudent() {
        if (!StudentRecords.isActive(studentId)) {
            reject("not an active student");
            return false;
        }
        return true;
    }

    private boolean checkDeadline(LocalDate today) {
        LocalDate deadline = absenceDate.plusDays(7);           // one week after the absence
        if (today.isAfter(deadline)) {
            reject("deadline was " + deadline);
            return false;
        }
        return true;
    }

    private boolean checkEligibility() {
        if (!hasMedicalReport) {
            reject("no medical report attached");
            return false;
        }
        return true;
    }

    private void apply() {
        StudentRecords.excuseAbsence(studentId, course, absenceDate);
    }

    private void notifyStudent() {
        System.out.println("  SMS to " + studentId + ": your request was approved.");
    }

    private void reject(String reason) {
        System.out.println("  rejected: " + reason);
    }
}
