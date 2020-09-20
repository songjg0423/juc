package com.sjg.study.demo;

public class ThreadState {

    public static void main(String[] args) throws Exception {
        Thread t1 = new MyThread1();
        System.out.println(t1.getState());

        t1.start();
        System.out.println(t1.getState());

        Thread.sleep(1000);
        System.out.println(t1.getState());

        t1.join();
        System.out.println(t1.getState());

        Thread t2 = new MyThread2();
        t2.start();

        Thread t3 = new MyThread2();
        t3.start();

        Thread.sleep(500);
        System.out.println(t2.getState());
        System.out.println(t3.getState());

        Thread t4 = new MyThread3();
        t4.start();
        Thread.sleep(1000);
        t4.interrupt();
    }

    public static class MyThread1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {

            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyThread2 extends Thread{
        @Override
        public void run() {
            ThreadState.doSomething();
        }
    }

    public static class MyThread3 extends Thread{
        @Override
        public void run() {
//            while(true){
//
//            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void doSomething(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
