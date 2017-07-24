package com.cycloneboy.thread.ch1;


import java.util.Date;

/**
 * Created by CycloneBoy on 2017/7/23.
 */
public class SimpleJavaApp {
    public static void main(String[] args) throws  Exception{
        while (true){
            System.out.println(new Date());
            Thread.sleep(1000);
        }
    }
}
