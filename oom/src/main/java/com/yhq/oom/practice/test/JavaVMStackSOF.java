package com.yhq.oom.practice.test;

/**
 * project:garden
 * package:com.yhq.oom.practice.test
 * auth: Peter
 * date: 26/02/2017
 */


/**
 * VM args -Xss160k
 */

public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeap(){

        stackLength++;
        stackLeap();

    }

    public static  void main(String args[]) throws  Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try{

            oom.stackLeap();

        }catch (Exception e){
            System.out.println("oom length:"+oom.stackLength);
            throw e;
        }
    }
}
