package javaHowToProgram.example3;

public class ArrayWriter implements Runnable{

    private final SimpleArray sharedSimpleArray;
    private final int startValue;

    public ArrayWriter(int value, SimpleArray array){
        this.sharedSimpleArray = array;
        this.startValue = value;
    }

    @Override
    public void run(){
        for (int i = startValue; i < startValue + 3; i++){
            sharedSimpleArray.add(i);
        }
    }
}
