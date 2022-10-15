package multithreading.ConcurrencyIssueExample;

public class RyanAndMonicaJob implements Runnable {

    BankAccount account;
    String name;
    int amountToSpend;

    public RyanAndMonicaJob(BankAccount account, String name, int amountToSpend) {
        this.account = account;
        this.name = name;
        this.amountToSpend = amountToSpend;
    }

    @Override
    public void run() {
        goShopping();
    }

    public void goShopping() {
        System.out.println(name + " is about to spend");
        account.spend(name, amountToSpend);
        System.out.println(name + " finishes spending");
    }
}
