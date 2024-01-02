package Projects.Marselle.models.furniture.standartPositions.shelvings;

import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;
import Projects.Marselle.models.furniture.Product;

import java.util.ArrayList;
import java.util.List;

public class C01 extends Product {
    private final Product c01;

    public C01() {
        this.c01 = getC01();
    }

    // этот метод задает размеры полок
    public static Chipboard getShelf() {
        Chipboard shelf = new Chipboard();
        shelf.setName("shelf");
        shelf.setLength(218);
        shelf.setWidth(200);
        shelf.setEdging_top("blue");

        return shelf;
    }

    public static Product getC01() {
        Product c01 = new Product();

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

        Chipboard leftSide = C01.getSide();
        leftSide.setName("Левый бок");

        Chipboard rightSide = C01.getSide();
        rightSide.setName("Правый бок");

        // добавляет материал
        c01.getChipboardList().add(shelf1);
        c01.getChipboardList().add(shelf2);
        c01.getChipboardList().add(shelf3);
        c01.getChipboardList().add(shelf4);
        c01.getChipboardList().add(shelf5);
        c01.getChipboardList().add(shelf6);

        c01.getChipboardList().add(leftSide);
        c01.getChipboardList().add(rightSide);

        c01.getAccessoryList().addAll(getC01Accessory());   // добавляем комплект метизов для С01

        // устанавливаем стоимость
        c01.setPrice(3000);         //TODO
        c01.setCostOfWork(200);

        // устанавливаем общую площадь материала на изделие
        c01.setAreaOfMaterial(c01.calculateAreaOfMaterial());

        // устанавливаем имя
        c01.setName("С01");

        return c01;
    }

    public static Chipboard getSide() {
        Chipboard side = new Chipboard();

        side.setLength(1650);
        side.setWidth(200);

        side.setEdging_left("blue");
        side.setEdging_right("blue");
        side.setEdging_top("blue");

        return side;
    }

    // возвращает все метизы от С01
    public static List<Accessory> getC01Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory accessory = AccessoryDatabase.getConfirmat50x6(24);

        accessoryList.add(accessory);
        return accessoryList;
    }
}
