package cohesion.layer.threeLayer.business;

/** Business-layer contract used by the presentation layer. */
public interface RegistrarService {
    String addCourse(String studentId, String course);

    String removeCourse(String studentId, String course);
}
