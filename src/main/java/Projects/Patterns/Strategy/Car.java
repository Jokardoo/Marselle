package Projects.Patterns.Strategy;

public class Car {
    private Accommodate accommodate;
    private Drive drive;


    public String getAccommodate() {
        return accommodate.accommodate();
    }

    public String getDrive() {
        return drive.drive();
    }

    public Car(Accommodate accommodate, Drive drive) {
        this.accommodate = accommodate;
        this.drive = drive;
    }
}
