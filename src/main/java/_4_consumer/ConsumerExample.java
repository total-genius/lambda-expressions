package _4_consumer;

import java.util.ArrayList;
import java.util.List;

public class ConsumerExample {
    public static void main(String[] args) {
        List<Car> cars = CarConstructor.makeCars(() -> new Car("BMW", 2022, "white", 2.5));
        System.out.println(cars);
        System.out.println();
        CarConstructor.changeCar(cars.get(0), e-> {
            e.setColor("Black");
            e.setEngine(3.0);
        });
        System.out.println(cars);

    }
}
