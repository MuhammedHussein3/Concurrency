package javaHowToProgram.example6;

import java.util.concurrent.ArrayBlockingQueue;

public class SynchronizedBuffer implements Buffer {

    private int buffer = -1;
    private boolean occupied = false;

    public synchronized void blockingPut(int value) throws InterruptedException {
        while (occupied){
            System.out.println("Producer tries to write");
            displayState("Buffer full. Producer waits");
            wait();
        }

        buffer = value;
        occupied = true;

        displayState("Producer writes "+buffer);

        notifyAll();
    }

    private synchronized void displayState(String operation){
        System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
    }

    public synchronized int blockingGet() throws InterruptedException{

        while (!occupied){
            System.out.println("Consumer tries to read.");
            displayState("Buffer empty. Consumer waits");
            wait();
        }

        occupied = false;

        displayState("Consumer reads "+buffer);

        return buffer;
    }
}
