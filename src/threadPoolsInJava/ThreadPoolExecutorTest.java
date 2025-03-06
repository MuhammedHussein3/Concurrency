package threadPoolsInJava;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {

        int minCoreSize = 2;
        int maxCorSize = 4;
        int queueSize = 3;
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES
        , new ArrayBlockingQueue<>(queueSize), new CustomThreadFactory(), new CustomerRejectHandler());



        for (int i = 1;i<=8  ;i++){
            poolExecutor.submit(()->{
                try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                System.out.println("Task processed by: "+Thread.currentThread().getName());
            });
        }

        poolExecutor.shutdown();

    }
}
class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {

        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);
        return th;
    }
}
class CustomerRejectHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        System.out.println("Task rejected: " + r.toString());
    }
}
