package synchronizedBlockAndMethods;

import JavaMemoryModel.MyRunnable;

public class SharedMonitorObjectMain {

    public static void main(String[] args) {
        Object monitor1 = new Object();
        SharedObjectExample smo1 = new SharedObjectExample(monitor1);
        SharedObjectExample smo2 = new SharedObjectExample(monitor1);

        Thread th1 =  new Thread(
                new MyRunnable(){
                    @Override
                    public void run(){
                        smo1.criticalSection();
                    }
                }
        , "Thread1");
        Thread th2 =  new Thread(
                new MyRunnable(){
                    @Override
                    public void run(){
                        smo2.criticalSection();
                    }
                }
        , "Thread2");

        th1.start();
        th2.start();
    }
//    Object monitor1
//            = new Object();
//
//    SharedMonitorObject smo1 = new SharedMonitorObject(monitor1);
//
//    SharedMonitorObject smo2 = new SharedMonitorObject(monitor1);
//
//    Object monitor2
//            = new Object();
//    SharedMonitorObject smo3 = new SharedMonitorObject(monitor2);

}
