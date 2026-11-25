import java.util.List;

public class CsvFormat implements GradeFormat {
    @Override
    public String name() {
        return "Blackboard CSV";
    }

    @Override
    public List<String> preprocess(List<String> lines) {
        return lines.subList(1, lines.size());   // drop the header row
    }

    @Override
    public GradeRecord parse(String line) {
        String[] parts = line.split(",");
        return new GradeRecord(parts[0], parts[1], Integer.parseInt(parts[2]));
    }

    @Override
    public void onRejected(String line) {
        // nothing to do for CSV
    }
}
