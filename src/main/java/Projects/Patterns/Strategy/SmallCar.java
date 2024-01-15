package Projects.Patterns.Strategy;

public class SmallCar implements Accommodate {
    @Override
    public String accommodate() {
        return "accommodates few people";
    }
}
