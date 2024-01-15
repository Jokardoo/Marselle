package Projects.Patterns.FactoryMethod;


public class PantsFactory implements ClothesFactory {
    private Pants pants;

    public PantsFactory() {
        this.pants = new Pants();
    }

    @Override
    public Clothes createClothes() {
        return pants.getClothes();
    }
}
