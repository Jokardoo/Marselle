package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class T15 extends Product {
    private final Product t15;

    public T15() {
        this.t15 = getT15();
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

    // возвращает бок ящика
    public static Chipboard getDrawerChipboard(String name, int length, int width) {
        Chipboard chipboard = new Chipboard();

        chipboard.setName(name);
        chipboard.setLength(length);
        chipboard.setWidth(width);
        chipboard.setEdging_top("blue");

        return chipboard;
    }

    public static List<Chipboard> getDrawerChipboards() {
        List<Chipboard> chipboardList = new ArrayList<>();

        Chipboard leftSide = getDrawerChipboard("Левый бок ящика", 250, 160);
        Chipboard rightSide = getDrawerChipboard("Правый бок ящика", 250, 160);
        Chipboard frontSide = getDrawerChipboard("Перед ящика", 360, 120);
        Chipboard backSide = getDrawerChipboard("Зад ящика", 360, 160);
        Chipboard facade = getFacade();

        chipboardList.add(leftSide);
        chipboardList.add(rightSide);
        chipboardList.add(frontSide);
        chipboardList.add(backSide);
        chipboardList.add(facade);

        return chipboardList;
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

    public static Product getT15() {
        Product t15 = new Product();

        // добавляем ящики
        t15.getChipboardList().addAll(T15.getDrawerChipboards());
        t15.getChipboardList().addAll(T15.getDrawerChipboards());

        // добавляем платформы с толстой кромкой
        t15.getChipboardList().add(getPlatformWithFatEdging());

        // добавляем платформы с тонкой кромкой
        t15.getChipboardList().add(getPlatformWithThinEdging());
        t15.getChipboardList().add(getPlatformWithThinEdging());

        t15.getChipboardList().add(getSide());
        t15.getChipboardList().add(getSide());

        t15.getChipboardList().add(getBack());

        t15.getAccessoryList().addAll(getT15Accessory());

        t15.setName("Т15");
        t15.setPrice(3600); //TODO
        t15.setCostOfWork(400);

        return t15;
    }

    public static List<Accessory> getT15Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory flange = AccessoryDatabase.getFlange(8);

        Accessory screw = AccessoryDatabase.getScrew16x3(64);

        Accessory wheels = AccessoryDatabase.getWheel(4);

        Accessory pipe = AccessoryDatabase.getPipe(1);

        Accessory drawerHandle = AccessoryDatabase.getHandleRailing96(2);

        Accessory drawerGuide = AccessoryDatabase.getGuide250(2);

        Accessory confirmation = AccessoryDatabase.getConfirmat50x6(12);

        accessoryList.add(flange);
        accessoryList.add(screw);
        accessoryList.add(wheels);
        accessoryList.add(pipe);
        accessoryList.add(drawerHandle);
        accessoryList.add(drawerGuide);
        accessoryList.add(confirmation);

        return accessoryList;
    }

    public static void main(String[] args) {
        Product product = T15.getT15();

        for (Accessory c : product.getAccessoryList()) {
            System.out.println(c);
        }
    }
}
