package javaHowToProgram.example2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedArrayTest {

    public static void main(String[] args) {
        SimpleArray sharedSimpleArray = new SimpleArray(6);
        ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
        ArrayWriter writer2 = new ArrayWriter(11, sharedSimpleArray);
        ArrayWriter writer3 = new ArrayWriter(16, sharedSimpleArray);
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(writer1);
        executorService.execute(writer2);

        executorService.shutdown();
      //  executorService.execute(writer3);

        try {
            boolean tasksEnded =
                    executorService.awaitTermination(1, TimeUnit.MINUTES);
            if (tasksEnded){
                System.out.printf("%n Contents of SimpleArray: %n");
                System.out.println(sharedSimpleArray);
            }else
                System.out.println("timed out while waiting for tasks to finish");
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
