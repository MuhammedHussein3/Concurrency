package javaHowToProgram.Aysnchronous;

import java.util.concurrent.CompletableFuture;

public class Exercise2 {

    public static void main(String[] args) {
        CompletableFuture<Integer> future1 =
                CompletableFuture.supplyAsync(() ->{
                    return 10 * 2;
                });
        CompletableFuture<Integer> future2 =
                CompletableFuture.supplyAsync(() ->{
                    return 29 * 2;
                });

        CompletableFuture<Integer> future3 = future1.thenCombine(future2, (res1, res2) -> {
            return res1 + res2;
        });

        future3.thenAccept(res -> {
            System.out.println("Combined Res "+res);
        });
    }




}
