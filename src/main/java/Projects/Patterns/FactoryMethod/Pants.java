package Projects.Patterns.FactoryMethod;

public class Pants implements Clothes {
    @Override
    public Clothes getClothes() {
        Pants pants = new Pants();
        System.out.println("Pants is created!");
        return pants;
    }
}
