package PracticeOne;

public class BaseSearch {
    public static void main(String[] args) {
        int[] arr = {14, 22, 36, 47, 59, 62, 74, 87, 91, 105};

        int index;

        index = getIndex(arr, 47);

        System.out.println(index);
    }

    private static int getIndex(int[] arr, int num){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num){
                return i;
            }
        }

        return -1;
    }
}
