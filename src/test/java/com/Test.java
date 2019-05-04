package com;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * desc:
 *
 * @author zhoulk
 *         Date:  2018/7/24.
 */
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int line = input.nextInt();

    }

    public static void getNum(){
        int b=0,s=0,g=0,num=0;
        for (int i=100;i<=999;i++){
             b = i/100;
             s = (i-b*100)/10;
             g=i-b*100-s*10;
             num = (int)(Math.pow(b,3)+Math.pow(s,3)+Math.pow(g,3));
             if(num==i){
                 System.out.println(i);
             }
        }
    }

    public static void listAll(List list,String prefix){
        String[] array = new String[]{
                "1","2","3","4"
        };
        listAll(Arrays.asList(array),"");
        System.out.println(prefix);

        list.forEach((list1)-> System.out.println("list = [" + list + "], prefix = [" + prefix + "]"));

    }
}
