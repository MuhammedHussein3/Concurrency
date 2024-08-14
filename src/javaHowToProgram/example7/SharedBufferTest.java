package javaHowToProgram.example7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {

    public static void main(String[] args) throws InterruptedException {
        Buffer sharedLocation = new CircularBuffer();

        Producer producer = new Producer(sharedLocation);
        Consumer consumer = new Consumer(sharedLocation);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(producer);
        executorService.execute(consumer);

         executorService.shutdown();
         executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
