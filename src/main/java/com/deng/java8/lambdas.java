package com.deng.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dengyunqing on 2019/3/15.
 */
public class lambdas {

    public static void main(String[] args){
        //排序
        /*String[] a ={"abc","abd","aav"};
        Arrays.sort(a,new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        List<String> alist = Arrays.asList(a);
        alist.forEach((String aa) -> System.out.println(aa));
        alist.forEach(System.out::println);*/
        //线程
        /*new Thread(() -> System.out.print("我是用lambdas创建的线程")).start();*/
        List<Apple> list = new ArrayList<Apple>(){
            {
                add(new Apple("green",12));
                add(new Apple("blue",10));
                add(new Apple("yellow",2));
                add(new Apple("red",23));
                add(new Apple("block",2));
            }
        };
        list.forEach((a) ->System.out.printf(a.getColor(),a.getWeight()));
    }

}
