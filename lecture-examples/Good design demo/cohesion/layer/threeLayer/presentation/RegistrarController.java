package cohesion.layer.threeLayer.presentation;

import cohesion.layer.threeLayer.business.RegistrarService;

/** Presentation controller for registrar requests. */
public class RegistrarController {
    private final RegistrarService registrarService;

    public RegistrarController(RegistrarService registrarService) {
        this.registrarService = registrarService;
    }

    public void addCourse(String studentId, String course) {
        System.out.println(registrarService.addCourse(studentId, course));
    }

    public void removeCourse(String studentId, String course) {
        System.out.println(registrarService.removeCourse(studentId, course));
    }
}