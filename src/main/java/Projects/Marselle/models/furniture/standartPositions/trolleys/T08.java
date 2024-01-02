package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

import java.util.ArrayList;
import java.util.List;

public class T08 {
    private final Product t08;

    public T08() {
        this.t08 = getT08();
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

    public static Product getT08() {
        Product t08 = new Product();

        Chipboard shelf1 = getShelf();
        shelf1.setName("Нижняя платформа");

        Chipboard shelf2 = getShelf();
        shelf2.setName("Средняя платформа");

        Chipboard shelf3 = getShelf();
        shelf3.setName("Верхняя платформа");

        // добавляет материал
        t08.getChipboardList().add(shelf1);
        t08.getChipboardList().add(shelf2);
        t08.getChipboardList().add(shelf3);

        // устанавливаем стоимость
        t08.setPrice(2190); //TODO исправить стоимость
        t08.getAccessoryList().addAll(getT08Accessory());

        // устанавливаем общую площадь материала на изделие
        t08.setAreaOfMaterial(t08.calculateAreaOfMaterial());

        // устанавливаем имя
        t08.setName("Т08");
        t08.setCostOfWork(300);

        return t08;
    }

    public static List<Accessory> getT08Accessory() {
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
