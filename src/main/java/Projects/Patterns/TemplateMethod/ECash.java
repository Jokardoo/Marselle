package Projects.Patterns.TemplateMethod;

public class ECash implements PayMoney {
    @Override
    public void prepare() {
        System.out.println("Достать карточку");
        System.out.println("=================================================");
    }

    @Override
    public void pay() {
        System.out.println("Оплатить картой");
        System.out.println("=================================================");
    }

    @Override
    public void finish() {
        System.out.println("Убрать карту");
        System.out.println("=================================================");
    }

    @Override
    public void payProcess() {
        prepare();
        pay();
        finish();
    }
}
