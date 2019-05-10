package com.deng.ProduceConsumer;

import com.deng.DeadLock.Product;

/**
 * Created by dengyunqing on 2019/1/21.
 */
public class ProduceConsumerTest {

    private final Object LOCK = new Object();

    private volatile boolean isProduct =false ;
    private int i = 0;
    public void produce () {
        synchronized (LOCK) {
            System.out.println(Thread.currentThread().getName()+"produce");
            if (isProduct) {
                try {
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName()+"wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                i++;
                isProduct = true;
                LOCK.notify();
                System.out.println("P->" + i);
            }
        }
    }

    public void consumer () {
        synchronized (LOCK) {
            System.out.println(Thread.currentThread().getName()+"consumer");
            if (isProduct){
                i--;
                isProduct = false ;
                System.out.println("c->" + i);
                LOCK.notify();
            }else{
                try {
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName()+"wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main (String[] args){
        ProduceConsumerTest produceConsumerTest = new ProduceConsumerTest();
        for( int j=1 ; j<=5 ; j++) {
            new Thread() {
                public void run() {
                        produceConsumerTest.produce();
                }
            }.start();
        }
        for( int j=1 ; j<=5 ; j++) {
            new Thread() {
                public void run() {
                        produceConsumerTest.consumer();
                }
            }.start();
        }
    }
}
