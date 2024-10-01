package _6_binaryoperator;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        System.out.println(multiply.apply(2, 3));
        System.out.println(multiply.apply(12, -32));
    }
}
