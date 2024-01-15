package Projects.Patterns.Decorator;

public class Main {
    public static void main(String[] args) {
        Iphone iphone7 = new Iphone7();
        System.out.println(iphone7.getModel());
        System.out.println(iphone7.getPrice());
        System.out.println("---------------------------------------------");

        iphone7 = new IphoneWithLargeMemory(iphone7);
        System.out.println(iphone7.getModel());
        System.out.println(iphone7.getPrice());
        System.out.println("---------------------------------------------");

        iphone7 = new IphoneWithUltraHdCamera(iphone7);
        System.out.println(iphone7.getModel());
        System.out.println(iphone7.getPrice());
        System.out.println("---------------------------------------------");
    }
}
