package callableAndFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureTest {

    public static final Runnable runnable = () -> {
        try {
            Thread.sleep(1000L);
            System.out.println("Execution done well using"+
                    Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };

    public static final Supplier<String> supplier = () -> {
        try {
            Thread.sleep(1000L);
            System.out.println("Execution done well using"+
                    Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Result from "+Thread.currentThread().getName();
    };
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        submitSupplyAsync(supplier);
    }

    public static void submitSupplyAsync(Supplier<String> supplier) throws ExecutionException, InterruptedException {
        System.out.println("CompletableFuture.supplyAsync === Demo");

        CompletableFuture<String> completableFuture = CompletableFuture
                .supplyAsync(supplier);
        System.out.println(completableFuture.get());
        System.out.println();
    }
}
