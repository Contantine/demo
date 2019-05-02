package com.example.demo.thread;

public class TestThread implements Runnable{

    public TestThread(){};

    public static void start(){
        Thread thread = new Thread(new TestThread());
        thread.setName("testThread");
        thread.start();
    }

    @Override
    public void run(){
        System.out.println("/********************线程启动********************/");
    }
}
