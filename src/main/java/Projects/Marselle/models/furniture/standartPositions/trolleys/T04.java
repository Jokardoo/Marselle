package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class T04 extends Product {

    private final Product t04;

    public T04() {
        this.t04 = getT04();
    }

    // этот метод задает размеры полок
    public static Chipboard getShelf() {
        Chipboard shelf = new Chipboard();
        shelf.setName("Платформа");
        shelf.setLength(350);
        shelf.setWidth(250);
        shelf.setEdgingRed();   // красной в круг

        return shelf;
    }

    public static Product getT04() {
        Product t04 = new Product();

        Chipboard shelf1 = getShelf();
        shelf1.setName("Нижняя платформа");

        Chipboard shelf2 = getShelf();
        shelf2.setName("Средняя платформа");

        Chipboard shelf3 = getShelf();
        shelf3.setName("Верхняя платформа");

        // добавляет материал
        t04.getChipboardList().add(shelf1);
        t04.getChipboardList().add(shelf2);
        t04.getChipboardList().add(shelf3);

        t04.getAccessoryList().addAll(getT04Accessory());

        // устанавливаем стоимость
        t04.setPrice(1800);

        // устанавливаем общую площадь материала на изделие
        t04.setAreaOfMaterial(t04.calculateAreaOfMaterial());

        // устанавливаем имя
        t04.setName("Т04");
        t04.setCostOfWork(260);

        return t04;
    }

    public static List<Accessory> getT04Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory flange = AccessoryDatabase.getFlange(16);

        Accessory screw = AccessoryDatabase.getScrew16x3(64);

        Accessory wheels = AccessoryDatabase.getWheel(4);

        Accessory pipe = AccessoryDatabase.getPipe(1);

        Accessory drawerHandle = AccessoryDatabase.getHandleRailing96(2);

        accessoryList.add(flange);
        accessoryList.add(screw);
        accessoryList.add(wheels);
        accessoryList.add(pipe);
        accessoryList.add(drawerHandle);

        return accessoryList;
    }
}
