package Projects.Marselle.models.furnitureGenerator.manicureTable;

import Projects.Marselle.models.furnitureGenerator.interfaces.TechnicalConditions;
import lombok.Data;

@Data
public class ManicureTableTechnicalConditions implements TechnicalConditions {

    private String height;
    private String commodeWidth;
    private String commodeDepth;

    private String commodeBottomType;
    private String commodeBackType;

    private String commodeShelfCount;


    private String tableTopThick;

    private String shelfCount;
    private String boxCount;
    private String boxWidth;   // ящик
    private String boxDepth;
    private String boxBackType;

    private String facadeType;

    private String doorsCount;
    private String innerShelves;

    @Override
    public boolean checkValues() {
        boolean heightCheck = height.matches("[0-9]+");
        boolean commodeWidthCheck = commodeWidth.matches("[0-9]+");
        boolean commodeDepthCheck = commodeDepth.matches("[0-9]+");
        boolean tableTopThickCheck = tableTopThick.matches("[0-9]+");
        boolean boxCountCheck = boxCount.matches("[0-9]*");
        boolean shelfCountCheck = shelfCount.matches("[0-9]*");


        if (heightCheck == false || commodeWidthCheck == false || commodeDepthCheck == false || tableTopThickCheck == false
        || boxCountCheck == false || shelfCountCheck == false) {
            // тест завален
            return false;
        }

        if (!commodeBackType.equalsIgnoreCase("hdf")
                && !commodeBackType.equalsIgnoreCase("chipboard")) {
            return false;
        }

        //TODO
        return  true;
    }
}
