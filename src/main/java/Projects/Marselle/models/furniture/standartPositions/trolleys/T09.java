package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class T09 extends Product {
    private final Product t09;

    public T09() {
        this.t09 = getT09();
    }

    // этот метод задает размеры полок
    public static Chipboard getShelf() {
        Chipboard shelf = new Chipboard();
        shelf.setName("Платформа");
        shelf.setLength(550);
        shelf.setWidth(400);
        shelf.setEdgingRed();   // красной в круг

        return shelf;
    }

    public static Product getT09() {
        Product t09 = new Product();

        Chipboard shelf1 = getShelf();
        shelf1.setName("Нижняя платформа");

        Chipboard shelf2 = getShelf();
        shelf2.setName("Средняя платформа");

        Chipboard shelf3 = getShelf();
        shelf3.setName("Верхняя платформа");

        // добавляет материал
        t09.getChipboardList().add(shelf1);
        t09.getChipboardList().add(shelf2);
        t09.getChipboardList().add(shelf3);

        t09.getAccessoryList().addAll(getT09Accessory());

        // устанавливаем стоимость
        t09.setPrice(2700);

        // устанавливаем общую площадь материала на изделие
        t09.setAreaOfMaterial(t09.calculateAreaOfMaterial());

        // устанавливаем имя
        t09.setName("Т09");
        t09.setCostOfWork(320);

        return t09;
    }

    public static List<Accessory> getT09Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory flange = AccessoryDatabase.getFlange(16);

        Accessory screw = AccessoryDatabase.getScrew16x3(64);

        Accessory wheels = AccessoryDatabase.getWheel(4);

        Accessory pipe = AccessoryDatabase.getPipe(1);

        Accessory drawerHandle = AccessoryDatabase.getHandleRailing96(3);

        accessoryList.add(flange);
        accessoryList.add(screw);
        accessoryList.add(wheels);
        accessoryList.add(pipe);
        accessoryList.add(drawerHandle);

        return accessoryList;
    }
}
