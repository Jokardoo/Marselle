package Projects.Patterns.Composite;

public class LowManager implements Manager {
    private String name;
    @Override
    public void invite(Manager manager) {
        System.out.println("I can't invite person");
    }

    @Override
    public void getInfo() {
        System.out.println(name);
    }

    public LowManager(String name) {
        this.name = name;
    }
}
