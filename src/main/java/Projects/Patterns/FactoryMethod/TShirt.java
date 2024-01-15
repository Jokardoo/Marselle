package Projects.Patterns.FactoryMethod;

public class TShirt implements Clothes {
    @Override
    public Clothes getClothes() {
        TShirt tShirt = new TShirt();
        System.out.println("T-shirt is created!");
        return tShirt;
    }
}
