package javaHowToProgram.Aysnchronous;

import java.util.concurrent.CompletableFuture;

public class Exercise1 {

    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> {
                    return 5 + 3;
                });
        future.thenAccept(result -> {
            System.out.println("Result : "+result);
        });
    }
}
