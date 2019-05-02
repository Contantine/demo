package com.example.demo.listener;

import com.example.demo.thread.TestThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent arg0){
        System.out.println("/**************************监听器启动*******************/");
        TestThread.start();
    }
}
