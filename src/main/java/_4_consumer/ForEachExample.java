package _4_consumer;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        /*
        Supplier используется в методе
        forEach(Consumer<T> s)
         */

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);
        System.out.println();
        list.forEach(e -> System.out.print(e * 7 + " "));
        System.out.println();

    }
}
