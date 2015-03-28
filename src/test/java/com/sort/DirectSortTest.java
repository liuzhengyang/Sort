package com.sort;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import static com.sort.ArrayUtil.join;

/**
 * Created by liuzhengyang on 2015/3/27.
 */
public class DirectSortTest {

    @Test
    public void testDirectSort(){
        int[] arr = ArrayUtil.generateRandomNumberArray();
        int[] arr2 = Arrays.copyOf(arr,arr.length);
        DirectSort.sort(arr);
        Arrays.sort(arr2);
        Assert.assertArrayEquals(arr, arr2);
        ArrayUtil.printArray(arr);
    }


    @Test
    public void testShellSort() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        testSort(ShellSort.class);
//        testSort(SelectSort.class);
        testSort(QuickSort.class);
    }

    private static void testSort(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        int[] arr = ArrayUtil.generateRandomNumberArray();
        int[] arr2 = Arrays.copyOf(arr,arr.length);
        Method sortMethod = clazz.getMethod("sort", int[].class);
        Object obj = clazz.newInstance();
        sortMethod.invoke(obj, arr);
        Arrays.sort(arr2);
        System.out.println("MySort " + join(arr, ","));
        System.out.println("Arrays.sort " + join(arr2, ","));
        Assert.assertArrayEquals(arr, arr2);
    }
}
