package synchronizedBlockAndMethods;

public class SyncCounter {

    private long count = 0;

    public void incCount(){
        synchronized (this) {
            this.count++;
        }
    }

    public long getCount(){
        return this.count;
    }
}
