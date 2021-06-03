package com.jack.a04_algorithm.a03_quick_sort;

import java.util.Arrays;

/**
 * @创建者 Jack
 * @创建时间 2021/5/19 14:35
 * @描述
 */
public class QucikSortClient {

    public static void main(String[] arg){
//        int[] array = new int[]{1,3,5,6,2,4,8,9,10};
//        qucikSort(array,0,array.length - 1);
//        System.out.println("排序后的数据 " + Arrays.toString(array));
        romanToInt("CDI");
    }

    public static int romanToInt(String s) {
        if(s.length() == 0){
            return 0;
        }

        //CDI
        int pre = getValue(s.charAt(0));
        int result = 0;
        for(int i = 1;i < s.length();i++){
            int num = getValue(s.charAt(i));
            System.out.println(" i = " + i + ", num = " + num);
            if(pre < num){
                result -= pre;
                System.out.println(" - result = " + result);
            }else{
                result += pre;
                System.out.println(" + pre = " + pre);
                System.out.println(" + result = " + result);
            }
            pre = num;
            System.out.println("  pre = " + pre);
        }

        result += pre;
        System.out.println("  result = " + result);

        return result;
    }

    private static int getValue(char c){
        int i = 0;
        switch(c){
            case 'I':
                i = 1;
                break;
            case 'V':
                i = 5;
                break;
            case 'X':
                i = 10;
                break;
            case 'L':
                i = 50;
                break;
            case 'C':
                i = 100;
                break;
            case 'D':
                i = 500;
                break;
            case 'M':
                i = 1000;
                break;
        }
        return i;
    }

    private static void qucikSort(int[] array,int startIndex,int endIndex) {
        if(startIndex >= endIndex){
            return;
        }

//        int pivotIndex = partition(array,startIndex,endIndex);
        int pivotIndex = partition1(array,startIndex,endIndex);

        qucikSort(array,startIndex,pivotIndex - 1);
        qucikSort(array,pivotIndex + 1,endIndex);
    }

    //双边循环法，递归实现。 分治
    private static int partition(int[] array, int startIndex, int endIndex) {
        //选定基准元素 并设置两个指针
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right){      //控制循环

            //循环内部的逻辑（每一轮）

            //从右指针开始
            while (left < right && array[right] > pivot){
                right--;
            }

            //到了左指针
            while (left < right && array[left] <= pivot){
                left++;
            }

            //交换left和right指针的元素交换
            if(left < right){
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }

        //最终left和right和重合
        //将基准元素和重合的元素交换
        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }

    //单边循环法，递归实现。
    private static int partition1(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int mark = startIndex;

        for(int i = startIndex + 1;i <= endIndex;i++){
            if(array[i] < pivot){
                mark++;
                int temp = array[i];
                array[i] = array[mark];
                array[mark] = temp;
            }
        }

        //交换mark所在位置和pivot的值
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

}
