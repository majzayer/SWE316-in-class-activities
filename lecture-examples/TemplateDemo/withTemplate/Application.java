public class Application {
    public static void main(String[] args) {
        GradeRepository repository = new GradeRepository();

        GradeImporter[] importers = {
                new BlackboardCsvImporter(repository),
                new LmsJsonImporter(repository),
                new LegacyBannerImporter(repository)
        };
        String[] files = {
                SampleData.BLACKBOARD_CSV,
                SampleData.LMS_JSON,
                SampleData.BANNER_FIXED_WIDTH
        };

        for (int i = 0; i < importers.length; i++) {
            importers[i].importGrades(files[i]);   // "Don't call us, we'll call you"
            System.out.println();
        }

        repository.printAll();
    }
}
