package org.charles.coding.multithreading;

import java.util.List;
import java.util.stream.IntStream;

public class CreatingAThread {
    public static void main(String[] args) throws InterruptedException {
        // Creating a thread from a class that extends Thread
        Multi multi = new Multi();
        multi.start();

    }
}

class Multi extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
    }
}