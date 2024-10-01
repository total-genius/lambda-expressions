package _5_function;

import java.util.ArrayList;
import java.util.List;

public class FunctionExample {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 1, 4.3);
        Student st2 = new Student("Ivan", 2, 5.2);
        Student st3 = new Student("Maria", 3, 4.4);
        Student st4 = new Student("Elena", 2, 6.4);

        List<Student> students = new ArrayList<Student>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);

        //Найдем средний балл по студентам
        System.out.println(StudentInfo.getAvgGradeOfStudents(students, e -> e.getGrade()));

    }
}
