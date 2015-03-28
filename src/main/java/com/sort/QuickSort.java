package com.sort;

/**
 * QuickSort, Simple Version
 * TODO sort with multithreading
 * Created by liuzhengyang on 2015/3/28.
 */
public class QuickSort {

    public static void sort(int[] array, int start, int end){
        if(start == end){
            return;
        }
        int i = start,j = end;
        int pivot = array[start];
        while(i < j){
            while(i < j){
                if(array[j] < pivot){
                    array[i] = array[j];
                    i++;
                    break;
                }
                j--;
            }
            while(i < j){
                if(array[i] > pivot){
                    array[j] = array[i];
                    j--;
                    break;
                }
                i++;
            }
        }
        array[i] = pivot;
        if(start < i){
            sort(array, start, i -1);
        }
        if(i < end){
            sort(array, i+1 , end);
        }
    }


    public static void sort(int[] array){
        sort(array, 0, array.length - 1);
    }
}
