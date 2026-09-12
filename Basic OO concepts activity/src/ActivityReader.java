public interface ActivityReader {
    void readActivities();
    Activity[] getActivitiesFor(Classroom selectedClassroom);
}
