package synchronizedBlockAndMethods;

public class SynchronizedReentrant {

    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName() + " enter to method 1");

        System.out.println(Thread.currentThread().getName() + " out from method 1");
    }
    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName() + " enter to method 2");
        method1();
        System.out.println(Thread.currentThread().getName() + " out from method 2");
    }
}
