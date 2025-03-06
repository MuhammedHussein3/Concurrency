package synchronizedBlockAndMethods;

public class SynchronizationExchanger {

    protected Object object = null;


    public synchronized void setObject(Object object) {
        this.object = object;
    }

    public synchronized Object getObject() {
        return this.object;
    }

    public synchronized void setObj(Object object) {
        synchronized (this){
            this.object = object;
        }

    }

    public Object getObj() {
        synchronized (this){
            return this.object;
        }
    }

}
