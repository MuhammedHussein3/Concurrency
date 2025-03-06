package callableAndFuture;

import java.util.concurrent.*;

public class CallableInterface {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                2,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2)
                );

        Callable<String> callable = () -> {
            Thread.sleep(6000);
            return "Result returned from "+Thread.currentThread().getName();
        };

        System.out.println("Submitting Callable");
        Future<String> future = threadPoolExecutor.submit(callable);

        int statusCheckCount = 0;
        while (!future.isDone()){

            statusCheckCount++;
            System.out.println("Task in progress");
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);

            if (statusCheckCount > 5){
                future.cancel(true);
            }
        }
        if (!future.isCancelled()) {
            System.out.println("Task Completed");
            String res = future.get();
            System.out.println("Result is: "+res);
        }else {
            System.out.println("Task Canceled");
        }
    }
}


