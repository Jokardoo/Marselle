package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class T17 extends Product {
    private final Product t17;

    public T17() {
        this.t17 = getT17();
    }


    // Платформа с тонкой кромкой
    public static Chipboard getPlatformWithThinEdging() {
        Chipboard platform = new Chipboard();
        platform.setName("Крышка");
        platform.setLength(900);
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

        Chipboard leftSide = getDrawerChipboard("Левый бок ящика", 250, 90);
        Chipboard rightSide = getDrawerChipboard("Правый бок ящика", 250, 90);
        Chipboard frontSide = getDrawerChipboard("Перед ящика", 368, 60);
        Chipboard backSide = getDrawerChipboard("Зад ящика", 368, 90);
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

        side.setName("Перегородка");
        side.setLength(300);
        side.setWidth(280);
        side.setEdging_left("blue");
        side.setEdging_right("blue");

        return side;
    }

    public static Chipboard getBack() {
        Chipboard back = new Chipboard();

        back.setName("Зад");
        back.setLength(426);
        back.setWidth(279);

        return back;
    }

    public static Chipboard getFacade() {
        Chipboard facade = new Chipboard();

        facade.setLength(418);
        facade.setWidth(133);

        facade.setName("Фасад");
        facade.setEdgingRed();

        return facade;
    }

    public static Product getT17() {
        Product t17 = new Product();

        // добавляем 2 ящика
        t17.getChipboardList().addAll(T17.getDrawerChipboards());
        t17.getChipboardList().addAll(T17.getDrawerChipboards());
        t17.getChipboardList().addAll(T17.getDrawerChipboards());
        t17.getChipboardList().addAll(T17.getDrawerChipboards());

        // добавляем 4 платформы с тонкой кромкой
        t17.getChipboardList().add(getPlatformWithThinEdging());
        t17.getChipboardList().add(getPlatformWithThinEdging());
        t17.getChipboardList().add(getPlatformWithThinEdging());
        t17.getChipboardList().add(getPlatformWithThinEdging());

        // Добавляем 4 перегородки
        t17.getChipboardList().add(getSide());
        t17.getChipboardList().add(getSide());
        t17.getChipboardList().add(getSide());
        t17.getChipboardList().add(getSide());

        // Добавляем 2 задние стенки
        t17.getChipboardList().add(getBack());
        t17.getChipboardList().add(getBack());

        t17.getAccessoryList().addAll(getT17Accessory());

        t17.setName("Т17");
        t17.setPrice(4700); //TODO
        t17.setCostOfWork(700);

        return t17;
    }

    public static List<Accessory> getT17Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory flange = AccessoryDatabase.getFlange(20);

        Accessory screw = AccessoryDatabase.getScrew16x3(148);

        Accessory wheels = AccessoryDatabase.getWheel(6);

        Accessory pipe = AccessoryDatabase.getPipe(1);

        Accessory drawerHandle = AccessoryDatabase.getHandleRailing96(4);

        Accessory drawerGuide = AccessoryDatabase.getGuide250(4);

        Accessory confirmation = AccessoryDatabase.getConfirmat50x6(16);

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
        Product product = T17.getT17();

        for (Accessory c : product.getAccessoryList()) {
            System.out.println(c);
        }
    }
}
