import java.util.ArrayList;
import java.util.List;

public class ActivityFileReader implements ActivityReader {
    private String path;
    private List<Activity> activities = new ArrayList<>();

    public ActivityFileReader(String path) {
        this.path = path;
        readActivities();
    }

    public String getPath() {
        return path;
    }

    @Override
    public void readActivities() {
        activities.clear();

        Course swe206 = new Course(206, "Introduction to Software Engineering", "HAMOUD ALJAMAAN", "Software Engineering");
        Course swe216 = new Course(216, "Software Requirements Engineering", "SAAD EZZINI", "Software Engineering");
        Course swe316 = new Course(316, "Software Design and Construction", "MAJED ALZAYER", "Software Engineering");
        Course swe363 = new Course(363, "Web Engineering & Development", "MUHAMMAD FAISAL ABDULRAZZAK", "Software Engineering");
        Course swe422 = new Course(422, "Usability Engineering", "MAJED ALZAYER", "Software Engineering");
        Course swe326 = new Course(326, "Software Testing", "MANSOUR ALHARTHI", "Software Engineering");
        Course swe463 = new Course(463, "Mobile Application Development", "HASAN AL-KAF", "Software Engineering");

        Classroom room244_24 = new Classroom(244, 24);
        Classroom room165_24 = new Classroom(165, 24);
        Classroom room125_24 = new Classroom(125, 24);
        Classroom room334_22 = new Classroom(334, 22);
        Classroom room231_22 = new Classroom(231, 22);
        Classroom room125_22 = new Classroom(125, 22);
        Classroom room240_24 = new Classroom(240, 24);
        Classroom room178_24 = new Classroom(178, 24);

        // Building 24 activities
        activities.add(new Activity(swe206, room244_24, "Fall 2026", "Mon/Wed", 8, 9, "01", "Lecture"));
        activities.add(new Activity(swe206, room244_24, "Fall 2026", "Mon/Wed", 9, 10, "02", "Lecture"));
        activities.add(new Activity(swe206, room165_24, "Fall 2026", "Mon/Wed", 11, 12, "03", "Lecture"));
        activities.add(new Activity(swe206, room125_24, "Fall 2026", "Mon/Wed", 12, 13, "04", "Lecture"));
        
        // Building 22, Room 334 activities
        activities.add(new Activity(swe206, room334_22, "Fall 2026", "Sun", 14, 17, "51", "Lab"));
        activities.add(new Activity(swe206, room334_22, "Fall 2026", "Mon", 14, 17, "52", "Lab"));
        activities.add(new Activity(swe206, room334_22, "Fall 2026", "Tue", 14, 17, "53", "Lab"));
        
        // Building 22, Room 231 activities
        activities.add(new Activity(swe363, room231_22, "Fall 2026", "Mon/Wed", 8, 9, "01", "Lecture"));
        activities.add(new Activity(swe363, room231_22, "Fall 2026", "Mon/Wed", 9, 10, "02", "Lecture"));
        
        // Building 22, Room 125 activities - MAIN CLASSROOM
        activities.add(new Activity(swe216, room125_22, "Fall 2026", "Sun/Tue/Thu", 8, 9, "01", "Lecture"));
        activities.add(new Activity(swe316, room125_22, "Fall 2026", "Sun/Tue/Thu", 8, 9, "01", "Lecture"));
        activities.add(new Activity(swe316, room125_22, "Fall 2026", "Sun/Tue/Thu", 9, 10, "02", "Lecture"));
        activities.add(new Activity(swe206, room125_22, "Fall 2026", "Mon/Wed", 10, 11, "F11", "Lecture"));
        activities.add(new Activity(swe326, room125_22, "Fall 2026", "Mon/Wed", 11, 12, "01", "Lecture"));
        activities.add(new Activity(swe463, room125_22, "Fall 2026", "Sun/Tue/Thu", 10, 11, "01", "Lecture"));
        activities.add(new Activity(swe216, room125_22, "Fall 2026", "Sun/Tue/Thu", 11, 12, "F11", "Lecture"));
        activities.add(new Activity(swe206, room125_22, "Fall 2026", "Sun/Tue/Thu", 13, 14, "F12", "Lecture"));
        activities.add(new Activity(swe363, room125_22, "Fall 2026", "Sun/Tue/Thu", 14, 15, "F11", "Lecture"));
        
        // Building 24, Other rooms activities
        activities.add(new Activity(swe316, room240_24, "Fall 2026", "Sun/Tue/Thu", 11, 12, "F11", "Lecture"));
        activities.add(new Activity(swe422, room178_24, "Fall 2026", "Sun/Tue/Thu", 11, 12, "01", "Lecture"));
        activities.add(new Activity(swe422, room240_24, "Fall 2026", "Sun/Tue/Thu", 10, 11, "F11", "Lecture"));
    }

    @Override
    public Activity[] getActivitiesFor(Classroom selectedClassroom) {
        List<Activity> results = new ArrayList<>();
        for (Activity activity : activities) {
            if (activity.getClassroom().equals(selectedClassroom)) {
                results.add(activity);
            }
        }
        return results.toArray(new Activity[0]);
    }
}
