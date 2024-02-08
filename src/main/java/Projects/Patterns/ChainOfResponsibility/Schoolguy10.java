package Projects.Patterns.ChainOfResponsibility;

import lombok.Data;

@Data
public class Schoolguy10 implements HomeworkPower{
    private int mindPower = 500;
    private HomeworkPower nextHero;

    @Override
    public void tryDoHomework(Homework homework) {
        if (homework.getHomeworkLevel() <= this.mindPower) {
            System.out.println("Smart Schoolguy do homework");
            return;
        }

        if (homework.getHomeworkLevel() > this.mindPower && nextHero != null) {
            nextHero.tryDoHomework(homework);
        }
        else {
            System.out.println("Nobody can't do that homework");
        }
    }
}
