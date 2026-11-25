import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonFormat implements GradeFormat {
    @Override
    public String name() {
        return "LMS JSON";
    }

    // drop the [ and ] lines around the records
    @Override
    public List<String> preprocess(List<String> lines) {
        return lines.stream()
                .filter(line -> !line.equals("[") && !line.equals("]"))
                .toList();
    }

    @Override
    public GradeRecord parse(String line) {
        Matcher m = jsonFields(line);
        return new GradeRecord(m.group(1), m.group(2), Integer.parseInt(m.group(3)));
    }

    @Override
    public void onRejected(String line) {
        // nothing to do for JSON
    }

    // Pulls studentId, course and score out of one JSON line (groups 1, 2, 3).
    private static Matcher jsonFields(String line) {
        Matcher m = Pattern.compile(
                "\"studentId\":\"(\\w+)\",\"course\":\"(\\w+)\",\"score\":(-?\\d+)")
                .matcher(line);
        if (!m.find()) {
            throw new IllegalArgumentException("Malformed JSON record: " + line);
        }
        return m;
    }
}
