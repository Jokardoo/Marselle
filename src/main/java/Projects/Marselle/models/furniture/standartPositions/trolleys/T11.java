package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class T11 extends Product {
    private final Product t11;

    public T11() {
        this.t11 = getT11();
    }

    // Платформа с толстой кромкой
    public static Chipboard getPlatformWithFatEdging() {
        Chipboard platform = new Chipboard();
        platform.setName("Платформа с толстой кромкой");
        platform.setLength(450);
        platform.setWidth(300);
        platform.setEdgingRed();   // красной в круг

        return platform;
    }

    // Платформа с тонкой кромкой
    public static Chipboard getPlatformWithThinEdging() {
        Chipboard platform = new Chipboard();
        platform.setName("Платформа с тонкой кромкой");
        platform.setLength(450);
        platform.setWidth(300);
        platform.setEdgingBlue();   // синий в круг

        return platform;
    }


    public static Chipboard getSide() {
        Chipboard side = new Chipboard();

        side.setName("Бок");
        side.setLength(418);
        side.setWidth(300);
        side.setEdging_top("blue");
        side.setEdging_bottom("blue");

        return side;
    }

    public static Chipboard getBack() {
        Chipboard back = new Chipboard();

        back.setName("Зад");
        back.setLength(418);
        back.setWidth(418);

        return back;
    }

    public static Chipboard getFacade() {
        Chipboard facade = new Chipboard();

        facade.setLength(410);
        facade.setWidth(202);

        facade.setName("Фасад");
        facade.setEdgingRed();

        return facade;
    }

    public static Chipboard getShelf() {
        Chipboard facade = new Chipboard();

        facade.setLength(418);
        facade.setWidth(268);

        facade.setName("Полка");
        facade.setEdging_top("blue");

        return facade;
    }

    public static Product getT11() {
        Product t11 = new Product();

        // добавляем платформы с толстой кромкой
        t11.getChipboardList().add(getPlatformWithFatEdging());

        // добавляем платформы с тонкой кромкой
        t11.getChipboardList().add(getPlatformWithThinEdging());
        t11.getChipboardList().add(getPlatformWithThinEdging());

        t11.getChipboardList().add(getSide());
        t11.getChipboardList().add(getSide());

        t11.getChipboardList().add(getBack());

        t11.getChipboardList().add(getFacade());
        t11.getChipboardList().add(getFacade());

        t11.getChipboardList().add(getShelf());

        t11.getAccessoryList().addAll(getT11Accessory());

        t11.setName("Т11");
        t11.setPrice(2800); //TODO
        t11.setCostOfWork(330);

        return t11;
    }

    public static List<Accessory> getT11Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory flange = AccessoryDatabase.getFlange(8);

        Accessory screw = AccessoryDatabase.getScrew16x3(76);

        Accessory wheels = AccessoryDatabase.getWheel(4);

        Accessory pipe = AccessoryDatabase.getPipe(1);

        Accessory drawerHandle = AccessoryDatabase.getHandleRailing96(2);


        Accessory confirmation = AccessoryDatabase.getConfirmat50x6(12);


        accessoryList.add(flange);
        accessoryList.add(screw);
        accessoryList.add(wheels);
        accessoryList.add(pipe);
        accessoryList.add(drawerHandle);
        accessoryList.add(confirmation);

        return accessoryList;
    }
}
