package javaHowToProgram.example8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {

    public static void main(String[] args) throws InterruptedException {
        Buffer sharedLocation = new SynchronizedBuffer();

        Producer producer = new Producer(sharedLocation);
        Consumer consumer = new Consumer(sharedLocation);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(producer);
        executorService.execute(consumer);

         executorService.shutdown();
         executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
