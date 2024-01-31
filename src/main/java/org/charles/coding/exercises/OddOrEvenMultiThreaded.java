package org.charles.coding.exercises;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class OddOrEvenMultiThreaded {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1, 10).forEach(num -> {
            CompletableFuture<Integer> odd = CompletableFuture.completedFuture(num);
            odd.thenApplyAsync(i -> {
                if (i%2 != 0)
                    System.out.printf("i=%s, [OddThread]%n", i);
                return num;
            }, executorService);
            odd.join();

            CompletableFuture<Integer> even = CompletableFuture.completedFuture(num);
            even.thenApplyAsync(i -> {
                if (i%2 == 0)
                    System.out.printf("i=%s, [EvenThread]%n", i);
                return num;
            }, executorService);
            even.join();
        });

        executorService.shutdown();
    }
}
