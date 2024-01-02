package Projects.Marselle.models.furniture.standartPositions.manicureTables;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class MC05 extends Product {
    private final Product mc05;
    public MC05() {
        this.mc05 = getMC05();
    }



    public static Product getMC05() {
        Product mc05 = new Product();
        mc05.setName("МС05");
        mc05.setCostOfWork(330);
        mc05.setPrice(2890);      //TODO

        mc05.getChipboardList().add(getBigWorktop());   // большая столешка
        mc05.getChipboardList().add(getLittleWorktop());    // малая столешка

        mc05.getChipboardList().add(getSide()); // бок
        mc05.getChipboardList().add(getSide()); // бок
        mc05.getChipboardList().add(getHDF()); // хдф

        mc05.getChipboardList().add(getShelf()); // полка
        mc05.getChipboardList().add(getShelf()); // полка


        mc05.getAccessoryList().addAll(getMC05Accessory());

        return mc05;
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



    public static List<Accessory> getMC05Accessory() {
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
