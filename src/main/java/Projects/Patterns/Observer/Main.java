package Projects.Patterns.Observer;

public class Main {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("task 3 from page 54", "Jimmy");
        teacher.addObserver(new Pupil(teacher));
        teacher.addObserver(new Pupil(teacher));
        teacher.addObserver(new Pupil(teacher));
        teacher.addObserver(new Pupil(teacher));

        for (Observer o : teacher.getPupils()) {
            o.tellMeYourHomeworkBuddy();
        }

        teacher.notifyObservers();
        System.out.println("-------------------------");

        for (Observer o : teacher.getPupils()) {
            o.tellMeYourHomeworkBuddy();
        }
    }

}
