package Recursion;

import java.util.Arrays;
import java.util.Random;

public class RecursionInsertSort {

    public static void main(String[] args) {
        Random rnd = new Random();

        int[] arr = new int[7];

        for (int i = 0; i < arr.length; i++) {
            int randomNum = rnd.nextInt(100);

            arr[i] = randomNum;
        }

        System.out.println(Arrays.toString(arr));

        insertSort(arr, 1);

        System.out.println(Arrays.toString(arr));
    }


    /**
     * 递归版本插入排序
     * @param arr 需要排序的数组
     * @param startPoint 开始的地方
     */
    public static void insertSort(int[] arr, int startPoint){
        if (startPoint == arr.length){
            return;
        }

        int key = arr[startPoint];
        int i = startPoint - 1; //已排序区域的指针。指针的左边已排序。

        while(i >= 0 && arr[i] > key){
            arr[i+1] = arr[i]; //往后移，空出插入位置
            i--;
        }

        //Insert position
        arr[i + 1] = key;

        insertSort(arr, startPoint + 1);
    }

}
