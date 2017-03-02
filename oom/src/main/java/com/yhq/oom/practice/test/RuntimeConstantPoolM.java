package com.yhq.oom.practice.test;

import java.util.ArrayList;
import java.util.List;

/**
 * project:garden
 * package:com.yhq.oom.practice.test
 * auth: Peter
 * date: 26/02/2017
 * email:304187514@qq.com
 */

/**
 * VM args -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolM {

    public static void  main(String args[]){
        List<String> list = new ArrayList<>();


        int  i = 0;
        while(true){
        //10MB的PermSize在Integer范围内足够产生OOM
            list.add(String.valueOf(i++).intern());
        }
    }
}
