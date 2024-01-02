package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class T05 extends Product {
    private final Product t05;

    public T05() {
        this.t05 = getT05();
    }

    // этот метод задает размеры полок
    public static Chipboard getShelf() {
        Chipboard shelf = new Chipboard();
        shelf.setName("Платформа");
        shelf.setLength(450);
        shelf.setWidth(300);
        shelf.setEdgingRed();   // красной в круг

        return shelf;
    }

    public static Product getT05() {
        Product t05 = new Product();

        Chipboard shelf1 = getShelf();
        shelf1.setName("Нижняя платформа");

        Chipboard shelf2 = getShelf();
        shelf2.setName("Средняя платформа");

        Chipboard shelf3 = getShelf();
        shelf3.setName("Верхняя платформа");

        // добавляет материал
        t05.getChipboardList().add(shelf1);
        t05.getChipboardList().add(shelf2);
        t05.getChipboardList().add(shelf3);

        // устанавливаем стоимость
        t05.setPrice(2190);
        t05.getAccessoryList().addAll(getT05Accessory());

        // устанавливаем общую площадь материала на изделие
        t05.setAreaOfMaterial(t05.calculateAreaOfMaterial());

        // устанавливаем имя
        t05.setName("Т05");
        t05.setCostOfWork(260);

        return t05;
    }

    public static List<Accessory> getT05Accessory() {
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
