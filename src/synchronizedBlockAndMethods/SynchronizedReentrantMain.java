package synchronizedBlockAndMethods;

public class SynchronizedReentrantMain {
    public static void main(String[] args) {
        SynchronizedReentrant reentrant = new SynchronizedReentrant();

        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        reentrant.method2();
                    }
                }
        , "Thread1");
        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        reentrant.method2();
                    }
                }
        , "Thread2");
        thread1.start();
        thread2.start();

    }
}
