package Projects.Patterns.ChainOfResponsibility;

import lombok.Data;

@Data
public class Homework {
    private int homeworkLevel;

    public Homework(int homeworkLevel) {
        this.homeworkLevel = homeworkLevel;
    }


}
