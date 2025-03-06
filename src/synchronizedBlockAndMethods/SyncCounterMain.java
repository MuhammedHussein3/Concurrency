package synchronizedBlockAndMethods;

public class SyncCounterMain {
    public static void main(String[] args) {
    SyncCounter syncCounter = new SyncCounter();



    Thread thread1 = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000_000; i++) {
                        syncCounter.incCount();
                    }
                    System.out.println(syncCounter.getCount());
                }
            }
    );
        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000_000; i++) {
                            syncCounter.incCount();
                        }
                        System.out.println(syncCounter.getCount());
                    }
                }
        );
    thread1.start();
    thread2.start();
}
}
