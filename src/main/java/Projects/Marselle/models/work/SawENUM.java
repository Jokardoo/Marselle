package Projects.Marselle.models.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// тут устанавливаем стоимость распила

public enum SawENUM {
    CHIPBOARD4(4),
    CHIPBOARD10(10),
    CHIPBOARD16(16),    //TODO хз скок
    CHIPBOARD26(26);

    private final int value;
    private final String type;
    private final Integer costToWork;

    @Autowired
    SawENUM(int value) {
        this.value = value;

        if (value == 4) {
            this.type = "Распил ХДФ";
            this.costToWork = 50;
        }
        else if (value == 10) {
            this.type = "Распил ЛДСП10";
            this.costToWork = 100;  // TODO хз
        }
        else if (value == 16) {
            this.type = "Распил ЛДСП16";
            this.costToWork = 120;
        }
        else if (value == 26) {
            this.type = "Распил ЛДСП26";
            this.costToWork = 160;
        }
        else {
            this.type = "Распил";
            this.costToWork = 0;
        }
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public Integer getCostToWork() {
        return costToWork;
    }

    public static void main(String[] args) {
        System.out.println(SawENUM.CHIPBOARD4.getType());
    }
}
