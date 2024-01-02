package Projects.Marselle.models.furniture.standartPositions.commodes;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class K03 extends Product {
    private final Product k03;
    public K03() {
        this.k03 = getK03();
    }

    public static Product getK03() {
        Product k03 = new Product();

        k03.setName("К03");
        k03.setCostOfWork(900); //TODO ???????
        k03.setPrice(8900);     //TODO ????????

        k03.getChipboardList().add(getTableTop());
        k03.getChipboardList().add(getSide());
        k03.getChipboardList().add(getSide());
        k03.getChipboardList().add(getShelf());
        k03.getChipboardList().add(getPlinth());
        k03.getChipboardList().add(getAdditional());
        k03.getChipboardList().add(getAdditional());

        k03.getChipboardList().add(getLittlePartition());
        k03.getChipboardList().add(getPartition());
        k03.getChipboardList().add(getPartition());
        k03.getChipboardList().add(getPartition());

        k03.getChipboardList().addAll(getDrawerChipboards());
        k03.getChipboardList().addAll(getDrawerChipboards());
        k03.getChipboardList().addAll(getDrawerChipboards());
        k03.getChipboardList().addAll(getDrawerChipboards());

        k03.getChipboardList().add(getCommodeHDF());

        List<Accessory> accessoryList =  getK03Accessory();
        k03.getAccessoryList().addAll(accessoryList);

        return k03;
    }

    public static List<Accessory> getK03Accessory() {
        Accessory screw = AccessoryDatabase.getScrew16x3(72);
        Accessory screw2 = AccessoryDatabase.getScrew30x4(16);
        Accessory screw3 = AccessoryDatabase.getScrew50x4(32);

        Accessory confirmation = AccessoryDatabase.getConfirmat50x6(10);
        Accessory guide300 = AccessoryDatabase.getGuide300(4);
        Accessory corner = AccessoryDatabase.getFurnitureCorner(12);
        Accessory adjustableSupport = AccessoryDatabase.getAdjustableSupport(4);

        List<Accessory> accessoryList = new ArrayList<>();

        accessoryList.add(screw);
        accessoryList.add(screw2);
        accessoryList.add(screw3);
        accessoryList.add(confirmation);
        accessoryList.add(guide300);
        accessoryList.add(corner);
        accessoryList.add(adjustableSupport);

        return accessoryList;
    }

    public static List<Chipboard> getDrawerChipboards() {
        List<Chipboard> chipboardList = new ArrayList<>();

        Chipboard leftSide = getDrawerChipboard("Левый бок ящика", 300, 120);
        Chipboard rightSide = getDrawerChipboard("Правый бок ящика", 300, 120);
        Chipboard frontSide = getDrawerChipboard("Перед ящика", 710, 90);
        Chipboard backSide = getDrawerChipboard("Зад ящика", 710, 120);
        Chipboard hdf = getDrawerHDF();
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

        facade.setLength(794);
        facade.setWidth(179);

        facade.setName("Фасад");
        facade.setEdgingRed();

        return facade;
    }

    public static Chipboard getLittlePartition() {
        Chipboard partition = new Chipboard();

        partition.setLength(768);
        partition.setWidth(50);

        partition.setName("Малая перегородка");
        partition.setEdging_top("blue");
        partition.setEdging_bottom("blue");

        return partition;
    }

    public static Chipboard getPartition() {
        Chipboard partition = new Chipboard();

        partition.setLength(768);
        partition.setWidth(60);

        partition.setName("Перегородка");
        partition.setEdging_top("blue");
        partition.setEdging_bottom("blue");

        return partition;
    }

    public static Chipboard getTableTop() {
        Chipboard top = new Chipboard();
        top.setLength(800);
        top.setWidth(370);
        top.setEdgingRed();
        top.setName("Столешница");

        return top;
    }

    public static Chipboard getSide() {
        Chipboard side = new Chipboard();
        side.setLength(884);
        side.setWidth(350);

        side.setEdging_bottom("blue");
        side.setEdging_right("blue");

        side.setName("Бок");

        return side;
    }

    public static Chipboard getShelf() {
        Chipboard shelf = new Chipboard();
        shelf.setLength(768);
        shelf.setWidth(350);

        shelf.setEdging_bottom("blue");

        shelf.setName("Полка");

        return shelf;
    }

    public static Chipboard getPlinth() {
        Chipboard plinth = new Chipboard();
        plinth.setLength(768);
        plinth.setWidth(70);

        plinth.setEdging_bottom("blue");

        plinth.setName("Цоколь");

        return plinth;
    }

    public static Chipboard getAdditional() {
        Chipboard additional = new Chipboard();
        additional.setLength(768);
        additional.setWidth(100);

        additional.setEdging_bottom("blue");

        additional.setName("Дополнительная планка");

        return additional;
    }
    public static Chipboard getDrawerHDF() {
        Chipboard hdf = new Chipboard();
        hdf.setLength(740);
        hdf.setWidth(298);
        hdf.setName("ХДФ ящика");

        return hdf;
    }

    public static Chipboard getCommodeHDF() {
        Chipboard hdf = new Chipboard();
        hdf.setLength(813);
        hdf.setWidth(798);
        hdf.setName("ХДФ ящика");

        return hdf;
    }

}
