package synchronizedBlockAndMethods;

import JavaMemoryModel.MyRunnable;

public class SynchronizedLambda {

    private final Object monitor = new Object();

    public void performTask(){
        Runnable task = () -> {
            synchronized (monitor){
                System.out.println(Thread.currentThread().getName() + " is in the synchronized block");

                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is leaving the synchronized block");
            }
        };
        Thread t1 = new Thread(
                task, "Thread1"
        );
        Thread t2 = new Thread(
               task, "Thread2"
        );
        t1.start();
        t2.start();
    }
}
