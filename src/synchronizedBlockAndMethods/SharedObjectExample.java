package synchronizedBlockAndMethods;

import java.sql.ShardingKey;

public class SharedObjectExample {

    private Object monitor = null;

    public SharedObjectExample(Object monitor){
        if (monitor == null){
            throw new IllegalArgumentException(
                    "Monitor object can not be null"
            );
        }
        this.monitor = monitor;
    }

    public void criticalSection(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + " entered critical section");

            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " leaving critical section");
        }
    }
}
