package synchronizedBlockAndMethods;

import JavaMemoryModel.MyRunnable;

public class SynchronizationExchangerMain {

    public static void main(String[] args) {
        SynchronizationExchanger exchanger = new SynchronizationExchanger();

        Thread thread1 = new Thread(
                new MyRunnable(){
                    @Override
                    public void run(){
                        for (int i = 0; i < 1000; i++){
                            exchanger.setObject(""+i);
                        }
                    }
                }
        );
        Thread thread2 = new Thread(
                new MyRunnable(){
                    @Override
                    public void run(){
                        for (int i = 0; i < 1000; i++){
                            System.out.println(exchanger.getObject());
                        }
                    }
                }
        );

        thread1.start();
        thread2.start();
    }


}
