package JavaMemoryModel;

public class MyRunnable implements Runnable{

    private int count = 0;
    private Object object = null;

    public MyRunnable(){}
    public MyRunnable(Object object){
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println(object);
        for (int i = 0;i<1_000_000;i++){
            this.count++;
        }
        System.out.println(
                Thread.currentThread().getName() +
                        " : "+ this.count
        );
    }
}
