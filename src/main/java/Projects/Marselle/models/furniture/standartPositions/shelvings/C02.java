package Projects.Marselle.models.furniture.standartPositions.shelvings;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class C02 {
    private final Product c02;

    public C02() {
        this.c02 = getC02();
    }

    // этот метод задает размеры полок
    public static Chipboard getShelf() {
        Chipboard shelf = new Chipboard();
        shelf.setName("shelf");
        shelf.setLength(568);
        shelf.setWidth(300);
        shelf.setEdging_top("blue");

        return shelf;
    }

    public static Product getC02() {
        Product c02 = new Product();

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

        // добавляет материал
        c02.getChipboardList().add(shelf1);
        c02.getChipboardList().add(shelf2);
        c02.getChipboardList().add(shelf3);
        c02.getChipboardList().add(shelf4);
        c02.getChipboardList().add(shelf5);
        c02.getChipboardList().add(shelf6);

        c02.getChipboardList().add(leftSide);
        c02.getChipboardList().add(rightSide);

        c02.getAccessoryList().addAll(getC02Accessory());   // добавляем комплект метизов для С01
        // устанавливаем стоимость
        c02.setPrice(4000);         //TODO
        c02.setCostOfWork(250);

        // устанавливаем общую площадь материала на изделие
        c02.setAreaOfMaterial(c02.calculateAreaOfMaterial());

        // устанавливаем имя
        c02.setName("С02");

        return c02;
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

    public static List<Accessory> getC02Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory accessory = AccessoryDatabase.getConfirmat50x6(24);

        accessoryList.add(accessory);
        return accessoryList;
    }
}
