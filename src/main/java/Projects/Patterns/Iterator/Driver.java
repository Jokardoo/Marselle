package Projects.Patterns.Iterator;

import lombok.Data;

@Data
public class Driver {
    private boolean isGoodDriver;
    private String name;

    public Driver(boolean isGoodDriver, String name) {
        this.isGoodDriver = isGoodDriver;
        this.name = name;
    }

    public boolean isGoodDriver() {
        return isGoodDriver;
    }
}
