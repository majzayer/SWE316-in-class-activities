package cohesion.layer.threeLayer.presentation;

import cohesion.layer.threeLayer.business.AcademicServiceImpl;
import cohesion.layer.threeLayer.business.RegistrarServiceImpl;
import cohesion.layer.threeLayer.data.DatabaseCourseRegistrationRepository;
import cohesion.layer.threeLayer.data.DatabaseStudentRepository;
import cohesion.layer.threeLayer.data.StudentRecord;
import cohesion.layer.threeLayer.data.StudentRepository;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        StudentRepository repository = new DatabaseStudentRepository();
        repository.save(new StudentRecord(
                "S1001",
                "Aisha Khan",
                List.of("SWE316", "ICS202")));

        AcademicController academicController = new AcademicController(
            new AcademicServiceImpl(repository));

        academicController.showTranscript("S1001");
        academicController.registerForClass("S1001", "SWE401");

        RegistrarController registrarController = new RegistrarController(
            new RegistrarServiceImpl(new DatabaseCourseRegistrationRepository(repository)));
        registrarController.addCourse("S1001", "SWE402");
        registrarController.removeCourse("S1001", "SWE402");
    }
}
