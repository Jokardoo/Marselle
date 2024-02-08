package Projects.Marselle.models.furnitureGenerator.shelf;

import Projects.Marselle.models.furnitureGenerator.interfaces.TechnicalConditions;
import lombok.Data;

@Data
public class ShelfTechnicalConditions implements TechnicalConditions {
    private String width;
    private String height;
    private String depth;

    private String top_type;
    private String bottom_type;
    private String back_type;

    private String legs;
    private String shelf_count;

    private String facade;
    private String facade_type;

//    private String internal_shelves;

    private String facade_section_overlap;

    // проверяет валидность параметров
    @Override
    public boolean checkValues() {
        boolean check1 = height.matches("[0-9]+");
        boolean check2 = width.matches("[0-9]+");
        boolean check3 = depth.matches("[0-9]+");
        boolean check4 = shelf_count.matches("[0-9]+");


        if (check1 == false || check2 == false || check3 == false || check4 == false) {
            // тест завален
            return false;
        }

        if (!top_type.equalsIgnoreCase("shelf") && !top_type.equalsIgnoreCase("cap")) {
            // Если это не полка и не крышка
            return false;
        }

        if (!bottom_type.equalsIgnoreCase("shelf") && !bottom_type.equalsIgnoreCase("cap")) {
            // Если это не полка и не крышка
            return false;
        }

        if (!back_type.equalsIgnoreCase("hdf")
                && !back_type.equalsIgnoreCase("chipboard")
                && !back_type.equalsIgnoreCase("none")) {
            return false;
        }

        if (!legs.equalsIgnoreCase("adjustable_support") && !legs.equalsIgnoreCase("support")) {
            return false;
        }

        if (!facade.equalsIgnoreCase("internal_facade")
                && !facade.equalsIgnoreCase("exterior_facade")
                && !facade.equalsIgnoreCase("none")) {
            return false;
        }

        if (!facade_type.equalsIgnoreCase("single")
                && !facade_type.equalsIgnoreCase("double")
                && !facade_type.equalsIgnoreCase("none")) {
            return false;
        }

//        if (!internal_shelves.matches("[0-9]*")) {
//            return false;
//        }

        if (!facade_section_overlap.matches("[0-9]*")) {
            return false;
        }

        if (!facade.equalsIgnoreCase("none")) {
            if (Integer.parseInt(getFacade_section_overlap()) > Integer.parseInt(getShelf_count()) + 1) {
                return false;
            }
        }

        return true;
    }

}
