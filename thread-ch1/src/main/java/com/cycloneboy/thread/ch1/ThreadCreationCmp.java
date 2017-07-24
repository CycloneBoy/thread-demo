package com.cycloneboy.thread.ch1;

import com.cycloneboy.thread.utils.Tools;

/**
 * Created by CycloneBoy on 2017/7/23.
 */
public class ThreadCreationCmp {

    public static void main(String[] args) {
        Thread t;
        CountingTask ct = new CountingTask();

        final int numberOfProcessors = Runtime.getRuntime().availableProcessors();

        for(int i =0;i < 2 * numberOfProcessors; i ++){
            t = new Thread(ct);
            t.start();
        }

        for(int i = 0; i< 2 * numberOfProcessors; i++){
            t = new CountingThread();
            t.start();

        }
    }

    static class  Counter{
        private int count = 0;

        public void increment(){
            count++;
        }

        public int value(){
            return count;
        }
    }

    static class CountingTask implements Runnable{
        private Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomeThing();
                counter.increment();
            }
            System.out.println("CountingTask: " + counter.value());
        }

        private void doSomeThing() {
            Tools.randomPause(80);
        }
    }

    static  class CountingThread extends Thread{
        private Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomeThing();
                counter.increment();
            }
            System.out.println("CountingThread: " + counter.value());
        }

        private void doSomeThing() {
            Tools.randomPause(80);
        }
    }
}

