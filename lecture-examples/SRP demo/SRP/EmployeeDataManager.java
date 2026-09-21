import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class EmployeeDataManager {
    private final Map<String, Employee> employees = new LinkedHashMap<>();

    public void save(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("employee cannot be null");
        }
        employees.put(employee.getId(), employee);
    }

    public void delete(String id) {
        employees.remove(id);
    }

    public boolean exists(String id) {
        return employees.containsKey(id);
    }

    public int count() {
        return employees.size();
    }

    public Employee findById(String id) {
        return employees.get(id);
    }

    public Map<String, Employee> allEmployees() {
        return Collections.unmodifiableMap(employees);
    }
}
