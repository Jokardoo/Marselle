package Projects.Patterns.Observer;

import lombok.Data;

@Data
public class Pupil implements Observer {
    private String task;

    // За данным объектом мы наблюдаем
    private Teacher teacher;

    @Override
    public void acceptQuery() {
        this.task = teacher.getCurrentTask();
    }

    public Pupil(Teacher teacher) {
        this.teacher = teacher;
    }

    public void tellMeYourHomeworkBuddy() {
        if (task == null) {
            System.out.println("My teacher not give me a task, mom! Im free!!!!");
        }
        else {
            System.out.printf("burn in hell, %s! My task is: %s", teacher.getName(), task);
            System.out.println("");
        }
    }
}
