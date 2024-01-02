package Projects.Marselle.models.furniture.standartPositions.trolleys;

import Projects.Marselle.models.furniture.standartPositions.materials.Accessory;
import Projects.Marselle.models.furniture.standartPositions.materials.AccessoryDatabase;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;
import Projects.Marselle.models.furniture.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class T01 extends Product {

    private final Product t01;

    public T01() {
        this.t01 = getT01();
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

    public static Product getT01() {
        Product t01 = new Product();

        Chipboard shelf1 = getShelf();
        shelf1.setName("Нижняя платформа");

        Chipboard shelf2 = getShelf();
        shelf2.setName("Средняя платформа");

        Chipboard shelf3 = getShelf();
        shelf3.setName("Верхняя платформа");

        // добавляет материал
        t01.getChipboardList().add(shelf1);
        t01.getChipboardList().add(shelf2);
        t01.getChipboardList().add(shelf3);

        t01.getAccessoryList().addAll(getT01Accessory());

        // устанавливаем стоимость
        t01.setPrice(1300);
        t01.setCostOfWork(200);

        // устанавливаем общую площадь материала на изделие
        t01.setAreaOfMaterial(t01.calculateAreaOfMaterial());

        // устанавливаем имя
        t01.setName("Т01");

        return t01;
    }

    public static List<Accessory> getT01Accessory() {
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
        return "T01{" +
                "t01=" + t01 +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(T01.getT01());
    }
}
