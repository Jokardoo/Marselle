package Projects.Marselle.models.furniture.standartPositions.manicureTables;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;


public class MC09 extends Product {
    private final Product mc09;
    public MC09() {
        this.mc09 = getMC09();
    }



    public static Chipboard getFacade() {
        Chipboard facade = new Chipboard();

        facade.setLength(351);
        facade.setWidth(294);

        facade.setName("Фасад");
        facade.setEdgingRed();

        return facade;
    }



    public static Product getMC09() {
        Product mc09 = new Product();
        mc09.setName("МС09");
        mc09.setCostOfWork(330);
        mc09.setPrice(3890);      //TODO

        mc09.getChipboardList().add(getBigWorktop());   // большая столешка
        mc09.getChipboardList().add(getLittleWorktop());    // малая столешка

        mc09.getChipboardList().add(getSide()); // бок
        mc09.getChipboardList().add(getSide()); // бок
        mc09.getChipboardList().add(getBack()); // зад

        mc09.getChipboardList().add(getShelf()); // полка
        mc09.getChipboardList().add(getShelf()); // полка
        mc09.getChipboardList().add(getShelf()); // полка
        mc09.getChipboardList().add(getShelf()); // полка

        mc09.getChipboardList().add(getFacade());

        mc09.getAccessoryList().addAll(getMC18Accessory());

        return mc09;
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



    public static List<Accessory> getMC18Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory screw = AccessoryDatabase.getScrew16x3(28);

        Accessory screw2 = AccessoryDatabase.getScrew16x4(8);

        Accessory furnitureCorner = AccessoryDatabase.getFurnitureCorner(5);

        Accessory threadedBus = AccessoryDatabase.getAdjustableSupport(4);

        Accessory doorHandle = AccessoryDatabase.getHandleRailing96(1);

        Accessory doorHinge = AccessoryDatabase.getFurnitureHingesExternal(2);

        Accessory confirmation = AccessoryDatabase.getConfirmat50x6(18);

        Accessory shelfHolder = AccessoryDatabase.getShelfHolder(4);

        Accessory tableLeg = AccessoryDatabase.getSupportLeg710(1);

        Accessory cup = new Accessory();    // кривой английский перевод
        cup.setName("Чашка под ножку");
        cup.setCount(1);
        cup.setPrice(0.0);    //TODO

        Accessory loop = new Accessory();
        loop.setName("Петля обычная");
        loop.setCount(3);
        loop.setPrice(0.0);


        accessoryList.add(screw);
        accessoryList.add(screw2);
        accessoryList.add(furnitureCorner);
        accessoryList.add(threadedBus);
        accessoryList.add(doorHandle);
        accessoryList.add(doorHinge);
        accessoryList.add(confirmation);
        accessoryList.add(tableLeg);
        accessoryList.add(cup);
        accessoryList.add(loop);
        accessoryList.add(shelfHolder);

        return accessoryList;
    }

}
