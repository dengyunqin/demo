package com.deng.DeadLock;

/**
 * Created by dengyunqing on 2019/1/21.
 */
public class Order {

    private Product product;

    public Order (Product product) {
        this.product = product;
    }

    private final Object lock = new Object();

    public void o1 () {
        synchronized (lock) {
            System.out.println("o1");
            product.p1();
        }
    }

    public void o2 () {
        synchronized (lock) {
            System.out.println("o2");
        }
    }
}
