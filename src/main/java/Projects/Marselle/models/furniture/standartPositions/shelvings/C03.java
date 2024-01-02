package Projects.Marselle.models.furniture.standartPositions.shelvings;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class C03 {
    private final Product c03;

    public C03() {
        this.c03 = getC03();
    }

    // этот метод задает размеры полок
    public static Chipboard getShelf() {
        Chipboard shelf = new Chipboard();
        shelf.setName("Полка");
        shelf.setLength(568);
        shelf.setWidth(300);
        shelf.setEdging_top("blue");

        return shelf;
    }

    public static Chipboard getFacade() {
        Chipboard facade = new Chipboard();
        facade.setName("Фасад");
        facade.setLength(722);  //TODO
        facade.setWidth(293);   // TODO
        facade.setEdgingRed();

        return facade;
    }

    public static Product getC03() {
        Product c03 = new Product();

        Chipboard shelf1 = getShelf();
        shelf1.setName("1-я полка");

        Chipboard shelf2 = getShelf();
        shelf2.setName("2-я полка");

        Chipboard shelf3 = getShelf();
        shelf3.setName("3-я полка");

        Chipboard shelf4 = getShelf();
        shelf4.setName("4-я полка");

        Chipboard shelf5 = getShelf();
        shelf5.setName("5-я полка");

        Chipboard shelf6 = getShelf();
        shelf6.setName("6-я полка");

        Chipboard leftSide = getSide();
        leftSide.setName("Левый бок");

        Chipboard rightSide = getSide();
        rightSide.setName("Правый бок");

        Chipboard leftFacade = getFacade();
        leftFacade.setName("Левый фасад");

        Chipboard rightFacade = getFacade();
        rightFacade.setName("Правый фасад");

        // добавляет материал
        c03.getChipboardList().add(shelf1);
        c03.getChipboardList().add(shelf2);
        c03.getChipboardList().add(shelf3);
        c03.getChipboardList().add(shelf4);
        c03.getChipboardList().add(shelf5);
        c03.getChipboardList().add(shelf6);

        c03.getChipboardList().add(leftSide);
        c03.getChipboardList().add(rightSide);

        c03.getChipboardList().add(leftFacade);
        c03.getChipboardList().add(rightFacade);

        c03.getAccessoryList().addAll(getC03Accessory());

        // устанавливаем стоимость
        c03.setPrice(5000);         //TODO
        c03.setCostOfWork(350);

        // устанавливаем общую площадь материала на изделие
        c03.setAreaOfMaterial(c03.calculateAreaOfMaterial());

        // устанавливаем имя
        c03.setName("С03");

        return c03;
    }

    public static Chipboard getSide() {
        Chipboard side = new Chipboard();

        side.setLength(1800);
        side.setWidth(300);

        side.setEdging_left("blue");
        side.setEdging_right("blue");
        side.setEdging_top("blue");

        return side;
    }

    public static List<Accessory> getC03Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory accessory = AccessoryDatabase.getConfirmat50x6(24);

        Accessory doorHinge = AccessoryDatabase.getFurnitureHingesExternal(4);

        Accessory screw = AccessoryDatabase.getScrew16x4(16);

        accessoryList.add(accessory);
        accessoryList.add(doorHinge);
        accessoryList.add(screw);
        return accessoryList;
    }
}
