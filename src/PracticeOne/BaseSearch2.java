package PracticeOne;

import java.util.ArrayList;
import java.util.Arrays;

public class BaseSearch2 {
    public static void main(String[] args) {
        int[] arr = {14, 22, 36, 47, 59, 62, 74, 87, 91, 105, 22};

        ArrayList<Integer> list = new ArrayList<>();

        list = getIndex(arr, 22);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static ArrayList getIndex(int[] arr, int num){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num){
                list.add(i);
            }
        }

        return list;
    }
}
