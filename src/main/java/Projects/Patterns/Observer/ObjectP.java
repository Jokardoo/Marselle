package Projects.Patterns.Observer;

public interface ObjectP {
    void notifyObservers();

    void addObserver(Observer observer);

    void removeObserver(Observer observer);
}
