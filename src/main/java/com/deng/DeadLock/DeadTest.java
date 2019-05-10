package com.deng.DeadLock;

/**
 * Created by dengyunqing on 2019/1/21.
 */
public class DeadTest {
    public static void main (String[] args) {
        Product product = new Product();
        Order order = new Order(product);
        product.setProduct(order);
        new Thread(){
            public void run () {
                while (true)
                order.o1();
            }
        }.start();

        new Thread(){
            public void run () {
                while(true)
                product.p2();
            }
        }.start();
    }
}
