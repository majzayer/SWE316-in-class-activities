package cohesion.layer.threeLayer.presentation;

import cohesion.layer.threeLayer.business.AcademicService;

/** Presentation controller for academic requests. */
public class AcademicController {
    private final AcademicService academicService;

    public AcademicController(AcademicService academicService) {
        this.academicService = academicService;
    }

    public void showTranscript(String studentId) {
        System.out.println(academicService.showTranscript(studentId));
    }

    public void registerForClass(String studentId, String className) {
        System.out.println(academicService.registerForClass(studentId, className));
    }
}