package ThreadLocal;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class Account{

    private AtomicReference<BigDecimal> balance = new AtomicReference<>(BigDecimal.ZERO);

    // Synchronized method to ensure thread-safe updates and reads
    public void deposit(BigDecimal amount) {
        balance.updateAndGet((a)->a.add(amount));
    }

    // Synchronized method to ensure thread-safe reads
    public BigDecimal getBalance() {
        return balance.get();
    }

}
