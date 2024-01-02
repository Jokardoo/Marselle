package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class T12 extends Product {
    private final Product t12;

    public T12() {
        this.t12 = getT12();
    }

    // Платформа с толстой кромкой
    public static Chipboard getPlatformWithFatEdging() {
        Chipboard platform = new Chipboard();
        platform.setName("Платформа с толстой кромкой");
        platform.setLength(550);
        platform.setWidth(400);
        platform.setEdgingRed();   // красной в круг

        return platform;
    }

    // Платформа с тонкой кромкой
    public static Chipboard getPlatformWithThinEdging() {
        Chipboard platform = new Chipboard();
        platform.setName("Платформа с тонкой кромкой");
        platform.setLength(550);
        platform.setWidth(400);
        platform.setEdgingBlue();   // синий в круг

        return platform;
    }


    public static Chipboard getSide() {
        Chipboard side = new Chipboard();

        side.setName("Бок");
        side.setLength(418);
        side.setWidth(400);
        side.setEdging_top("blue");
        side.setEdging_bottom("blue");

        return side;
    }

    public static Chipboard getBack() {
        Chipboard back = new Chipboard();

        back.setName("Зад");
        back.setLength(518);
        back.setWidth(418);

        return back;
    }

    public static Chipboard getFacade() {
        Chipboard facade = new Chipboard();

        facade.setLength(410);
        facade.setWidth(252);

        facade.setName("Фасад");
        facade.setEdgingRed();

        return facade;
    }

    public static Chipboard getShelf() {
        Chipboard facade = new Chipboard();

        facade.setLength(518);
        facade.setWidth(368);

        facade.setName("Полка");
        facade.setEdging_top("blue");

        return facade;
    }

    public static Product getT12() {
        Product t12 = new Product();

        // добавляем платформы с толстой кромкой
        t12.getChipboardList().add(getPlatformWithFatEdging());

        // добавляем платформы с тонкой кромкой
        t12.getChipboardList().add(getPlatformWithThinEdging());
        t12.getChipboardList().add(getPlatformWithThinEdging());

        t12.getChipboardList().add(getSide());
        t12.getChipboardList().add(getSide());

        t12.getChipboardList().add(getBack());

        t12.getChipboardList().add(getFacade());
        t12.getChipboardList().add(getFacade());

        t12.getChipboardList().add(getShelf());

        t12.getAccessoryList().addAll(getT12Accessory());

        t12.setName("Т12");
        t12.setPrice(3900); //TODO
        t12.setCostOfWork(350);

        return t12;
    }

    public static List<Accessory> getT12Accessory() {
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
