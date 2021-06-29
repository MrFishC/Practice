package com.jack.a04_algorithm.a05example;

import java.util.Arrays;

/**
 * @创建者 Jack
 * @创建时间 2021/6/29 11:48
 * @描述 最大公约数
 */
public class Example01 {
    public static void main(String[] arg){
        System.out.println("function01 = " + function01(20,9));
        System.out.println("function02 = " + function02(20,9));
        System.out.println("function03 = " + function02(20,9));
    }

    /**
     * 碾转相除法
     */
    public static int function01(int a,int b){
        int big = Math.max(a,b);
        int small = Math.min(a,b);

        if(big % small == 0){
            return small;
        }

        return function01(big % small,small);
    }

    /**
     * 更相减损术
     */
    public static int function02(int a,int b){
        if(a == b){
            return a;
        }

        int max = Math.max(a,b);
        int min = Math.min(a,b);

        return function02(max - min,min);
    }

    /**
     * 更相减损术 结合 位运算
     */
    public static int function03(int a,int b){
        if(a == b){
            return a;
        }

        if((a&1) == 0 && (b&1) == 0){
            return function03(a >> 1,b >> 1) << 1;
        }else if((a&1) == 0 && (b&1) != 0){
            return function03(a >> 1,b);
        }else if((a&1) != 0 && (b&1) == 0){
            return function03(a,b >> 1);
        }else{
            int max = Math.max(a,b);
            int min = Math.min(a,b);
            return function03(max - min,min);
        }
    }
}
