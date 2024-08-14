package javaHowToProgram.example8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedBuffer implements Buffer{

    private final Lock accessLock = new ReentrantLock();

    private final Condition canWrite = accessLock.newCondition();
    private final Condition canRead = accessLock.newCondition();

    private int buffer = -1;
    private boolean occupied = false;

    public void blockingPut(int value) throws InterruptedException {

        accessLock.lock();
      try {
          while (occupied) {
              System.out.println("Producer tries to write.");
              displayState("Buffer full. Producer waits.");
              canWrite.await();
          }
          buffer = value;
          occupied = true;
          displayState("Producer writes "+buffer);
          canRead.signalAll();
      }finally {
          accessLock.unlock();
      }
    }

    public int blockingGet(){

        accessLock.lock();
        try {
            while (!occupied){
                System.out.println("Consumer tries to read");
                displayState("Buffer empty. Consumer waits.");
                canRead.await();
            }

            occupied = false;
            displayState("Consumer reads "+buffer);
            canWrite.signalAll();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            accessLock.unlock();
        }
        return buffer;
    }

    public void displayState(String operation){

        try {
            accessLock.lock();
            System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer,
                     occupied);
        }
        finally {
            accessLock.unlock();
        }
    }
}
