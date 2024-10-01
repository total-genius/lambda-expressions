package _1_lambda_expressions_introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 20, 'm', 2, 5.4);
        Student st2 = new Student("Elena", 19, 'f', 1, 6.3);
        Student st3 = new Student("Petr", 22, 'm', 4, 3.5);
        Student st4 = new Student("Maria", 21, 'f', 3, 7.4);
        Student st5 = new Student("Alex", 18, 'm', 1, 8.1);
        Student st6 = new Student("Anna", 23, 'f', 4, 6.4);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);


        //Фильтрация по курсу
        /*
        В параметре мы сразу реализуем единственный абстрактный метод
        нашего функционального интерфейса.
         */
        List<Student> courseFilteredStudents = StudentInfo.filter(students, (e) -> {return e.getCourse() < 3;});
        System.out.println(courseFilteredStudents);
        System.out.println();

        //Фильтрация по среднему баллу
        List<Student> avgGradeFilteredStudents = StudentInfo.filter(students, (e) -> {return e.getAverageGrade() > 6.3;});
        System.out.println(avgGradeFilteredStudents);

        /*
        (e) -> {return e.getAverageGrade() > 6.3;} - это тоже можно сократить
        1)если параметров перед стрелкой не больше одного, то можно опустить скобки.
        2)если логика после кода состоит из одной строки фигурные скобки, точку с запятой и return тоже можно опустить.
        e -> return e.getAverageGrade() > 6.3 - вот так
         */

        //Ламбда выражение можно вынести в отдельную перменную
        StudentFilter sf = e -> e.getGender() == 'm';
        //фильрация по гендеру
        List<Student> genderFilteredStudents = StudentInfo.filter(students, sf);
        System.out.println(genderFilteredStudents);
        System.out.println();

        /*
        Поработаем с компаратором как с лямбдой.
        Отсротируем студентов по курсу
         */
        Collections.sort(students, (e1, e2) -> e1.getCourse() - e2.getCourse());
        System.out.println(students);
    }
}
