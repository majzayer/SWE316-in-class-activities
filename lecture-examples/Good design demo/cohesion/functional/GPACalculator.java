import java.util.List;

/**
 * Functional cohesion example: the class has one well-defined purpose.
 */
public class GPACalculator {
    public double calculateGPA(List<Grade> grades) {
        double total = 0;
        for (Grade grade : grades) {
            total += grade.getValue();
        }
        return total / grades.size();
    }


    public double calculateGPA_withSideEffects(List<Grade> grades) {
        double total = 0;
        for (Grade grade : grades) {
            total += grade.getValue();
        }
        double gpa = total / grades.size();
        database.updateGPA(gpa);
        reportGenerator.generateReport(gpa);
        return gpa;
    }
}