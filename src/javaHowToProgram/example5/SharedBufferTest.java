package javaHowToProgram.example5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {

    public static void main(String[] args) throws InterruptedException {
        Buffer sharedLocation = new BlockingBuffer();

        Producer producer = new Producer(sharedLocation);
        Consumer consumer = new Consumer(sharedLocation);

        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(2);

        executorService.execute(producer);
        executorService.execute(consumer);

         countDownLatch.await();
         executorService.shutdown();
         executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
