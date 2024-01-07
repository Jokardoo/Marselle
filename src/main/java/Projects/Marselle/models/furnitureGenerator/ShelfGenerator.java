package Projects.Marselle.models.furnitureGenerator;

// Класс создает стеллажи со спецификацией

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;
import lombok.Data;

@Data
public class ShelfGenerator {

    private ShelfTechnicalConditions technicalConditions;
    private String height;
    private String width;
    private String depth;

    private String top_type;
    private String bottom_type;
    private String back_type;

    private String legs;
    private String shelf_count;
    private String facade;
    private String facade_type;

    public ShelfGenerator() {

    }

    // Генерирует бок по заданным параметрам
    public Chipboard generateSide() {

        if (technicalConditions.checkValues() == false) {
            System.out.println("Ошибка в параметрах");
            return null;
        }
        Chipboard side = new Chipboard();
        side.setName("Бок");
        // Если топ указан как полка или крышка
        if (top_type.equalsIgnoreCase("shelf") || top_type.equalsIgnoreCase("cap")) {
            // Если низ указан как полка или крышка
            if (bottom_type.equalsIgnoreCase("shelf") || bottom_type.equalsIgnoreCase("cap")) {
                // В этой части у нас все хорошо и мы делаем расчет

                side.setThick(16);
                side.setWidth(Integer.parseInt(depth));   // Ширина бока - это глубина стеллажа

                int length = Integer.parseInt(height);

                // Если топ крышкой
                if (top_type.equalsIgnoreCase("cap")) {
                    length = length - 16;
                }

                if (bottom_type.equalsIgnoreCase("cap")) {
                    length = length - 16;
                }

                side.setLength(length);

                // Кромка с лицевой стороны
                side.setEdging_bottom("blue");
                // Если задняя стенка из ЛДСП или отсутствует
                if (back_type.equalsIgnoreCase("chipboard")
                        || back_type.equalsIgnoreCase("none")) {
                    side.setEdging_top("blue");
                }
                // Если верхняя часть полкой
                if (top_type.equalsIgnoreCase("shelf")) {
                    side.setEdging_left("blue");
                }
                // Если нижняя часть полкой
                if (bottom_type.equalsIgnoreCase("shelf")) {
                    side.setEdging_right("blue");
                }


            }
        }
        return side;
    }

    public Chipboard generateTop() {
        if (technicalConditions.checkValues() == false) {
            System.out.println("Ошибка в параметрах");
            return null;
        }

        Chipboard top = new Chipboard();
        top.setName("Верх");
        top.setThick(16);
        // В тех. задании глубина шкафа будет являться шириной полки/крышки!
        top.setWidth(Integer.parseInt(technicalConditions.getDepth()));
        top.setEdging_bottom("blue");

        // Если топ крышкой
        if (technicalConditions.getTop_type().equalsIgnoreCase("cap")) {
            top.setLength(Integer.parseInt(technicalConditions.getWidth()));
            top.setEdging_right("blue");
            top.setEdging_left("blue");
        }
        // Если топ полкой
        else {
            top.setLength(Integer.parseInt(technicalConditions.getWidth()) - 32);
        }

        if (!technicalConditions.getBack_type().equalsIgnoreCase("hdf")) {
            top.setEdging_top("blue");
        }

        return top;
    }

    public Chipboard generateBottom() {
        if (technicalConditions.checkValues() == false) {
            System.out.println("Ошибка в параметрах");
            return null;
        }

        Chipboard bottom = new Chipboard();
        bottom.setName("Дно");
        bottom.setThick(16);
        // В тех. задании глубина шкафа будет являться шириной полки/крышки!
        bottom.setWidth(Integer.parseInt(technicalConditions.getDepth()));
        bottom.setEdging_bottom("blue");

        // Если низ крышкой
        if (technicalConditions.getBottom_type().equalsIgnoreCase("cap")) {
            bottom.setLength(Integer.parseInt(technicalConditions.getWidth()));
            bottom.setEdging_right("blue");
            bottom.setEdging_left("blue");
        }
        // Если низ полкой
        else {
            bottom.setLength(Integer.parseInt(technicalConditions.getWidth()) - 32);
        }

        if (!technicalConditions.getBack_type().equalsIgnoreCase("hdf")) {
            bottom.setEdging_top("blue");
        }

        return bottom;
    }

    public Chipboard generateBack() {
        if (technicalConditions.checkValues() == false) {
            System.out.println("Ошибка параметров");
            return null;
        }

        Chipboard back = new Chipboard();

        // Если задней стенки нет
        if (technicalConditions.getBack_type().equalsIgnoreCase("none")) {
            back.setName("Отсутствует");
            return back;
            // Если задняя стенка из ЛДСП
        } else if (technicalConditions.getBack_type().equalsIgnoreCase("chipboard")) {
            back.setName("Задняя стенка (ЛДСП)");
            back.setThick(16);

            int length = Integer.parseInt(technicalConditions.getHeight()) - 32;

            back.setLength(length);
            back.setWidth(Integer.parseInt(technicalConditions.getWidth()) - 32);

            return back;
        }
        // Если задняя стенка из ХДФ
        else {
            back.setName("Задняя стенка (ХДФ)");
            back.setThick(4);
            back.setWidth(Integer.parseInt(technicalConditions.getWidth()) - 2);
            back.setLength(Integer.parseInt(technicalConditions.getHeight()) - 2);
            return back;
        }
    }

    public Chipboard generateShelf() {
        if (technicalConditions.checkValues() == false) {
            System.out.println("Ошибка параметров");
            return null;
        }

        Chipboard shelf = new Chipboard();
        shelf.setName("Полка");
        shelf.setEdging_bottom("blue");

        if (technicalConditions.getBack_type().equalsIgnoreCase("none")) {
            shelf.setEdging_top("blue");
        }

        if (!technicalConditions.getBack_type().equalsIgnoreCase("chipboard")) {
            shelf.setWidth(Integer.parseInt(technicalConditions.getDepth()));
        }
        shelf.setLength(Integer.parseInt(technicalConditions.getWidth()) - 32);
        return shelf;
    }

}
