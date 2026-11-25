import java.util.List;

/**
 * Alternative B (Strategy): the format-specific steps live in a separate
 * object that the importer is given.
 */
public interface GradeFormat {
    String name();

    GradeRecord parse(String line);

    // Started as a one-method interface (parse). These two had to be added
    // once CSV needed to drop its header and Banner needed an error file.
    // Now EVERY format must implement them, even when it has nothing to do.
    // (Compare with the hooks in the Template Method version.)
    List<String> preprocess(List<String> lines);

    void onRejected(String line);
}
