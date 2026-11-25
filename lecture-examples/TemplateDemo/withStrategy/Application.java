public class Application {
    public static void main(String[] args) {
        GradeRepository repository = new GradeRepository();
        GradeImporter importer = new GradeImporter(repository, new CsvFormat());

        importer.importGrades(SampleData.BLACKBOARD_CSV);
        System.out.println();

        importer.setFormat(new JsonFormat());
        importer.importGrades(SampleData.LMS_JSON);
        System.out.println();

        importer.setFormat(new BannerFormat());
        importer.importGrades(SampleData.BANNER_FIXED_WIDTH);
        System.out.println();

        repository.printAll();
    }
}
