package lockFreeOperations;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {

    AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        this.counter.incrementAndGet();
    }

    public int getCounter(){
        return this.counter.get();
    }


}
