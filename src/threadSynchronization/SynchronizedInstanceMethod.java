package threadSynchronization;

public class SynchronizedInstanceMethod {

    // في المثال ده، الميثود deposit و getBalance هما محميين بالقفل. يعني لما تيجي تستخدم أي ميثود منهم، الـ thread لازم يمسك القفل الأول على الـ object الحالي قبل ما ينفذ الميثود.
    public static class Account{
        private int balance;

        public Account(int balance){
            this.balance = balance;
        }

        public synchronized void deposit(int amount){
            balance += amount;
        }

        public synchronized int getBalance(){
            return balance;
        }
    }
}
