package _5_function;

import java.util.List;
import java.util.function.Function;

public class StudentInfo {
    public static Double getAvgGradeOfStudents(List<Student> students, Function<Student, Double> function) {
        double avg = 0;
        for (Student student : students) {
            avg += function.apply(student);
        }
        return avg / students.size();
    }
}
