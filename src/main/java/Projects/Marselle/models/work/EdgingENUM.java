package Projects.Marselle.models.work;

public enum EdgingENUM {
    EDGING16();

    private final String type;
    private final Integer costToWork;

    EdgingENUM() {
        this.type = "Кромление ЛДСП16";
        this.costToWork = 130;
    }

    public String getType() {
        return type;
    }

    public Integer getCostToWork() {
        return costToWork;
    }
}
