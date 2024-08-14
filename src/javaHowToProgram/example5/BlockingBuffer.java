package javaHowToProgram.example5;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {

    private final ArrayBlockingQueue<Integer> buffer;

    public BlockingBuffer(){
        buffer = new ArrayBlockingQueue<>(1);
    }

    @Override
    public void blockingPut(int value) throws InterruptedException {

        System.out.println("Producer put "+ value + " buffer size "+buffer.size());
        buffer.put(value);

    }

    @Override
    public int blockingGet() throws InterruptedException {

        int readValue = buffer.take();
        System.out.println("Consumer reads "+ readValue+ " buffer size "+buffer.size());
        return readValue;
    }
}
