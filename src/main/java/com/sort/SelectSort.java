package com.sort;

import static com.sort.ArrayUtil.swap;

/**
 * 简单选择排序
 * 依次选择最小的放在最前面
 * Created by liuzhengyang on 2015/3/28.
 */
public class SelectSort {

    public static void sort(int[] array){
        for(int i = 0 ; i< array.length; i++){
            int pos = i;
            int min = array[i];
            for(int j = i; j<array.length; j++){
                if(array[j] < min){
                    pos = j;
                    min = array[j];
                }
            }
            swap(array, i, pos);
        }
    }
}
