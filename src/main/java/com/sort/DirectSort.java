package com.sort;

import java.util.Comparator;

import static com.sort.ArrayUtil.*;

/**
 * 直接插入排序
 * Created by liuzhengyang on 2015/3/27.
 */
public class DirectSort{

    public <T> void sort(T[] array){

    }

    public <T> void sort(T[] array, Comparator<T> comparator){

    }

    public static void sort(int[] array){
        for(int i = 1; i < array.length; i++){
            int temp = array[i];
            int j ;
            for(j = i - 1; j >=0 && array[j] > temp; j--){
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }
    }
}
