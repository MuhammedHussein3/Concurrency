package javaHowToProgram.example5;

public interface Buffer {

     public void blockingPut(int value) throws InterruptedException;

     public int blockingGet() throws InterruptedException;
}
