package Algorithms.BinarySearch;

public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr = {22, 31, 55, 55, 55, 57, 57, 57, 57, 57, 62, 69, 71, 74, 81, 95};

        //int result = BinarySearch1.binarySearch1(arr, 57);

        //int result2 = BinarySearch2.binarySearch(arr, 57);

//        int result3 = BinarySearch1.binarySearchLeftMost(arr, 57);
//
//        int result4 = BinarySearch1.binarySearchRightMost(arr, 57);

        //System.out.println(result);

        //System.out.println(result2);

//        System.out.println(result3);
//
//        System.out.println(result4);

        System.out.println(BinarySearch03.leftMostInsertPoint(arr, 57));


    }
}
