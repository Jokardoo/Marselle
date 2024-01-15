package Projects.Patterns.Decorator;

public class Iphone7 implements Iphone {

    @Override
    public Integer getPrice() {
        return 50;
    }

    @Override
    public String getModel() {
        return "Iphone 7";
    }
}
