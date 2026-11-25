public class Application {
    public static void main(String[] args) {
        GradeRepository repository = new GradeRepository();
        GradeImporter importer = new GradeImporter(repository);

        importer.importGrades(Format.CSV, SampleData.BLACKBOARD_CSV);
        System.out.println();

        importer.importGrades(Format.JSON, SampleData.LMS_JSON);
        System.out.println();

        importer.importGrades(Format.BANNER, SampleData.BANNER_FIXED_WIDTH);
        System.out.println();

        repository.printAll();
    }
}
