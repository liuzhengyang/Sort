package com.sort;

import java.util.Random;

/**
 * 数组工具类
 * Created by liuzhengyang on 2015/3/27.
 */
public class ArrayUtil {

    private static final Random random = new Random();

    public static <T> void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T> void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.println(i);
        }
    }


    public static int[] generateRandomNumberArray(){
//        int randomNumber = 10 + random.nextInt(100);
        int randomNumber = 10;
        int[] arr = new int[randomNumber];
        for(int i = 0; i < randomNumber; i++){
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static String join(int[] arr, String splitor){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length - 1; i++){
            sb.append(arr[i]).append(splitor);
        }
        sb.append(arr[arr.length - 1]);
        return sb.toString();
    }
}
