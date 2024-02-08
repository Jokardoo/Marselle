package Projects.Patterns.ChainOfResponsibility;

public class Teacher implements HomeworkPower {
    private int mindPower = 1337;
    private HomeworkPower nextHero;

    @Override
    public void tryDoHomework(Homework homework) {
        if (homework.getHomeworkLevel() <= this.mindPower) {
            System.out.println("Teacher do homework");
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
