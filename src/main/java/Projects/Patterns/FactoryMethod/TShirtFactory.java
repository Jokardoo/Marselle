package Projects.Patterns.FactoryMethod;

public class TShirtFactory implements ClothesFactory {

    private TShirt tShirt;

    public TShirtFactory() {
        this.tShirt = new TShirt();
    }

    @Override
    public Clothes createClothes() {
        return tShirt.getClothes();
    }
}
