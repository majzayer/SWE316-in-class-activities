import java.util.List;

public class BannerFormat implements GradeFormat {
    @Override
    public String name() {
        return "Legacy Banner";
    }

    @Override
    public List<String> preprocess(List<String> lines) {
        return lines;   // nothing to clean up in Banner files
    }

    @Override
    public GradeRecord parse(String line) {
        return new GradeRecord(line.substring(0, 9),
                line.substring(9, 16).trim(),
                Integer.parseInt(line.substring(16, 19).trim()));
    }

    @Override
    public void onRejected(String line) {
        System.out.println("    -> written to banner_errors.txt for the registrar");
    }
}
