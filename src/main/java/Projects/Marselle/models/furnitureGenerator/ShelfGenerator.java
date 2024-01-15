package Projects.Marselle.models.furnitureGenerator;

// Класс создает стеллажи со спецификацией

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Data
public class ShelfGenerator {

    private ShelfTechnicalConditions technicalConditions;


    public ShelfGenerator(ShelfTechnicalConditions conditions) {
        this.technicalConditions = conditions;
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
        if (technicalConditions.getTop_type().equalsIgnoreCase("shelf") || technicalConditions.getTop_type().equalsIgnoreCase("cap")) {
            // Если низ указан как полка или крышка
            if (technicalConditions.getBottom_type().equalsIgnoreCase("shelf") || technicalConditions.getBottom_type().equalsIgnoreCase("cap")) {
                // В этой части у нас все хорошо и мы делаем расчет

                side.setThick(16);
                side.setWidth(Integer.parseInt(technicalConditions.getDepth()));   // Ширина бока - это глубина стеллажа

                int length = Integer.parseInt(technicalConditions.getHeight() );

                // Если топ крышкой
                if (technicalConditions.getTop_type().equalsIgnoreCase("cap")) {
                    length = length - 16;
                }

                if (technicalConditions.getBottom_type().equalsIgnoreCase("cap")) {
                    length = length - 16;
                }

                side.setLength(length);

                // Кромка с лицевой стороны
                side.setEdging_bottom("blue");
                // Если задняя стенка из ЛДСП или отсутствует
                if (technicalConditions.getBack_type().equalsIgnoreCase("chipboard")
                        || technicalConditions.getBack_type().equalsIgnoreCase("none")) {
                    side.setEdging_top("blue");
                }
                // Если верхняя часть полкой
                if (technicalConditions.getTop_type().equalsIgnoreCase("shelf")) {
                    side.setEdging_left("blue");
                }
                // Если нижняя часть полкой
                if (technicalConditions.getBottom_type().equalsIgnoreCase("shelf")) {
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
        else {
            shelf.setWidth(Integer.parseInt(technicalConditions.getDepth()) - 16);
        }

        shelf.setLength(Integer.parseInt(technicalConditions.getWidth()) - 32);
        return shelf;
    }

    public Chipboard generateInternalShelf() {
        if (technicalConditions.checkValues() == false) {
            System.out.println("Ошибка параметров");
            return null;
        }

        Chipboard shelf = new Chipboard();
        shelf.setName("Внутренняя полка");
        shelf.setEdging_bottom("blue");

        if (technicalConditions.getBack_type().equalsIgnoreCase("none")) {
            shelf.setEdging_top("blue");
        }

        if (!technicalConditions.getBack_type().equalsIgnoreCase("chipboard")) {
            shelf.setWidth(Integer.parseInt(technicalConditions.getDepth()) - 16);
        }
        else {
            shelf.setWidth(Integer.parseInt(technicalConditions.getDepth()) - 32);
        }
        shelf.setLength(Integer.parseInt(technicalConditions.getWidth()) - 32);
        return shelf;
    }

    public boolean hasFacade() {
        String facade = technicalConditions.getFacade();

        if (facade.equalsIgnoreCase("internal_facade")
                    || facade.equalsIgnoreCase("exterior_facade")) {
            return true;
        }
        else {
            return false;
        }
    }

    public Chipboard generateFacade() {
        if (!hasFacade()) {
            return null;
        }
        int facadeHeight;
        int facadeWidth;

        // количество перекрываемых секций
        int sectionOverlap = Integer.parseInt(technicalConditions.getFacade_section_overlap());
        // Если фасад внутренний
        if (technicalConditions.getFacade().equalsIgnoreCase("internal_facade")) {
            if (sectionOverlap == 1) {
                facadeHeight = getDistanceBetweenHoles() - 24;
            } else if (sectionOverlap > 1) {
                facadeHeight = (getDistanceBetweenHoles() * sectionOverlap) - 24;
            }
            else {
                System.out.println("Ошибка в методе ' generateFacade()'");
                return null;
            }
        }
        // Если фасад наружний
        else if (technicalConditions.getFacade().equalsIgnoreCase("exterior_facade")) {

            if (sectionOverlap == 1) {
                facadeHeight = getDistanceBetweenHoles() + 8;
            } else if (sectionOverlap > 1) {
                facadeHeight = (getDistanceBetweenHoles() * sectionOverlap) + 8;
                System.out.println("facade height = " + facadeHeight);
            }
            else {
                System.out.println("Ошибка в методе ' generateFacade()'");
                return null;
            }
        }

        else  {
            System.out.println("Ошибка в методе ' generateFacade()'");
            return null;
        }

        if (technicalConditions.getFacade_type().equalsIgnoreCase("single")) {
            facadeWidth = Integer.parseInt(technicalConditions.getWidth()) - 8;
        }
        else if (technicalConditions.getFacade_type().equalsIgnoreCase("double")) {
            facadeWidth = ((Integer.parseInt(technicalConditions.getWidth()) - 14) / 2);
        }
        else {
            System.out.println("Ошибка в методе ' generateFacade()'");
            return null;
        }

        Chipboard facade =new Chipboard();
        facade.setName("Фасад");
        facade.setLength(facadeHeight);
        facade.setWidth(facadeWidth);
        facade.setEdgingRed();
        facade.setThick(16);

        return facade;
    }

    // Количество секций
    public int getSectionsCount() {
        int count = 1 + Integer.parseInt(technicalConditions.getShelf_count());
        System.out.println(count + " sections");
        return count;
    }

    public int getDistanceBetweenHoles() {
        int shelfHeight = Integer.parseInt(technicalConditions.getHeight());

        int sections = getSectionsCount();

        int result = (shelfHeight - 16) / sections;

        if (result > 0) {
            System.out.println("Distance between holes = " + result);
            return result;
        }
        System.out.println("Error on method 'getDistanceBetweenHoles'!");
        return 0;
    }

    public List<Chipboard> getShelf() {
        List<Chipboard> chipboardList = new ArrayList<>();

        chipboardList.add(generateSide());
        chipboardList.add(generateSide());
        chipboardList.add(generateTop());
        chipboardList.add(generateBottom());

        if (!technicalConditions.getBack_type().equalsIgnoreCase("none")) {
            chipboardList.add(generateBack());
        }

        // Если фасады есть
        if (!technicalConditions.getFacade().equalsIgnoreCase("none") && generateFacade() != null) {
            // Добавляем фасады
            if (technicalConditions.getFacade_type().equalsIgnoreCase("single")) {
                chipboardList.add(generateFacade());
            }
            else if (technicalConditions.getFacade_type().equalsIgnoreCase("double")) {
                chipboardList.add(generateFacade());
                chipboardList.add(generateFacade());
            }

            int internalShelvesCount = 0;

            if (!technicalConditions.getFacade_section_overlap().equalsIgnoreCase("0")
            && !technicalConditions.getFacade_section_overlap().equalsIgnoreCase("")) {
                internalShelvesCount = Integer.parseInt(technicalConditions.getFacade_section_overlap()) - 1;
            }


            int simpleShelvesCount = Integer.parseInt(technicalConditions.getShelf_count()) - internalShelvesCount;

            // добавляем обычные полки
            for (int i = 0; i < simpleShelvesCount; i++) {
                chipboardList.add(generateShelf());
            }
            // Добавляем внутренние полки
            for (int i = 0; i < internalShelvesCount; i++) {
                chipboardList.add(generateInternalShelf());
            }
        }
        // Если фасадов нет
        else {
            for (int i = 0; i < Integer.parseInt(technicalConditions.getShelf_count()); i++) {
                chipboardList.add(generateShelf());
            }
        }

        return chipboardList;
    }

    public static void main(String[] args) {
        ShelfTechnicalConditions conditions = new ShelfTechnicalConditions();

        conditions.setHeight("1800");
        conditions.setWidth("600");
        conditions.setDepth("350");
        conditions.setTop_type("shelf");
        conditions.setBottom_type("shelf");
        conditions.setBack_type("hdf");
        conditions.setLegs("adjustable_support");
        conditions.setShelf_count("4");
        conditions.setFacade("exterior_facade");
        conditions.setFacade_type("double");
        conditions.setFacade_section_overlap("2");
//        conditions.setInternal_shelves("1");

        ShelfGenerator shelfGenerator = new ShelfGenerator(conditions);
        shelfGenerator.setTechnicalConditions(conditions);

        System.out.println(shelfGenerator.generateSide());
        System.out.println("----------");
        System.out.println(shelfGenerator.generateShelf());
        System.out.println("----------");
        System.out.println(shelfGenerator.generateTop());
        System.out.println("----------");
        System.out.println(shelfGenerator.generateBottom());
        System.out.println("----------");
        System.out.println(shelfGenerator.generateBack());
        System.out.println("----------");
        System.out.println(shelfGenerator.generateFacade());
        System.out.println("----------");
    }
}
