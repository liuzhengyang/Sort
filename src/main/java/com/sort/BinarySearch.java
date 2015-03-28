package com.sort;

import java.util.Arrays;

/**
 * Created by liuzhengyang on 2015/3/28.
 */
public class BinarySearch {

    /**
     * Assert the array to be checked is sorted in an ascending order
     * Binary search return -1 if not found, or the index founded
     * without exception checked
     * @param array
     * @param key
     * @return
     */
    public static int search(int[] array, int key){
        int start = 0;
        int end = array.length - 1;
        int middle;

        while(start <= end){
            middle = start + (end - start)/2;
            if(array[middle] == key){
                return middle;
            }
            else if(array[middle] < key){
                start = middle + 1;
            }else{
                end = middle - 1;
            }
        }
        return array[start] == key ? start : -1;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        System.out.println(Arrays.binarySearch(array, 5));
        System.out.println(search(array, 5));
    }
}
