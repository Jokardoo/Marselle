package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class T02 extends Product {
    private final Product t02;

    public T02() {
        this.t02 = getT02();
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

    public static Product getT02() {
        Product t02 = new Product();

        Chipboard shelf1 = getShelf();
        shelf1.setName("Нижняя платформа");

        Chipboard shelf2 = getShelf();
        shelf2.setName("Средняя платформа");

        Chipboard shelf3 = getShelf();
        shelf3.setName("Верхняя платформа");

        // добавляет материал
        t02.getChipboardList().add(shelf1);
        t02.getChipboardList().add(shelf2);
        t02.getChipboardList().add(shelf3);

        // устанавливаем стоимость
        t02.setPrice(1690);
        t02.getAccessoryList().addAll(getT02Accessory());

        // устанавливаем общую площадь материала на изделие
        t02.setAreaOfMaterial(t02.calculateAreaOfMaterial());

        // устанавливаем имя
        t02.setName("Т02");
        t02.setCostOfWork(200);

        return t02;
    }

    public static List<Accessory> getT02Accessory() {
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
        return "T02{" +
                "t02=" + t02 +
                '}';
    }

}
