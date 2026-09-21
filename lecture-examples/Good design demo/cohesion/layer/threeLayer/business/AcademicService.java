package cohesion.layer.threeLayer.business;

/** Business-layer contract used by the presentation layer. */
public interface AcademicService {
    String showTranscript(String studentId);

    String registerForClass(String studentId, String className);
}
