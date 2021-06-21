package com.jack.a04_algorithm.a03_quick_sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;

/**
 * @创建者 Jack
 * @创建时间 2021/5/19 14:35
 * @描述
 */
public class QucikSortClient {

    public static void main(String[] arg){
        int[] array = new int[]{1,3,5,6,2,4,8,9,7,10};
//        qucikSort(array,0,array.length - 1);
        qucikSort1(array,0,array.length - 1);
        System.out.println("排序后的数据 " + Arrays.toString(array));
//        romanToInt("CDI");
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
//        int pivotIndex = partition1(array,startIndex,endIndex);
//        int pivotIndex = partition2(array,startIndex,endIndex);
        int pivotIndex = partition3(array,startIndex,endIndex);

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


    //复习：练习快排的双边循环法，基准元素默认选择第一个
    private static int partition2(int[] array, int startIndex, int endIndex){
        //基准元素
        int pivot = array[startIndex];

        int left = startIndex;
        int right = endIndex;

        while(left != right){       //这里的条件是 !=

            while(left < right && array[right] > pivot){
                right--;
            }

            while(left < right && array[left] < pivot){
                left++;
            }

            if(left < right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        //pivot和指针重合点进行交换
        array[startIndex] = array[left];    //或 array[startIndex] = array[right];
        array[left] = pivot;
        return left;
    }

    //复习：单边循环法
    private static int partition3(int[] array, int startIndex, int endIndex){
        //关键点 基准元素和mark
        int pivot = array[startIndex];
        int mark = startIndex;

        //for循环
        for (int i = startIndex + 1; i <= endIndex; i++) {       // i <= endIndex
            if(array[i] < pivot){           //改层控制条件很重要
                mark++;
                int p = array[mark];
                array[mark] = array[i];
                array[i] = p;
            }
        }

        //交换mark位置元素和pivot
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    //复习：快排的非递归实现
    private static void qucikSort1(int[] array,int startIndex,int endIndex){

        //定义集合栈 来 代替 递归栈
        Stack<Map<String,Integer>> stack = new Stack<>();

        //存储下标
        Map<String,Integer> map = new HashMap<>();
        map.put("startIndex",startIndex);
        map.put("endIndex",endIndex);

        stack.push(map);

        //开始循环
        //循环结束条件
        while(!stack.isEmpty()){
            //栈顶元素出栈
            Map<String,Integer> indexParams = stack.pop();

            //获取startIndex和endIndex
            int startParam = indexParams.get("startIndex");
            int endParam = indexParams.get("endIndex");

            //得到基准元素
            int pivot = partition3(array,startParam,endParam);

            if(startParam < pivot - 1){
                Map<String,Integer> map1 = new HashMap<>();
                map1.put("startIndex",startIndex);
                map1.put("endIndex",pivot - 1);
                stack.push(map1);
            }

            if(endParam > pivot + 1){
                Map<String,Integer> map2 = new HashMap<>();
                map2.put("startIndex",pivot + 1);
                map2.put("endIndex",endParam);
                stack.push(map2);
            }

        }

    }

}
