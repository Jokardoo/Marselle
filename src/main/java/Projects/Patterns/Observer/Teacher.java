package Projects.Patterns.Observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Teacher implements ObjectP {
    private String name;

    private String currentTask;

    private List<Observer> pupils;

    @Override
    public void notifyObservers() {
        for (Observer o : pupils) {
            o.acceptQuery();
        }
    }

    public Teacher(String currentTask, String name) {
        this.pupils = new ArrayList<>();
        this.currentTask = currentTask;
        this.name = name;
    }

    @Override
    public void addObserver(Observer observer) {
        pupils.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        pupils.remove(observer);
    }
}
