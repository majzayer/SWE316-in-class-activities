public class Application {
    public static void main(String[] args) {
        GradeRepository repository = new GradeRepository();

        new BlackboardCsvImporter(repository).importGrades(SampleData.BLACKBOARD_CSV);
        System.out.println();

        new LmsJsonImporter(repository).importGrades(SampleData.LMS_JSON);
        System.out.println();

        new LegacyBannerImporter(repository).importGrades(SampleData.BANNER_FIXED_WIDTH);
        System.out.println();

        repository.printAll();
    }
}
