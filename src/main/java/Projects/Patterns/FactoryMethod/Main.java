package Projects.Patterns.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        DressFactory dressFactory = new DressFactory();
        TShirtFactory tShirtFactory = new TShirtFactory();
        PantsFactory pantsFactory = new PantsFactory();

        dressFactory.createClothes();
        tShirtFactory.createClothes();
        pantsFactory.createClothes();
    }
}
