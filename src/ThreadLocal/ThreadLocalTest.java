package ThreadLocal;

import java.math.BigDecimal;

public class ThreadLocalTest {

    public static void main(String[] args) {

        Account account = new Account();

        Thread thread1 = new Thread(()->{
            account.deposit(new BigDecimal(11));
            System.out.println("Thread1 :"+account.getBalance());
        });
        Thread thread2 = new Thread(()->{
            account.deposit(new BigDecimal(1));
            System.out.println("Thread2 :"+account.getBalance());
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){

        }

        System.out.println(account.getBalance());
    }
}
