package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class T03 extends Product {
    private final Product t03;

    public T03() {
        this.t03 = getT03();
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

    public static Product getT03() {
        Product t03 = new Product();

        Chipboard shelf1 = getShelf();
        shelf1.setName("Нижняя платформа");

        Chipboard shelf2 = getShelf();
        shelf2.setName("Средняя платформа");

        Chipboard shelf3 = getShelf();
        shelf3.setName("Верхняя платформа");

        // добавляет материал
        t03.getChipboardList().add(shelf1);
        t03.getChipboardList().add(shelf2);
        t03.getChipboardList().add(shelf3);

        t03.getAccessoryList().addAll(getT03Accessory());

        // устанавливаем стоимость
        t03.setPrice(2200);
        t03.setCostOfWork(220);

        // устанавливаем общую площадь материала на изделие
        t03.setAreaOfMaterial(t03.calculateAreaOfMaterial());

        // устанавливаем имя
        t03.setName("Т03");

        return t03;
    }

    public static List<Accessory> getT03Accessory() {
        List<Accessory> accessoryList = new ArrayList<>();

        Accessory flange = AccessoryDatabase.getFlange(16);

        Accessory screw = AccessoryDatabase.getScrew16x3(64);

        Accessory wheels = AccessoryDatabase.getWheel(4);

        Accessory pipe = AccessoryDatabase.getPipe(1);

        accessoryList.add(flange);
        accessoryList.add(screw);
        accessoryList.add(wheels);
        accessoryList.add(pipe);

        return accessoryList;
    }

    @Override
    public String toString() {
        return "T03{" +
                "t03=" + t03 +
                '}';
    }
}
