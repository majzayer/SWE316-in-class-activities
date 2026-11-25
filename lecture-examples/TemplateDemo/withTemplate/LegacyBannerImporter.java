public class LegacyBannerImporter extends GradeImporter {

    public LegacyBannerImporter(GradeRepository repository) {
        super(repository);
    }

    @Override
    protected String sourceName() {
        return "Legacy Banner";
    }

    @Override
    protected GradeRecord parse(String line) {
        return new GradeRecord(line.substring(0, 9),
                line.substring(9, 16).trim(),
                Integer.parseInt(line.substring(16, 19).trim()));
    }

    // hook: the registrar wants rejected Banner lines sent back to them
    @Override
    protected void onRejected(String line) {
        System.out.println("    -> written to banner_errors.txt for the registrar");
    }

    // DEMO: uncomment the method below. It will not compile, because the
    // template method is final. A subclass cannot skip validation any more.
    //
    // @Override
    // public void importGrades(String content) {
    //     System.out.println("Loading Banner grades without validation...");
    // }
}
