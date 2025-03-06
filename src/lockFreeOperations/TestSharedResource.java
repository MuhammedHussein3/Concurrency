package lockFreeOperations;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSharedResource {

    public static void main(String[] args) {
       SharedResource sharedResource = new SharedResource();


       Thread th1 = new Thread(()->{
           for (int i = 1;i<=200;i++){
               sharedResource.increment();
           }
       });


        Thread th2 = new Thread(()->{
            for (int i = 1;i<=200;i++){
                sharedResource.increment();
            }
        });

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();

        }catch (Exception e){

        }
        System.out.println(sharedResource.getCounter());
    }
}
