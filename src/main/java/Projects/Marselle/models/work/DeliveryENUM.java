package Projects.Marselle.models.work;

public enum DeliveryENUM {
    NEWCITY("Новый город"),
    OLDCITY("Старый город"),
    KOMSOMOLSKIY("Комсомольский район"),
    SAMARA("Самара");

    private final String district;
    private final Integer costToWork;

    DeliveryENUM(String district) {
        this.district = district;
        if (district.equalsIgnoreCase("Новый город")) {
            this.costToWork = 250;  //TODO хз скок
        }
        else if (district.equalsIgnoreCase("Старый город")) {
            this.costToWork = 200;  //TODO хз скок
        }
        else if (district.equalsIgnoreCase("Комсомольский район")) {
            this.costToWork = 220;  //TODO хз скок
        }
        else if (district.equalsIgnoreCase("Самара")) {
            this.costToWork = 300;  //TODO хз скок
        }
        else {

            costToWork = 200;
        }
    }

    public String getDistrict() {
        return district;
    }

    public Integer getCostToWork() {
        return costToWork;
    }
}
