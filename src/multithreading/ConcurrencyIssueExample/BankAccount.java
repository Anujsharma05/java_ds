package multithreading.ConcurrencyIssueExample;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {

    /**
     * Synchronized can cause performance issue and deadlock if not used correctly
     * In this case, it is working fine. But there is a better approach for this case
     */
    /*int balance = 100;

    public int getBalance() {
        return balance;
    }

    public synchronized void spend(String name, int amountSpent) {
        if(balance >= amountSpent) {
            balance = balance - amountSpent;
        } else {
            System.out.println("Sorry, not enough balance for " + name);
        }
    }*/

    final AtomicInteger balance = new AtomicInteger(100);

    public int getBalance() {
        return balance.get();
    }

    public void spend(String name, int amountSpent) {
        int initialBalance = balance.get();

        if(initialBalance >= amountSpent) {
            int remaining = initialBalance - amountSpent;
            boolean success = balance.compareAndSet(initialBalance, initialBalance-amountSpent);

            if(!success) {
                System.out.println(name + " your transaction failed");
            }
        } else {
            System.out.println("sorry not enough money for " + name);
        }
    }
}
