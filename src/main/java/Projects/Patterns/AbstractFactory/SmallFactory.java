package Projects.Patterns.AbstractFactory;

public class SmallFactory implements ChocolateFactory{
    @Override
    public Chocolate generateSnickers() {
        return new LittleSnickers();
    }

    @Override
    public Chocolate generateKitKat() {
        return new LittleKitKat();
    }
}
