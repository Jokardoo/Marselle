package Projects.Patterns.Composite;

import java.util.List;

public class BigManager implements Manager {
    private String name;
    private List<Manager> managerList;

    @Override
    public void invite(Manager manager) {
        managerList.add(manager);
    }

    @Override
    public void getInfo() {
        System.out.println(name);

        for (Manager manager : managerList) {
            manager.getInfo();
        }
    }

    public BigManager(String name, List<Manager> managerList) {
        this.name = name;
        this.managerList = managerList;
    }
}
