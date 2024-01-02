package Projects.Marselle.models.furnitureGenerator;

import lombok.Data;

@Data
public class TechnicalConditions {
    private Integer width;
    private Integer height;
    private Integer depth;

    private boolean bottomLikeCap;  // дно крышкой

    private boolean bottomCapEdgingRed;

    private boolean bottomCapEdgingBlue;
    private Integer bottomCapThickness; // толщина крышки, если она есть
    private boolean bottomLikeShelf;  // дно полкой

    private boolean topLikeCap;  // топ крышкой

    private Integer topCapThickness;

    private boolean topCapEdgingRed;

    private boolean topCapEdgingBlue;
    private boolean topLikeShelf;  // топ полкой

    private boolean backWithHDF;  // зад из ХДФ
    private boolean backWithChipboard;  // зад из ЛДСП
    private boolean backOpened; // задняя часть открытая


    private Integer shelfCount; // количество полок



    private boolean hasLegSupport;  // стоит на опорах
    private Integer legSupportSize;

    private boolean hasThreadedBus;    // стоит на футорках

    private boolean hasWheels;  // стоит на колесах



    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }




    public void setBottomLikeCap(boolean bottomLikeCap) {
        this.bottomLikeCap = bottomLikeCap;

        if (bottomLikeCap) {
            this.bottomLikeShelf = false;
        }
        else {
            this.bottomLikeShelf = true;
        }
    }   // если ставим дно крышкой, то bottomLikeShelf == false

    public void setBottomCapEdgingRed(boolean bottomCapEdgingRed) {
        this.bottomCapEdgingRed = bottomCapEdgingRed;

        if (bottomCapEdgingRed) {
            this.bottomCapEdgingBlue = false;
        }
        else {
            this.bottomCapEdgingBlue = true;
        }
    }

    public void setBottomCapEdgingBlue(boolean bottomCapEdgingBlue) {
        this.bottomCapEdgingBlue = bottomCapEdgingBlue;

        if (bottomCapEdgingBlue) {
            this.bottomCapEdgingRed = false;
        }

        else {
            this.topCapEdgingRed = true;
        }
    }

    public void setBottomCapThickness(Integer bottomCapThickness) {
        if (bottomLikeCap) {
            this.bottomCapThickness = bottomCapThickness;
        }
        else {
            this.bottomCapThickness = null;
        }
    }

    public void setBottomLikeShelf(boolean bottomLikeShelf) {
        this.bottomLikeShelf = bottomLikeShelf;

        if (bottomLikeShelf) {
            this.bottomLikeCap = false;
        }
        else {
            this.bottomLikeCap = true;
        }
    }





    public void setTopLikeCap(boolean topLikeCap) {
        this.topLikeCap = topLikeCap;

        if (topLikeCap) {
            this.bottomLikeShelf = false;
        }
        else {
            this.bottomLikeShelf = true;
        }
    }

    public void setTopCapEdgingRed(boolean topCapEdgingRed) {
        this.topCapEdgingRed = topCapEdgingRed;

        if (topCapEdgingRed == true) {
            this.topCapEdgingBlue = false;
        }
        else {
            this.topCapEdgingBlue = true;
        }
    }

    public void setTopCapEdgingBlue(boolean topCapEdgingBlue) {
        this.topCapEdgingBlue = topCapEdgingBlue;

        if (this.topCapEdgingBlue) {
            this.topCapEdgingRed = false;
        }
        else {
            this.topCapEdgingRed = true;
        }
    }

    public void setTopCapThickness(Integer topCapThickness) {
        if (topLikeCap) {
            this.topCapThickness = topCapThickness;
        }
        else {
            this.topCapThickness = null;
        }
    }

    public void setTopLikeShelf(boolean topLikeShelf) {
        this.topLikeShelf = topLikeShelf;

        if (topLikeShelf) {
            this.bottomLikeCap = false;
        }
        else {
            this.bottomLikeCap = true;
        }
    }


    public void setBackWithHDF(boolean backWithHDF) {
        this.backWithHDF = backWithHDF;

        if (backWithHDF) {
            this.backOpened = false;
            this.backWithChipboard = false;
        }
    }

    public void setBackWithChipboard(boolean backWithChipboard) {
        this.backWithChipboard = backWithChipboard;

        if (backWithChipboard) {
            this.backOpened = false;
            this.backWithHDF = false;
        }
    }

    public void setBackOpened(boolean backOpened) {
        this.backOpened = backOpened;

        if (backOpened) {
            this.backWithHDF = false;
            this.backWithChipboard = false;
        }
    }



    public void setShelfCount(Integer shelfCount) {
        if (shelfCount >= 0) {
            this.shelfCount = shelfCount;
        }
    }

    public void setHasLegSupport(boolean hasLegSupport) {
        this.hasLegSupport = hasLegSupport;

        if (hasLegSupport) {
            this.hasThreadedBus = false;
            this.hasWheels = false;
        }
    }

    public void setLegSupportSize(Integer legSupportSize) {
        if (this.hasLegSupport) {
            this.legSupportSize = legSupportSize;
        }
        else {
            this.legSupportSize = null;
        }
    }

    public void setHasThreadedBus(boolean hasThreadedBus) {
        this.hasThreadedBus = hasThreadedBus;

        if (hasThreadedBus) {
            this.hasLegSupport = false;
            this.hasWheels = false;
        }
    }

    public void setHasWheels(boolean hasWheels) {
        this.hasWheels = hasWheels;

        if (hasWheels) {
            this.hasThreadedBus = false;
            this.hasLegSupport = false;
        }
    }
}
