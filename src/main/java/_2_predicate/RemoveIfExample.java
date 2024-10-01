package _2_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        /*
        Predicate используется методом  коллекций removeIf(Predicate<T> filter)
         */
        list.add(3);
        list.add(4);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(1);
        list.add(2);
        System.out.println(list);
        System.out.println();

        //Удалим четные числа
        list.removeIf(e -> e % 2 == 0);
        System.out.println(list);
        /*
        Метод прошелся по всем элементам коллекции
        и удалил те элементы, которые удовлетворили
        условию
         */




    }
}
