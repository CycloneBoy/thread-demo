package com.cycloneboy.thread.ch1;

/**
 * Created by CycloneBoy on 2017/7/23.
 */
public class WelcomApp2 {

    public static void main(String[] args) {
        Thread welcomeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("2.Welcome! I'm %s.%n",Thread.currentThread().getName());
            }
        });

        welcomeThread.start();
        welcomeThread.run();
        System.out.printf("1.Welcome! I'm %s.%n",Thread.currentThread().getName());
    }
}
