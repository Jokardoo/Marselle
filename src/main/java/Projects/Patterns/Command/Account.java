package Projects.Patterns.Command;

import lombok.Data;

@Data
public class Account {
    private String owner;
    private Integer money = 0;

    public Account(String owner) {
        this.owner = owner;
    }
}
