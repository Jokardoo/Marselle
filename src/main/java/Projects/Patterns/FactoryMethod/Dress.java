package Projects.Patterns.FactoryMethod;

public class Dress implements Clothes {

    @Override
    public Clothes getClothes() {
        Dress dress = new Dress();
        System.out.println("Dress is created!");
        return dress;
    }
}
