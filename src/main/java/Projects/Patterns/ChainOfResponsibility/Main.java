package Projects.Patterns.ChainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        Schoolguy4 schoolguy4 = new Schoolguy4();
        Schoolguy10 schoolguy10 = new Schoolguy10();
        Teacher teacher = new Teacher();

        Homework homework = new Homework(600);
        schoolguy4.setNextHero(schoolguy10);
        schoolguy10.setNextHero(teacher);

        schoolguy4.tryDoHomework(homework);
    }
}
