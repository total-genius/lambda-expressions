package _2_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        Student st1 = new Student("Ivan", 3, 4.5);
        Student st2 = new Student("Elena", 1, 6.8);
        Student st3 = new Student("Michael", 2, 5.4);
        Student st4 = new Student("Michael", 4, 4.8);
        Student st5 = new Student("John", 5, 8.2);

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        //Фильтрация по грейду
        List<Student> gradeFilteredStudents = StudentFilter.filter(students, e -> e.getGrade() > 5.5);
        System.out.println(gradeFilteredStudents);
        System.out.println();


        /*
        Можно объеденить две фильтрации в одну
        слудующим образом
         */

        /*
        /Создадим и объеденим 2 фильтрации так,
        чтобы отобрались только те, элементы которые удовлеворяют двум условиям
         */
        Predicate<Student> p1 = e -> e.getGrade() > 5.5 ;
        Predicate<Student> p2 = e -> e.getCourse() > 2;
        List<Student> unitedFilteredStudents = StudentFilter.filter(students, p1.and(p2));
        System.out.println(unitedFilteredStudents);
        System.out.println();

        /*
        /Создадим и объеденим 2 фильтрации так,
        чтобы отобрались те элементы которые удовлеворяют одному
         из двух условий
         */
        Predicate<Student> p3 = e -> e.getCourse() > 3;
        Predicate<Student> p4 = e -> e.getGrade() > 5.5;
        List<Student> unitedFilter = StudentFilter.filter(students, p3.or(p4));
        System.out.println(unitedFilter);
        System.out.println();

        /*
        Еще есть метод отрицания проверки
         */
        List<Student> negateFilter = StudentFilter.filter(students, p3.negate());
        System.out.println(negateFilter);
    }
}
