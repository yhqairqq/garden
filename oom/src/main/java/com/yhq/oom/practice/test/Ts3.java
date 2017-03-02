package com.yhq.oom.practice.test;

import java.util.ArrayList;
import java.util.List;

/**
 * project:garden
 * package:com.yhq.oom.practice.test
 * auth: Peter
 * date: 26/02/2017
 */

/**
 * VM args -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */

public class Ts3 {
   public static void main(String args[]){
       List<Object> list = new ArrayList<>();

       while(true){
           list.add(new Object());
       }
   }


}
