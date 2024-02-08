package Projects.Patterns.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class GoodDriverIterator implements Iterator<Driver> {
    private List<Driver> driverList;
    private int current;

    @Override
    public boolean hasNext() {
        return current > driverList.size() - 1 ? false : true;
    }

    @Override
    public Driver next() {
        if (current == 0 && !driverList.isEmpty()) {
            current++;
            return driverList.get(0);
        }

        Driver currentDriver;
        if (hasNext()) {
            int cur = current;
            current++;
            return driverList.get(cur);
        }
        else {
            return null;
        }
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer action) {
        Iterator.super.forEachRemaining(action);
    }

    public GoodDriverIterator(List driverList) {
        List<Driver> drivers = new ArrayList<>(driverList);

        List<Driver> goodDrivers = drivers.stream()
                .filter(Driver::isGoodDriver)
                .collect(Collectors.toList());
        this.driverList = goodDrivers;
        this.current = 0;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }
}
