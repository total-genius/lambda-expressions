package _3_supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CarMaker {
    public static List<Car> makeCars(Supplier<Car> supplier) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(supplier.get());
        }
        return cars;
    }
}
