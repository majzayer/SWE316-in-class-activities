package cohesion.layer.threeLayer.data;

import java.util.HashMap;
import java.util.Map;

/** Database-backed data-layer implementation for demonstration purposes. */
public class DatabaseStudentRepository implements StudentRepository {
    private final Map<String, StudentRecord> records = new HashMap<>();

    @Override
    public void save(StudentRecord record) {
        records.put(record.getStudentId(), record);
    }

    @Override
    public StudentRecord findById(String studentId) {
        return records.get(studentId);
    }
}