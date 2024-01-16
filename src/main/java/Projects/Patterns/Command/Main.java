package Projects.Patterns.Command;

public class Main {
    public static void main(String[] args) {
        TransactionManager transactionManager = TransactionManager.getTransactionManager();
        Account account = new Account("Jimmy");

        transactionManager.addTransaction(new Deposit(account, 300));
        transactionManager.printAllTransactions();
        System.out.println("-------------------------------------------------");

        transactionManager.addTransaction(new Deposit(account, 400));
        transactionManager.printAllTransactions();
        System.out.println("-------------------------------------------------");

        transactionManager.addTransaction(new Withdraw(account, 200));
        transactionManager.printAllTransactions();
        System.out.println("-------------------------------------------------");
        System.out.println(account.getMoney());

        System.out.println("-------------------------------------------------");

        transactionManager.executeAllTransactions();
        System.out.println("-------------------------------------------------");

        transactionManager.printAllTransactions();
        System.out.println(account.getMoney());
    }


}
