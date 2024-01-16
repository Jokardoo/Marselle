package Projects.Patterns.Command;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private static TransactionManager transactionManager = new TransactionManager();

    private List<Command> commands = new ArrayList<>();

    public void executeAllTransactions() {
        for (Command command : commands) {
            if (!command.getComplited()) {
                command.execute();
            }
        }
    }

    public void printAllTransactions() {
        for (Command command : commands) {
            if (!command.getComplited()) {
                System.out.println(command.getInfo());
            }
        }
    }

    public void addTransaction(Command command) {
        TransactionManager.getTransactionManager().getCommands().add(command);
    }

    private TransactionManager() {

    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public static TransactionManager getTransactionManager() {
        return transactionManager;
    }
}
