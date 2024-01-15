package Projects.Patterns.AbstractFactory;

public class BigFactory implements ChocolateFactory {
    @Override
    public Chocolate generateSnickers() {
        return new BigSnickers();
    }

    @Override
    public Chocolate generateKitKat() {
        return new BigKitKat();
    }
}
