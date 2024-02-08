package Projects.Patterns.Facade;

public class Computer {
    private Monitor monitor;
    private Keyboard keyboard;
    private Spotify spotify;

    public Computer(Monitor monitor, Keyboard keyboard, Spotify spotify) {
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.spotify = spotify;
    }

    public void execute() {
        monitor.turnOn();
        keyboard.use();
        spotify.listen();
    }
}


