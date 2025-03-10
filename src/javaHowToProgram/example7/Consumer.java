package javaHowToProgram.example7;

import java.security.SecureRandom;

public class Consumer implements Runnable{

    private final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;

    public Consumer(Buffer sharedLocation){
        this.sharedLocation = sharedLocation;
    }


    @Override
    public void run() {
        int sum =0;
        for (int i = 1; i <= 10 ; i++){
            try {
                Thread.sleep(generator.nextInt(500));
                sum += sharedLocation.blockingGet();

            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("%n%s %d%n%s%n",
                 "Consumer read values totaling", sum, "Terminating Consumer");
    }
}
