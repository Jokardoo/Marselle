package Projects.Patterns.TemplateMethod;

public class Cash implements PayMoney {
    @Override
    public void prepare() {
        System.out.println("Достать наличку");
        recalculateCash();
        System.out.println("=================================================");
    }

    @Override
    public void pay() {
        System.out.println("Оплатить наличными");
        System.out.println("=================================================");
    }

    @Override
    public void finish() {
        System.out.println("Сложить сдачу в кошелек");
        System.out.println("=================================================");
    }

    @Override
    public void payProcess() {
        prepare();
        pay();
        finish();
    }

    public void recalculateCash() {
        System.out.println("Пересчитываю деньги");
    }
}
