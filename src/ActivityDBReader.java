import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActivityDBReader implements ActivityReader {
    private static final String DEFAULT_QUERY =
            "SELECT course_number, course_name, instructor, department, "
                    + "room, building, term, days, start_hour, end_hour, section, type "
                    + "FROM activities";

    private String url;
    private String username;
    private String password;
    private String query;
    private final List<Activity> activities = new ArrayList<>();

    public ActivityDBReader(String url, String username, String password) {
        this(url, username, password, DEFAULT_QUERY);
    }

    public ActivityDBReader(String url, String username, String password, String query) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.query = query;
        readActivities();
    }

    @Override
    public void readActivities() {
        activities.clear();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                Course course = new Course(
                        results.getInt("course_number"),
                        results.getString("course_name"),
                        results.getString("instructor"),
                        results.getString("department"));
                Classroom classroom = new Classroom(
                        results.getInt("room"),
                        results.getInt("building"));
                activities.add(new Activity(
                        course,
                        classroom,
                        results.getString("term"),
                        results.getString("days"),
                        results.getInt("start_hour"),
                        results.getInt("end_hour"),
                        results.getString("section"),
                        results.getString("type")));
            }
        } catch (SQLException exception) {
            throw new IllegalStateException("Unable to read activities from Oracle", exception);
        }
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
