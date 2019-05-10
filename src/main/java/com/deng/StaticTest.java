package com.deng;

/**
 * Created by dengyunqing on 2019/1/18.
 */
public class StaticTest {

    static {
        synchronized (StaticTest.class) {
            System.out.println("static");
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args) {
        new Thread () {
            public void run () {
                StaticTest.m1();
            }
        }.start();
        new Thread () {
            public void run () {
                StaticTest.m3();
            }
        }.start();
    }

    public synchronized static void m1 () {
        System.out.println("m1");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void m2 () {
        System.out.println("m2");
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m3 () {
        System.out.println("m3");
    }
}
