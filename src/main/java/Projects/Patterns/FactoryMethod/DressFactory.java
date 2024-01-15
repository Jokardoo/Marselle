package Projects.Patterns.FactoryMethod;

public class DressFactory implements ClothesFactory {
    private Dress dress;

    public DressFactory() {
        this.dress = new Dress();
    }

    @Override
    public Clothes createClothes() {
        return dress.getClothes();
    }
}
