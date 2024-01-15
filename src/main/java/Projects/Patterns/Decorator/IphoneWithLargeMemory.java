package Projects.Patterns.Decorator;

public class IphoneWithLargeMemory extends IphoneDecorator {

    public IphoneWithLargeMemory(Iphone iphone) {
        super(iphone);
    }

    @Override
    public Integer getPrice() {
        return super.getPrice() + 10;
    }

    @Override
    public String getModel() {
        return super.getModel() + " with large memory";
    }
}
