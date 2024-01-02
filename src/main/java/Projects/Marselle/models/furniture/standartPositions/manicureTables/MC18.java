package Projects.Marselle.models.furniture.standartPositions.manicureTables;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class MC18 extends Product {
    private final Product mc18;
    public MC18() {
        this.mc18 = getMC18();
    }

    public static List<Chipboard> getDrawerChipboards() {
        List<Chipboard> chipboardList = new ArrayList<>();

        Chipboard leftSide = getDrawerChipboard("Левый бок ящика", 350, 130);
        Chipboard rightSide = getDrawerChipboard("Правый бок ящика", 350, 130);
        Chipboard frontSide = getDrawerChipboard("Перед ящика", 210, 100);
        Chipboard backSide = getDrawerChipboard("Зад ящика", 210, 130);
        Chipboard facade = getFacade();

        chipboardList.add(leftSide);
        chipboardList.add(rightSide);
        chipboardList.add(frontSide);
        chipboardList.add(backSide);
        chipboardList.add(facade);

        return chipboardList;
    }

    public static Chipboard getDrawerChipboard(String name, int length, int width) {
        Chipboard chipboard = new Chipboard();

        chipboard.setName(name);
        chipboard.setLength(length);
        chipboard.setWidth(width);
        chipboard.setEdging_top("blue");

        return chipboard;
    }

    public static Chipboard getFacade() {
        Chipboard facade = new Chipboard();

        facade.setLength(294);
        facade.setWidth(172);

        facade.setName("Фасад");
        facade.setEdgingRed();

        return facade;
    }



    public static Product getMC18() {
        Product mc18 = new Product();
        mc18.setName("МС18");
        mc18.setCostOfWork(470);
        mc18.setPrice(4990);      //TODO

        mc18.getChipboardList().addAll(getDrawerChipboards());  // добавляем ящик
        mc18.getChipboardList().add(getBigWorktop());   // большая столешка
        mc18.getChipboardList().add(getLittleWorktop());    // малая столешка

        mc18.getChipboardList().add(getSide()); // бок
        mc18.getChipboardList().add(getSide()); // бок
        mc18.getChipboardList().add(getBack()); // зад

        mc18.getChipboardList().add(getShelf()); // полка
        mc18.getChipboardList().add(getShelf()); // полка
        mc18.getChipboardList().add(getShelf()); // полка
        mc18.getAccessoryList().addAll(getMC18Accessory());

        return mc18;
    }
    // Малая столешница
    public static Chipboard getLittleWorktop() {
        Chipboard worktop = new Chipboard();
        worktop.setName("Малая столешница");
        worktop.setLength(500);
        worktop.setWidth(350);
        worktop.setEdgingRed();
        return worktop;
    }
    // Большая столешница
    public static Chipboard getBigWorktop() {
        Chipboard worktop = new Chipboard();
        worktop.setName("Большая столешница");
        worktop.setLength(650);
        worktop.setWidth(500);
        worktop.setEdgingRed();
        return worktop;
    }
    // Бок
    public static Chipboard getSide() {
        Chipboard side = new Chipboard();

        side.setName("Бок");
        side.setLength(715);
        side.setWidth(400);

        side.setEdging_top("blue");
        side.setEdging_bottom("blue");
        side.setEdging_left("blue");
        return side;
    }

    // Зад
    public static Chipboard getBack() {
        Chipboard back = new Chipboard();
        back.setName("Зад");
        back.setLength(715);
        back.setWidth(268);
        back.setEdging_right("blue");
        return back;
    }

    // Полка
    public static Chipboard getShelf() {
        Chipboard shelf = new Chipboard();

        shelf.setName("Полка");
        shelf.setLength(384);
        shelf.setWidth(268);

        shelf.setEdging_right("blue");

        return shelf;
    }

    // Дверца
    public static Chipboard getDoor() {
        Chipboard door = new Chipboard();
        door.setName("Дверца");

        door.setLength(529);
        door.setWidth(294);

        door.setEdgingRed();

        return door;
    }

    public static List<Accessory> getMC18Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory screw = AccessoryDatabase.getScrew16x3(34);

        Accessory screw2 = AccessoryDatabase.getScrew16x4(16);

        Accessory screw3 = AccessoryDatabase.getScrew30x4(2);

        Accessory furnitureCorner = AccessoryDatabase.getFurnitureCorner(5);

        Accessory threadedBus = AccessoryDatabase.getAdjustableSupport(4);

        Accessory drawerHandle = AccessoryDatabase.getHandleRailing96(2);

        Accessory drawerGuide = AccessoryDatabase.getGuide350(1);

        Accessory confirmation = AccessoryDatabase.getConfirmat50x6(18);

        Accessory tableLeg = AccessoryDatabase.getSupportLeg710(1);

        Accessory cup = new Accessory();    // кривой английский перевод
        cup.setName("Чашка под ножку");
        cup.setCount(1);
        cup.setPrice(0.0);    //TODO

        Accessory loop = new Accessory();
        loop.setName("Петля обычная");
        loop.setCount(3);
        loop.setPrice(0.0);

        Accessory doorHinge = AccessoryDatabase.getFurnitureHingesExternal(2);


        accessoryList.add(screw);
        accessoryList.add(screw2);
        accessoryList.add(furnitureCorner);
        accessoryList.add(threadedBus);
        accessoryList.add(drawerHandle);
        accessoryList.add(drawerGuide);
        accessoryList.add(confirmation);
        accessoryList.add(tableLeg);
        accessoryList.add(cup);
        accessoryList.add(loop);
        accessoryList.add(doorHinge);
        accessoryList.add(screw3);

        return accessoryList;
    }

    public static void main(String[] args) {
        Product product = MC18.getMC18();

        for (Chipboard chipboard : product.getChipboardList()) {
            System.out.println(chipboard);
        }
    }

}
