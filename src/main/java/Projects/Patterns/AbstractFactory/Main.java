package Projects.Patterns.AbstractFactory;

public class Main {

    public static void main(String[] args) {
        SmallFactory smallFactory = new SmallFactory();
        BigFactory bigFactory = new BigFactory();

        System.out.println(smallFactory.generateKitKat().getName());
        System.out.println(bigFactory.generateSnickers().getName());
    }
}
