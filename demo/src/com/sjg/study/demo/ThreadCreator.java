package com.sjg.study.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadCreator {

    public static void main(String[] args) throws Exception{
        new MyThread().start();

        new Thread(new MyRunnable()).start();

        FutureTask<Integer> ft = new FutureTask<>(new MyCallable());
        new Thread(ft).start();
        System.out.println(ft.get());

    }


    static class MyThread extends Thread {
        public void run(){
            System.out.println("mythread");
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("myrunnable");
        }
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("MyCallable");
            return 1;
        }
    }

}
