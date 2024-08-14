package javaHowToProgram.example4;

public class UnsynchronizedBuffer implements Buffer{


    int buffer = -1;
    @Override
    public synchronized void blockingPut(int value) throws InterruptedException {

        System.out.printf("Producer put %2d/t", value);
            buffer = value;

    }

    @Override
    public synchronized int blockingGet() throws InterruptedException {

        System.out.printf("Consumer reads %2d/t", buffer);
        return buffer;
    }
}
