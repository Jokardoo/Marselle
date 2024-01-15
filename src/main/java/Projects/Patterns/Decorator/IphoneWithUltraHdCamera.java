package Projects.Patterns.Decorator;

public class IphoneWithUltraHdCamera extends IphoneDecorator{
    public IphoneWithUltraHdCamera(Iphone iphone) {
        super(iphone);
    }

    @Override
    public Integer getPrice() {
        return super.getPrice() + 15;
    }

    @Override
    public String getModel() {
        return super.getModel() + " with Ultra HD camera";
    }
}
