package Projects.Patterns.Facade;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer(new Monitor(), new Keyboard(), new Spotify());

        computer.execute();
    }
}
