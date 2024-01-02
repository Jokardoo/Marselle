package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class T13 extends Product{
    private final Product t13;

    public T13() {
        this.t13 = getT13();
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
        Chipboard frontSide = getDrawerChipboard("Перед ящика", 360, 130);
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
        side.setLength(300);
        side.setWidth(210);
        side.setEdging_left("blue");
        side.setEdging_right("blue");

        return side;
    }

    public static Chipboard getBack() {
        Chipboard back = new Chipboard();

        back.setName("Зад");
        back.setLength(418);
        back.setWidth(210);

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

    public static Product getT13() {
        Product t13 = new Product();

        // добавляем ящики
        t13.getChipboardList().addAll(T13.getDrawerChipboards());
        t13.getChipboardList().addAll(T13.getDrawerChipboards());

        // добавляем платформы с толстой кромкой
        t13.getChipboardList().add(getPlatformWithFatEdging());
        t13.getChipboardList().add(getPlatformWithFatEdging());

        // добавляем платформы с тонкой кромкой
        t13.getChipboardList().add(getPlatformWithThinEdging());
        t13.getChipboardList().add(getPlatformWithThinEdging());

        t13.getChipboardList().add(getSide());
        t13.getChipboardList().add(getSide());

        t13.getChipboardList().add(getBack());

        t13.getAccessoryList().addAll(getT13Accessory());

        t13.setName("Т13");
        t13.setPrice(4300); //TODO
        t13.setCostOfWork(330);

        return t13;
    }

    public static List<Accessory> getT13Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory flange = AccessoryDatabase.getFlange(16);

        Accessory screw = AccessoryDatabase.getScrew16x3(76);

        Accessory wheels = AccessoryDatabase.getWheel(4);

        Accessory pipe = AccessoryDatabase.getPipe(1);

        Accessory drawerHandle = AccessoryDatabase.getHandleRailing96(1);

        Accessory drawerGuide = AccessoryDatabase.getGuide250(1);

        Accessory confirmation = AccessoryDatabase.getConfirmat50x6(12);

        Accessory screw2 = AccessoryDatabase.getScrew30x4(4);

        accessoryList.add(flange);
        accessoryList.add(screw);
        accessoryList.add(wheels);
        accessoryList.add(pipe);
        accessoryList.add(drawerHandle);
        accessoryList.add(drawerGuide);
        accessoryList.add(confirmation);
        accessoryList.add(screw2);

        return accessoryList;
    }

    public static void main(String[] args) {
        Product product = T13.getT13();

        for (Accessory c : product.getAccessoryList()) {
            System.out.println(c);
        }
    }
}
