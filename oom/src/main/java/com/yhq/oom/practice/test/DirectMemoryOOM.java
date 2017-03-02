package com.yhq.oom.practice.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * project:garden
 * package:com.yhq.oom.practice.test
 * auth: Peter
 * date: 27/02/2017
 * email:304187514@qq.com
 */

/**
 * VM args -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {

    private static final  int _1MB = 1024*1024;

    public static void main(String args[]) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
