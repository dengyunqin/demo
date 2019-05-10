package com.deng;

/**
 * Created by dengyunqing on 2019/1/14.
 */
public class Bank  {

    public static void main (String[] args) {
        CallNumber callNumber = new CallNumber( "一号柜台");
        callNumber.start();
        CallNumber callNumber2 = new CallNumber( "二号柜台");
        callNumber.interrupt();
        callNumber2.start();

        System.out.println(callNumber2.toString());
    }
}
