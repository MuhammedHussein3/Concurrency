package javaHowToProgram.example7;

public interface Buffer {

     public void blockingPut(int value) throws InterruptedException;

     public int blockingGet() throws InterruptedException;
}
