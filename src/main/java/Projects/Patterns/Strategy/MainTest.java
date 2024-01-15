package Projects.Patterns.Strategy;

public class MainTest {
    public static void main(String[] args) {
        Car bigSportCar = new Car(new BigCar(), new SportCar());
        Car smallSimpleCar = new Car(new SmallCar(), new SimpleCar());

        System.out.println(bigSportCar.getAccommodate());
        System.out.println(bigSportCar.getDrive());
        System.out.println("------------------");

        System.out.println(smallSimpleCar.getAccommodate());
        System.out.println(smallSimpleCar.getDrive());


    }
}
