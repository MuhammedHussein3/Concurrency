package threadSynchronization;

public class SynchronizedStaticMethod {
/*
في المثال ده، الميثود addToTotalBalance
و getTotalBalance هما static، وده يعني إن القفل بيتاخد على الـ class نفسه مش على object معين.
 ده مفيد لما تكون بتتعامل مع بيانات أو عمليات مشتركة بين كل الـ objects.
 */
    public static class Bank{
        private static int totalBalance = 0;

//        public static synchronized void addToTotalBalance(int amount){
//            totalBalance += amount;
//        }
//        public static synchronized int getTotalBalance(){
//            return totalBalance;
//        }


    /*
    في المثال ده، بنستخدم synchronized block جوه الميثود الـ static. هنا، القفل بيتاخد على الـ class Bank نفسه. الفايدة من الطريقة دي هي إنك ممكن تتحكم في حماية جزء معين بس من الكود جوا الميثود بدل ما تقفل الميثود كلها
     */
    public static void addToTotalBalance(int amount){

        synchronized (Bank.class) {
            totalBalance += amount;
        }
    }
    public static int getTotalBalance(){
         synchronized (Bank.class) {
             return totalBalance;
         }
    }
    }
}
