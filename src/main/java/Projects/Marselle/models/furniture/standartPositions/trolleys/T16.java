package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class T16 extends Product {
    private final Product t16;

    public T16() {
        this.t16 = getT16();
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

        Chipboard leftSide = getDrawerChipboard("Левый бок ящика", 350, 160);
        Chipboard rightSide = getDrawerChipboard("Правый бок ящика", 350, 160);
        Chipboard frontSide = getDrawerChipboard("Перед ящика", 460, 130);
        Chipboard backSide = getDrawerChipboard("Зад ящика", 460, 160);
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

        facade.setLength(510);
        facade.setWidth(202);

        facade.setName("Фасад");
        facade.setEdgingRed();

        return facade;
    }

    public static Product getT16() {
        Product t16 = new Product();

        // добавляем ящики
        t16.getChipboardList().addAll(T15.getDrawerChipboards());
        t16.getChipboardList().addAll(T15.getDrawerChipboards());

        // добавляем платформы с толстой кромкой
        t16.getChipboardList().add(getPlatformWithFatEdging());

        // добавляем платформы с тонкой кромкой
        t16.getChipboardList().add(getPlatformWithThinEdging());
        t16.getChipboardList().add(getPlatformWithThinEdging());

        t16.getChipboardList().add(getSide());
        t16.getChipboardList().add(getSide());

        t16.getChipboardList().add(getBack());

        t16.getAccessoryList().addAll(getT16Accessory());

        t16.setName("Т16");
        t16.setPrice(4700); //TODO
        t16.setCostOfWork(420);

        return t16;
    }

    public static List<Accessory> getT16Accessory() {
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
        Product product = T16.getT16();

        for (Accessory c : product.getAccessoryList()) {
            System.out.println(c);
        }
    }
}
