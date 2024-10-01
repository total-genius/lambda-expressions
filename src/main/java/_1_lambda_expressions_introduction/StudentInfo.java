package _1_lambda_expressions_introduction;

import java.util.ArrayList;
import java.util.List;

public class StudentInfo {
    public static List<Student> filter(List<Student> students, StudentFilter filter) {
        List<Student> filteredStudents = new ArrayList<Student>();
        for (Student student : students) {
            if (filter.check(student)) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
}
