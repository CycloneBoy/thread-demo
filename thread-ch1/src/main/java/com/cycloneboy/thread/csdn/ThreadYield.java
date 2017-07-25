package com.cycloneboy.thread.csdn;

/**
 * Created by CycloneBoy on 2017/7/25.
 */
public class ThreadYield extends Thread{
    public ThreadYield(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println(" " + this.getName() + " -------- " + i);
            if( i == 30){
                this.yield();
            }
        }
    }

    public static void main(String[] args) {
        ThreadYield yt1 = new ThreadYield("张三");
        ThreadYield yt2 = new ThreadYield("李四");
        yt1.start();
        yt2.start();
    }
}
