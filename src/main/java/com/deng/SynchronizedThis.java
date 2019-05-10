package com.deng;

/**
 * Created by dengyunqing on 2019/1/18.
 */
public class SynchronizedThis {
    public static void main(String[] args){
        TestSynchronized testSynchronized = new TestSynchronized();
        new Thread (){
            public void run () {
                testSynchronized.m1();
            }
        }.start();
        new Thread (){
            public void run () {
                testSynchronized.m2();
            }
        }.start();
    }



}
class TestSynchronized {

    public void m1 (){
        synchronized("1"){
            try {
                System.out.println("m1");
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void m2 () {
        synchronized ("1") {
            try {
                System.out.println("m2");
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}