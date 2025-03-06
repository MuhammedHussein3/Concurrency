package JavaMemoryModel;

public class Test {

    public static void main(String[] args) {

        Runnable runnable = new MyRunnable(new Object());

        Thread thread1 =
                new Thread(runnable, "Thread 1");
        Thread thread2 =
                new Thread(runnable, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
