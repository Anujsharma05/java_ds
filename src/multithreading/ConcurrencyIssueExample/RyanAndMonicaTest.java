package multithreading.ConcurrencyIssueExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RyanAndMonicaTest {
    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount();

        RyanAndMonicaJob ryan = new RyanAndMonicaJob(account, "Ryan", 50);
        RyanAndMonicaJob monica = new RyanAndMonicaJob(account, "Monica", 100);

        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(monica);
        service.execute(ryan);

        TimeUnit.SECONDS.sleep(5);
        System.out.println("balance: " + account.getBalance());
        service.shutdown();

    }
}
