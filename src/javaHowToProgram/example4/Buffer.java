package javaHowToProgram.example4;

public interface Buffer {

     public void blockingPut(int value) throws InterruptedException;

     public int blockingGet() throws InterruptedException;
}
