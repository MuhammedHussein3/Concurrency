package threadSynchronization;

public class SynchronizedBlock {

  public static class Account{
        private int balance;

        public Account(int balance){
            this.balance = balance;
        }

        public void deposit(int amount){
            synchronized (this) {
                balance += amount;
            }
        }

        public int getBalance(){
            return balance;
        }
  }

}
