package Projects.Marselle.models.furniture.standartPositions.mirrors;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class A10 extends Product {
    private final Product a10;

    public A10() {
        this.a10 = getA10();
    }

    public static Chipboard getFrontSide() {
        Chipboard frontSide = new Chipboard();
        frontSide.setName("Бок рамки");
        frontSide.setLength(1782);
        frontSide.setWidth(100);
        frontSide.setEdgingBlue();

        return frontSide    ;
    }

    // передняя планка
    public static Chipboard getPartition() {
        Chipboard partition = new Chipboard();
        partition.setName("Передняя перегородка");
        partition.setLength(600);
        partition.setWidth(100);
        partition.setEdgingBlue();

        return partition;
    }

    public static Chipboard getSide() {
        Chipboard side = new Chipboard();
        side.setName("бок");
        side.setLength(1781);
        side.setWidth(60);
        side.setEdging_right("blue");

        return side;
    }

    public static Chipboard getTopSide() {
        Chipboard topSide = new Chipboard();
        topSide.setName("Верхняя планка");
        topSide.setLength(768);
        topSide.setWidth(60);

        return topSide;
    }

    public static Chipboard getPlatform() {
        Chipboard platform = new Chipboard();
        platform.setName("Платформа");
        platform.setLength(900);
        platform.setWidth(400);
        platform.setEdgingRed();

        return platform;
    }

    public static Product getA10() {
        Product a10 = new Product();

        Chipboard leftFrontSide = A10.getFrontSide();
        Chipboard rightFrontSide = A10.getFrontSide();
        Chipboard topFrontSide = A10.getPartition();
        Chipboard bottomFrontSide = A10.getPartition();

        Chipboard leftSide = A10.getSide();
        Chipboard rightSide = A10.getSide();
        Chipboard topPertition = A10.getTopSide();

        Chipboard platform = A10.getPlatform();

        a10.getChipboardList().add(leftFrontSide);
        a10.getChipboardList().add(rightFrontSide);
        a10.getChipboardList().add(topFrontSide);
        a10.getChipboardList().add(bottomFrontSide);
        a10.getChipboardList().add(leftSide);
        a10.getChipboardList().add(rightSide);
        a10.getChipboardList().add(topPertition);
        a10.getChipboardList().add(platform);

        // устанавливаем стоимость
        a10.setPrice(8700);
        a10.setCostOfWork(750);
        a10.getAccessoryList().addAll(getA10Accessory());

        // устанавливаем общую площадь материала на изделие
        a10.setAreaOfMaterial(a10.calculateAreaOfMaterial());

        // устанавливаем имя
        a10.setName("А10");
        a10.setCostOfWork(850);

        return a10;
    }

    public static List<Accessory> getA10Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();


        Accessory screw = AccessoryDatabase.getScrew16x3(89);

        Accessory screw2 = AccessoryDatabase.getScrew20x3(11);

        Accessory screw3 = AccessoryDatabase.getScrew30x4(2);

        Accessory wheels = AccessoryDatabase.getWheel(6);

        Accessory mirror = AccessoryDatabase.getMirror(1602, 620, 1);

        Accessory mirrorHolders = AccessoryDatabase.getMirrorHolder(11);

        Accessory corner = AccessoryDatabase.getFurnitureCorner(17);

        Accessory corner2 = AccessoryDatabase.getFurnitureCornerReinforced(2);

        Accessory cartridge = AccessoryDatabase.getCartridgeE27(14);

        Accessory wire = AccessoryDatabase.getWire075x2(5);

        Accessory wireWithPlug = AccessoryDatabase.getWireWithPlug(1);

        Accessory pressureRings = AccessoryDatabase.getPressureRing(14);

        accessoryList.add(screw);
        accessoryList.add(screw2);
        accessoryList.add(screw3);
        accessoryList.add(wheels);
        accessoryList.add(mirror);
        accessoryList.add(mirrorHolders);
        accessoryList.add(corner);
        accessoryList.add(corner2);
        accessoryList.add(cartridge);
        accessoryList.add(wire);
        accessoryList.add(wireWithPlug);
        accessoryList.add(pressureRings);

        return accessoryList;
    }

}
