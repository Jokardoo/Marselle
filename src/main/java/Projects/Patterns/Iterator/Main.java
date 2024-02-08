package Projects.Patterns.Iterator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Driver> driverList = new ArrayList<>();
        driverList.add(new Driver(true, "Bob"));
        driverList.add(new Driver(true, "Hank"));
        driverList.add(new Driver(false, "Jimmy"));
        driverList.add(new Driver(true, "Rick"));
        driverList.add(new Driver(false, "Molly"));
        driverList.add(new Driver(false, "George"));

        Car car = new Car(driverList);

        for (Driver driver : car.getDrivers()) {
            System.out.println(driver.getName());
        }

        System.out.println("===========================");

        while (car.getGoodDriverIterator().hasNext()) {
            System.out.println(car.getGoodDriverIterator().next().getName());
        }
    }

}
