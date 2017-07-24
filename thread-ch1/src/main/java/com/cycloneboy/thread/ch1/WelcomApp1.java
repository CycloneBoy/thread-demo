package com.cycloneboy.thread.ch1;

/**
 * Created by CycloneBoy on 2017/7/23.
 */
public class WelcomApp1 {
    public static void main(String[] args) {
        Thread welcomeThread = new Thread(new WelcomeTask());

        welcomeThread.start();
        
        System.out.printf("1.Welcome! I'm %s.%n ",Thread.currentThread().getName());
    }
}

class WelcomeTask implements Runnable{

    @Override
    public void run() {
        System.out.printf("2.Welcome! I'm %s.%n ",Thread.currentThread().getName());
    }
}