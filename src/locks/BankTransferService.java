package locks;

import java.math.BigDecimal;
import java.util.Random;

public class BankTransferService {

    private final static Random random = new Random();


    public void transfer(BankAccount source, BankAccount destination, BigDecimal amount) throws InterruptedException{
        synchronized (source){
            synchronized (destination){
                source.setBalance(source.getBalance().subtract(amount));
                destination.setBalance(destination.getBalance().add(amount));
            }
        }
    }
}
