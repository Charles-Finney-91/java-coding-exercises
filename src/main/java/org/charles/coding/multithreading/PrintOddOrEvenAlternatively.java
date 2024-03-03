package org.charles.coding.multithreading;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintOddOrEvenAlternatively {

    public static void main(String[] args) throws InterruptedException {
        PrintOddOrEvenAlternatively print = new PrintOddOrEvenAlternatively();
        List<Integer> list = IntStream.rangeClosed(2, 10).boxed().collect(Collectors.toList());

        Thread oddThread = new Thread(() -> print.printOddV2(list), "OddThread");
        Thread evenThread = new Thread(() -> print.printEvenV2(list), "EvenThread");

        oddThread.start();
        evenThread.start();
    }

    public void printOdd(List<Integer> list){
        synchronized (this){
            for (int i = 0; i < list.size(); i++) {
                if (!isEven(list.get(i))) {
                    System.out.printf("[%s]: %d is Odd.%n", Thread.currentThread().getName(), list.get(i));
                }

                notify();

                if (i<list.size()-1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void printEven(List<Integer> list){
        synchronized (this){
            for (int i = 0; i < list.size(); i++) {
                if (isEven(list.get(i))) {
                    System.out.printf("[%s]: %d is Even.%n", Thread.currentThread().getName(), list.get(i));
                }

                notify();

                if (i<list.size()-1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void printOddV2(List<Integer> list){
        synchronized (this){
            for (Integer integer : list) {
                if (!isEven(integer)) {
                    System.out.printf("[%s]: %d is Odd.%n", Thread.currentThread().getName(), integer);
                }

                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            notify();
        }
    }

    public void printEvenV2(List<Integer> list){
        synchronized (this){
            for (Integer integer : list) {
                if (isEven(integer)) {
                    System.out.printf("[%s]: %d is Even.%n", Thread.currentThread().getName(), integer);
                }

                notify();
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            notify();
        }
    }

    private boolean isEven(int num){
        return num % 2 == 0;
    }
}
