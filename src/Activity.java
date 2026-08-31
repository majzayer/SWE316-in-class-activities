public class Activity {
    private Course course;
    private Classroom classroom;
    private String term;
    private String days;
    private int start;
    private int end;
    private String section;
    private String type;

    public Activity(Course course, Classroom classroom, String term, String days,
                    int start, int end, String section, String type) {
        this.course = course;
        this.classroom = classroom;
        this.term = term;
        this.days = days;
        this.start = start;
        this.end = end;
        this.section = section;
        this.type = type;
    }

    public Course getCourse() {
        return course;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public String getTerm() {
        return term;
    }

    public String getDays() {
        return days;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getSection() {
        return section;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return course.getName() + " - " + course.getDepartment() + " - Section " + section +
                " - " + type + " - " + days + " - " + start + ":00 to " + end + ":00";
    }
}
