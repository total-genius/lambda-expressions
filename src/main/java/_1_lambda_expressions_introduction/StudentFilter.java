package _1_lambda_expressions_introduction;

@FunctionalInterface
public interface StudentFilter {
    boolean check(Student student);
}
