package Projects.Patterns.Composite;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Manager bigManager1 = new BigManager("Boss", new ArrayList<>());
        Manager bigManager2_1 = new BigManager("Second boss", new ArrayList<>());
        Manager bigManager2_2 = new BigManager("Im second boss too!", new ArrayList<>());
        Manager bigManager2_3 = new BigManager("Mariarty", new ArrayList<>());
        Manager bigManager3_1 = new LowManager("First");
        Manager bigManager3_2 = new LowManager("Second");
        Manager bigManager3_3 = new LowManager("Third");
        Manager bigManager3_4 = new LowManager("Low");

        bigManager1.invite(bigManager2_1);
        bigManager1.invite(bigManager2_2);
        bigManager1.invite(bigManager2_3);

        bigManager2_1.invite(bigManager3_1);
        bigManager2_2.invite(bigManager3_2);
        bigManager2_3.invite(bigManager3_3);
        bigManager2_3.invite(bigManager3_4);

        bigManager1.getInfo();

    }
}
