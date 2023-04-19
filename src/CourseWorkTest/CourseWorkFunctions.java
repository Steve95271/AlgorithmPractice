package CourseWorkTest;

import java.util.Arrays;

public class CourseWorkFunctions {

    public static void main(String[] args) {
/*        int number = fun2(20);

        System.out.println(number);

        int [] arr = fun1(15);

        System.out.println(Arrays.toString(arr));*/

        int[][] arr = new int[4][5];

        int k = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = k;
                k++;
            }
        }

        System.out.println();
    }
    static int fun2(int n)
    {
        if(n <= 15)
            return 5;
        int number = fun2(n-1) * (1 - n/2);
        return number;
    }

    static int[] fun1(int n)
    {
        if(n == 0)
            return new int[2];
        int[] bla = fun1(n-1);
        bla[0] += 1 + bla[1];
        bla[1] *= 3;
        return bla;
    }

    static void fun3(int[][] arr)
    {
        final int n = arr.length;
        if(n == 0 || arr[0].length != n)
            return;
        for(int k = 0; k < n; ++k)
        {
            if(k%2 == 0)
                for(int j = n; j > 0; --j)
                    arr[k][j] = arr[j][k];
            else
                for(int j = 0; j < Math.sqrt(n); ++j)
                    arr[j*j][k] = arr[k-1][j];
        }
    }
}
