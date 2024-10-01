package _3_supplier;


import java.util.List;

public class SupplierExample {
    public static void main(String[] args) {
        List<Car> cars = CarMaker.makeCars(() -> new Car("Toyota", "black", 2023));
        System.out.println(cars);
    }
}
