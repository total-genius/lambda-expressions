package _2_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StudentFilter {
    public static List<Student> filter(List<Student> students, Predicate<Student> predicate) {
        List<Student> filteredStudents = new ArrayList<Student>();
        for (Student student : students) {
            if (predicate.test(student)) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
}
