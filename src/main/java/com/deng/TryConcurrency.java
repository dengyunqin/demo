package com.deng;

/**
 * Created by dengyunqing on 2019/1/11.
 */
public class TryConcurrency {
    public static void main(String[] args){
        new Thread(){
            @Override
            public void run(){
                for(int i=1;i<100;i++){
                    System.out.println("i="+i);
                }
            }
        }.start();

        for(int j=1;j<100;j++){
            System.out.println("j="+j);
        }
    }

}
