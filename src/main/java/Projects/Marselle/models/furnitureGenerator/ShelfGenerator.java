package Projects.Marselle.models.furnitureGenerator;

// Класс создает стеллажи со спецификацией

import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.standartPositions.materials.Chipboard;

public class ShelfGenerator {

//    public Product generateShelf(TechnicalConditions technicalConditions) {
//
//    }

    // Метод генерирует боковину по техническому условию
    public static Chipboard generateSide(TechnicalConditions technicalConditions) {
        Chipboard side = new Chipboard();

        Integer length = technicalConditions.getHeight();

        Integer sizeBetweenFloorAndFurniture = SizeCalculator.getDistanceBetweenFloorAndFurniture(technicalConditions);
        // Отнимаем расстояние футорок/колес/опор
        length = length - sizeBetweenFloorAndFurniture;

        // Если дно крышкой
        if (technicalConditions.isBottomLikeCap() && technicalConditions.getBottomCapThickness() != null) {
            length = length - technicalConditions.getBottomCapThickness();
        }

        // Если топ крышкой
        if (technicalConditions.isTopLikeCap() && technicalConditions.getTopCapThickness() != null) {
            length = length - technicalConditions.getTopCapThickness();
        }

        side.setName("Бок");

        side.setWidth(technicalConditions.getDepth());

        side.setLength(length);
        side.setEdging_bottom("blue");

        // Если сверху полка, то кромим
        if (technicalConditions.isTopLikeShelf()) {
            side.setEdging_left("blue");
        }
        // Если снизу полка, то кромим
        if (technicalConditions.isBottomLikeShelf()) {
            side.setEdging_right("blue");
        }
        // Если задняя стенка из ЛДСП
        if (technicalConditions.isBackWithChipboard() || technicalConditions.isBackOpened()) {
            side.setEdging_top("blue");
        }

        side.setThick(16);

        return side;
    }

    // Метод генерирует полку по техническому условию
    public static Chipboard generteShelf(TechnicalConditions technicalConditions) {
        Chipboard shelf = new Chipboard();
        shelf.setName("Полка");

        // длина полки
        Integer length = technicalConditions.getWidth() - 32;

        Integer width = technicalConditions.getDepth();

        // Если задняя стенка из ЛДСП
        if (technicalConditions.isBackWithChipboard()) {
            width = width - 16;
            shelf.setEdging_top(null);
        }

        shelf.setLength(length);
        shelf.setWidth(width);

        shelf.setEdging_bottom("blue");

        // Если задняя часть открыта
        if (technicalConditions.isBackOpened()) {
            shelf.setEdging_top("blue");
        }
        return shelf;
    }

    public static Chipboard generateTopCap(TechnicalConditions technicalConditions) {
        if (!technicalConditions.isTopLikeCap()) {
            return null;
        }

        Chipboard top = new Chipboard();
        top.setName("Верхняя крышка");
        top.setWidth(technicalConditions.getDepth());
        top.setLength(technicalConditions.getWidth());

        if (technicalConditions.getTopCapThickness() != null) {
            top.setThick(technicalConditions.getTopCapThickness());
        }
        else {
            top.setThick(16);
        }


        // Если верхняя крышка тонкой кромкой
        if (technicalConditions.isTopCapEdgingBlue()) {
            // если у шкафа сзади ХДФ
            if (technicalConditions.isBackWithHDF()) {
                top.setEdging_bottom("blue");
                top.setEdging_right("blue");
                top.setEdging_left("blue");
                top.setEdging_top(null);
            }
            else {
                top.setEdgingBlue();
            }
        }
        // Если верхняя крышка толстой кромкой
        else if (technicalConditions.isTopCapEdgingRed()) {

            if (technicalConditions.isBackWithHDF()) {
                top.setEdging_bottom("red");
                top.setEdging_right("red");
                top.setEdging_left("red");
                top.setEdging_top(null);
            }
            else {
                top.setEdgingRed();
            }
        }

        return top;
    }

//    public static Chipboard generateBottomCap (TechnicalConditions technicalConditions) {
//
//    }


    public static void main(String[] args) {
        TechnicalConditions conditions = new TechnicalConditions();

        conditions.setBackOpened(true);
        conditions.setDepth(300);
        conditions.setHeight(1800);
        conditions.setWidth(600);

        conditions.setHasLegSupport(true);

        conditions.setTopLikeCap(true);
        conditions.setTopCapThickness(26);
        conditions.setBottomLikeCap(true);
        conditions.setBottomCapThickness(26);

        conditions.setLegSupportSize(30);

        Chipboard side = generateSide(conditions);
        Chipboard shelf = generteShelf(conditions);

        System.out.println(side);
        System.out.println(shelf);
    }
}
