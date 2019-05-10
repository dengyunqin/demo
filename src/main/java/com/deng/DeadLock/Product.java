package com.deng.DeadLock;

/**
 * Created by dengyunqing on 2019/1/21.
 */
public class Product {

    private Order order;

    public void setProduct (Order order) {
        this.order = order;
    }

    private final Object lock = new Object();

    public void p1 () {
        synchronized (lock) {
            System.out.println("p1");
        }
    }

    public void p2 () {
        synchronized (lock) {
            System.out.println("p2");
            order.o2();
        }
    }
}
