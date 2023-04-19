package StackAndQueue;

import java.util.Arrays;

public class computeSpan {
    public static void main(String[] args) {
        int[] testIn = {5,3,564,645,2,32,15,23,54,2,43,5,3};
        System.out.println("Input: " + Arrays.toString(testIn));
        ArrayStack t = new ArrayStack<>(50);
        int[] testOut = lookBackProblem(testIn, t);
        System.out.println("Output: " + Arrays.toString(testOut));


    }

    public static int[] lookBackProblem(int[] arr, ArrayStack<Integer> emptyStack){
        final ArrayStack<Integer> stack = emptyStack;
        final int n = arr.length;
        final int[] span = new int[n];
        for(int i = 0; i < n; ++i)
        {
            boolean done = false;
            while(!stack.isEmpty() && !done)
            {
                if(stack.top() <= arr[i])
                    stack.pop();
                else
                    done = true;
            }
            int h;
            if(stack.isEmpty())
                h = -1;
            else
                h = stack.top();
            span[i] = i - h;
            stack.push(i);
        }
        return span;
    }
}
