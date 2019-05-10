package com.deng;

/**
 * Created by dengyunqing on 2019/1/14.
 */
public class CallNumber extends Thread {
    private static int max = 1000;

    private String name;
    private  int index = 1;

    public void run () {
        while (index <= max) {
            System.out.println("柜台" + name + "当前的号码是" + index++);
        }
    }

    public CallNumber (String name) {
        this.name = name ;
    }


}
