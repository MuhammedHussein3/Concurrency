package locks;

import java.math.BigDecimal;

public class BankAccount {


    private Long id;

    private BigDecimal balance;

    private String email;

    public BankAccount(Long id, BigDecimal balance, String email) {
        this.id = id;
        this.balance = balance;
        this.email = email;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
