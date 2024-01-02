package Projects.Marselle.models.furniture.standartPositions.manicureTables;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class MC06 extends Product {
    private final Product mc06;
    public MC06() {
        this.mc06 = getMC06();
    }



    public static Product getMC06() {
        Product mc06 = new Product();
        mc06.setName("МС06");
        mc06.setCostOfWork(330);    //TODO ???????
        mc06.setPrice(3290);

        mc06.getChipboardList().add(getBigWorktop());   // большая столешка
        mc06.getChipboardList().add(getLittleWorktop());    // малая столешка

        mc06.getChipboardList().add(getSide()); // бок
        mc06.getChipboardList().add(getSide()); // бок
        mc06.getChipboardList().add(getHDF()); // хдф

        mc06.getChipboardList().add(getShelf()); // полка
        mc06.getChipboardList().add(getShelf()); // полка

        mc06.getAccessoryList().addAll(getMC06Accessory());

        return mc06;
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
        side.setWidth(300);

        side.setEdging_top("blue");
        side.setEdging_left("blue");
        return side;
    }

    // Зад
    public static Chipboard getHDF() {
        Chipboard back = new Chipboard();
        back.setName("ХДФ");
        back.setLength(713);
        back.setWidth(398);
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



    public static List<Accessory> getMC06Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory screw = AccessoryDatabase.getScrew16x3(26);

        Accessory furnitureCorner = AccessoryDatabase.getFurnitureCorner(4);

        Accessory threadedBus = AccessoryDatabase.getAdjustableSupport(4);

        Accessory confirmation = AccessoryDatabase.getConfirmat50x6(8);

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
        accessoryList.add(furnitureCorner);
        accessoryList.add(threadedBus);
        accessoryList.add(confirmation);
        accessoryList.add(tableLeg);
        accessoryList.add(cup);
        accessoryList.add(loop);

        return accessoryList;
    }
}
