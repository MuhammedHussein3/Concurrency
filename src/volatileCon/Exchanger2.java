package volatileCon;

public class Exchanger2 {

    private Object object = null;
    private volatile boolean hasNewObject = false;

    public void setObject(Object object) {
        this.object = object;
        this.hasNewObject = true;
    }

    public Object getObject() {

        while (this.hasNewObject){

        }
        Object returnValue = this.object;
        this.hasNewObject = false;
        return returnValue;
    }
}
