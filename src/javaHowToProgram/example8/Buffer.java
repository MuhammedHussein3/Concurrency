package javaHowToProgram.example8;

public interface Buffer {

     public void blockingPut(int value) throws InterruptedException;

     public int blockingGet() throws InterruptedException;
}
