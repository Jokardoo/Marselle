package Projects.Patterns.TemplateMethod;

public class Main {



    public static void main(String[] args) {
        ECash eCash = new ECash();
        Cash cash = new Cash();

        cash.payProcess();
        System.out.println("-----------------------------------");
        eCash.payProcess();
    }
}
