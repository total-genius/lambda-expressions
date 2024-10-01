package _1_lambda_expressions_introduction;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private char gender;
    private int course;
    private double averageGrade;

    public Student(String name, int age, char gender, int course, double averageGrade) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public int getCourse() {
        return course;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", course=" + course +
                ", averageGrade=" + averageGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && gender == student.gender && course == student.course && Double.compare(averageGrade, student.averageGrade) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, course, averageGrade);
    }
}
