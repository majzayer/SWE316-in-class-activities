public class GradeRecord {
    private final String studentId;
    private final String course;
    private final int score;

    public GradeRecord(String studentId, String course, int score) {
        this.studentId = studentId;
        this.course = course;
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return studentId + "  " + course + "  " + score;
    }
}
