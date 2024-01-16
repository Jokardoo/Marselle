package Projects.Patterns.Command;

public class Withdraw implements Command {
    private Account account;
    private Integer amount;
    private Boolean isComplited = false;


    @Override
    public void execute() {
        if (!isComplited) {
            if (account.getMoney() >= amount) {
                account.setMoney(account.getMoney() - amount);
                isComplited = true;
            }
            else {
                System.out.println("insufficient funds");
            }
        }
        else {
            System.out.println("This transaction has already been closed");
        }
    }

    public Withdraw(Account account, Integer amount) {
        this.account = account;
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean getComplited() {
        return isComplited;
    }

    public void setComplited(Boolean complited) {
        isComplited = complited;
    }

    @Override
    public String getInfo() {
        return "Withdraw, account - " + account.getOwner() + ", amount - " + getAmount();
    }
}
