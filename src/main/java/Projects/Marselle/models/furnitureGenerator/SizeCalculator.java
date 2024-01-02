package Projects.Marselle.models.furnitureGenerator;

public class SizeCalculator {

    public static Integer getDistanceBetweenFloorAndFurniture(TechnicalConditions conditions) {
        // Если на опорах
        // TODO
        if (conditions.isHasLegSupport() && !conditions.isHasWheels() && !conditions.isHasThreadedBus()) {
            // Если указана высота опор
            if (conditions.getLegSupportSize() != null) {
                return conditions.getLegSupportSize();
            }
            else {
                return 27;
            }
        }

        // Если на колесах
        else if (!conditions.isHasLegSupport() && conditions.isHasWheels() && !conditions.isHasThreadedBus()) {
            return 50;
        }

        // Если на футорках
        else if (!conditions.isHasLegSupport() && !conditions.isHasWheels() && conditions.isHasThreadedBus()) {
            return 10;
        }

        // Если ничего не указано
        else {
            return 0;
        }
    }
}
