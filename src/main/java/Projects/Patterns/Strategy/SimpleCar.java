package Projects.Patterns.Strategy;

public class SimpleCar implements Drive {
    @Override
    public String drive() {
        return "driving at an average speed";
    }
}
