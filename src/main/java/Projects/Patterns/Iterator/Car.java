package Projects.Patterns.Iterator;

import java.util.Iterator;
import java.util.List;

public class Car {
    private List<Driver> drivers;
    private Iterator<Driver> GoodDriverIterator;

    public Car(List<Driver> drivers) {
        this.drivers = drivers;
        this.GoodDriverIterator = new GoodDriverIterator(drivers);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public Iterator<Driver> getGoodDriverIterator() {
        return GoodDriverIterator;
    }
}
