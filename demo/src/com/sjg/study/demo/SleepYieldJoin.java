package com.sjg.study.demo;

public class SleepYieldJoin {

    public static void main(String[] args) {
//        testSleep();

//        testYield();

        testJoin();
    }

    public static void testSleep(){
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Sleep:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void testYield() {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A:" + i);
                if (i%10 == 0)Thread.yield();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("B:" + i);
                if (i%10 == 0)Thread.yield();
            }
        }).start();
    }

    public static void testJoin() {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("A:" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            System.out.println(" t2 start");
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" t2 end");
        });
        t1.start();
        t2.start();
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
