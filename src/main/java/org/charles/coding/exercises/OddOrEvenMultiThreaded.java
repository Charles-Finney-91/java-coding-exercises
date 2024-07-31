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
            odd.thenApplyAsync(i -> printOddNumbers(num, i), executorService);
            odd.join();

            CompletableFuture<Integer> even = CompletableFuture.completedFuture(num);
            even.thenApplyAsync(i ->  printEvenNumbers(num, i), executorService);
            even.join();
        });

        executorService.shutdown();
    }

    private static int printEvenNumbers(int num, Integer i) {
        if (isEven(i))
            System.out.printf("i=%s, [EvenThread]%n", i);
        return num;
    }

    private static boolean isEven(Integer i) {
        return i % 2 == 0;
    }

    private static int printOddNumbers(int num, Integer i) {
        if (!isEven(i))
            System.out.printf("i=%s, [OddThread]%n", i);
        return num;
    }
}
