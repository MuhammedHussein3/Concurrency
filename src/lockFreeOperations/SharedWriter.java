package lockFreeOperations;

public class SharedWriter implements Runnable{
    SharedResource sharedResource = new SharedResource();
    @Override
    public void run() {
        sharedResource.increment();
    }

    public void test(){
        System.out.println(sharedResource.getCounter());
    }
}
