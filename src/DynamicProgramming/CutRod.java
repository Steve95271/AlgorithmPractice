package DynamicProgramming;

public class CutRod {
    public static void main(String[] args) {
        int[] price = {1,5,8,9,10,17,17,20,24,30
                        ,34,36,37,38,39,40,41,42,34,36,37,38,39,40,41,42,34,36,37,38,39,40,41,42};

        int result = cutRod(price, 13);

        System.out.println(result);
    }

    public static int cutRod(int[] p, int n){
        if (n == 0){
            return 0;
        }

        int q = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            q = p[i] + cutRod(p, n-1);
        }

        return q;
    }
}
