package javaHowToProgram.example4;

import java.security.SecureRandom;

public class Producer implements Runnable{

    private final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;

    public Producer(Buffer sharedLocation){
        this.sharedLocation = sharedLocation;
    }


    @Override
    public void run() {
        int sum =0;
        for (int i = 1; i <= 10 ; i++){
            try {
              Thread.sleep(generator.nextInt(500));
              sharedLocation.blockingPut(i);
                sum+= i;

            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("Producer done producing %2d", sum);
    }
}
