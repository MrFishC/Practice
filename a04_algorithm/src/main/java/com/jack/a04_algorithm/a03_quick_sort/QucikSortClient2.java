package com.jack.a04_algorithm.a03_quick_sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @创建者 Jack
 * @创建时间 2021/5/19 14:35
 * @描述 非递归调用
 *
 * 栈实现，固定的套路。
 *
 * 选择基准元素的方法采用 单边循环法。
 */
public class QucikSortClient2 {

    public static void main(String[] arg){
        int[] array = new int[]{1,3,5,6,2,4,8,9,10};
        qucikSort(array,0,array.length - 1);
        System.out.println("排序后的数据 " + Arrays.toString(array));
    }


    private static void qucikSort(int[] array,int startIndex,int endIndex) {
        String START_INDEX = "startIndex";
        String END_INDEX = "endIndex";
        //使用栈来代替 递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();

        Map<String, Integer> paramsMap = new HashMap<>();
        paramsMap.put(START_INDEX,startIndex);
        paramsMap.put(END_INDEX,endIndex);

        quickSortStack.push(paramsMap);


        while (!quickSortStack.isEmpty()){
            Map<String, Integer> topMap = quickSortStack.pop();

            //选择基准元素
            int pivot = partition(array,topMap.get(START_INDEX),topMap.get(END_INDEX));

            if(topMap.get(START_INDEX) < pivot - 1){
                Map<String, Integer> leftParams = new HashMap<>();
                leftParams.put(START_INDEX,topMap.get(START_INDEX));
                leftParams.put(END_INDEX,pivot - 1);
                quickSortStack.push(leftParams);
            }

            if(pivot + 1 < topMap.get(END_INDEX)) {
                Map<String, Integer> rightParams = new HashMap<>();
                rightParams.put(START_INDEX,pivot + 1);
                rightParams.put(END_INDEX,topMap.get(END_INDEX));
                quickSortStack.push(rightParams);
            }
        }

    }

    private static int partition(int[] array, int startIndex, int endIndex) {
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
