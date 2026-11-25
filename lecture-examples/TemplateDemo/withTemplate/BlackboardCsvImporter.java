import java.util.List;

public class BlackboardCsvImporter extends GradeImporter {

    public BlackboardCsvImporter(GradeRepository repository) {
        super(repository);
    }

    @Override
    protected String sourceName() {
        return "Blackboard CSV";
    }

    // hook: CSV files start with a header row
    @Override
    protected List<String> preprocess(List<String> lines) {
        return lines.subList(1, lines.size());
    }

    @Override
    protected GradeRecord parse(String line) {
        String[] parts = line.split(",");
        return new GradeRecord(parts[0], parts[1], Integer.parseInt(parts[2]));
    }
}
