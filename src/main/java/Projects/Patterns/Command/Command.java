package Projects.Patterns.Command;

public interface Command {
    void execute();
    boolean getComplited();

    String getInfo();
}
