package Projects.Patterns.Decorator;

public class IphoneDecorator implements Iphone {
    private Iphone iphone;
    @Override
    public Integer getPrice() {
        return iphone.getPrice();
    }

    @Override
    public String getModel() {
        return iphone.getModel();
    }

    public IphoneDecorator(Iphone iphone) {
        this.iphone = iphone;
    }
}
