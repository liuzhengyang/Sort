package com.sort;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
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
    public void testShellSort() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
//        testSort(ShellSort.class);
//        testSort(SelectSort.class);
        testSort(QuickSort.class);


        String path = ArrayUtil.class.getResource("/com/sort/ArrayUtil.class").getPath();
        String classPrefix = "com.sort.";
        System.out.println(path);
        File file = new File(path).getParentFile();
        System.out.println(file.exists());
        System.out.println(Arrays.toString(file.list((dir, name) ->name.endsWith("Sort.class"))));
        System.out.println(Arrays.toString(file.list()));
        System.out.println(file.exists());
        for(File f : file.listFiles((dir, name) -> name.endsWith("Sort.class"))){
            Class<?> clazz = Class.forName(classPrefix+f.getName().replace(".class", ""));
            testSort(clazz);
        }
    }

    class TestClassLoader extends URLClassLoader{

        public TestClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }

        public Class<?> defineClassByByteArray(String clazzName, byte[] bytes){
            return this.defineClass(clazzName, bytes, 0, bytes.length);
        }

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return super.loadClass(name);
        }
    }

    private static void testSort(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        int[] arr = ArrayUtil.generateRandomNumberArray();
        int[] arr2 = Arrays.copyOf(arr,arr.length);
        Method sortMethod = clazz.getMethod("sort", int[].class);
        Object obj = clazz.newInstance();
        sortMethod.invoke(obj, arr);
        Arrays.sort(arr2);
        System.out.println(clazz.getName() + " " + join(arr, ","));
        System.out.println("Arrays.sort " + join(arr2, ","));
        Assert.assertArrayEquals(arr, arr2);


    }


    @Test
    public void testStrategy(){
        int[] array = new int[]{3,1,2,6,8,9,3};
        ArrayUtil.sort(array, QuickSort::sort);
        System.out.println(Arrays.toString(array));
    }
}
