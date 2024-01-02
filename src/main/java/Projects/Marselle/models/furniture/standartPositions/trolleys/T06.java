package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class T06 extends Product{
    private final Product t06;

    public T06() {
        this.t06 = getT06();
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

    public static Product getT06() {
        Product t06 = new Product();

        Chipboard shelf1 = getShelf();
        shelf1.setName("Нижняя платформа");

        Chipboard shelf2 = getShelf();
        shelf2.setName("Средняя платформа");

        Chipboard shelf3 = getShelf();
        shelf3.setName("Верхняя платформа");

        // добавляет материал
        t06.getChipboardList().add(shelf1);
        t06.getChipboardList().add(shelf2);
        t06.getChipboardList().add(shelf3);

        t06.getAccessoryList().addAll(getT06Accessory());

        // устанавливаем стоимость
        t06.setPrice(2700);

        // устанавливаем общую площадь материала на изделие
        t06.setAreaOfMaterial(t06.calculateAreaOfMaterial());

        // устанавливаем имя
        t06.setName("Т06");
        t06.setCostOfWork(280);

        return t06;
    }

    public static List<Accessory> getT06Accessory() {
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
