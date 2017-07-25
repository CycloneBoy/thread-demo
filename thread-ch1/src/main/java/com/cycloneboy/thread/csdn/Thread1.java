package com.cycloneboy.thread.csdn;

/**
 * Created by CycloneBoy on 2017/7/25.
 */
public class Thread1 extends Thread{

    private  String name;
    public  Thread1(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
       for(int i = 0;i < 5;i++){
           System.out.println(name + " 运行 ：" +  i);
           try {
               sleep((int)Math.random() * 10);

           }catch (InterruptedException e){
               e.printStackTrace();
           }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }

    /**
     * join是Thread类的一个方法，启动线程后直接调用，即join()的作用是：
     * “等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。
     * 也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。
     * @param args
     */
    public static void main(String[] args)  {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        Thread1 mTh1 = new Thread1("A");
        Thread1 mTh2 = new Thread1("B");
        mTh1.start();
        mTh2.start();
        try {
            mTh1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            mTh2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
}


