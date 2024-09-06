package com.example.concurrency;

public class CounterThreads {

    public static void main(String[] args) {
        // Thread 1: Count up to 20
        Thread countUpThread = new Thread(new CountUpRunnable());
        countUpThread.start();

        // Wait for countUpThread to finish before starting countDownThread
        try {
            countUpThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Thread 2: Count down to 0
        Thread countDownThread = new Thread(new CountDownRunnable());
        countDownThread.start();

        // Wait for countDownThread to finish
        try {
            countDownThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print Goodbye message
        System.out.println("Goodbye. ♥");
    }

    static class CountUpRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 20; i++) {
                System.out.println("Count Up: " + i);
                try {
                    Thread.sleep(100); // Simulate some work with sleep
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class CountDownRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 20; i >= 0; i--) {
                System.out.println("Count Down: " + i);
                try {
                    Thread.sleep(100); // Simulate some work with sleep
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
