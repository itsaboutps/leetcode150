package StacksQ;

// import java.util.Arrays;
import java.util.*;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(myApproach(temperatures)));
        System.out.println(Arrays.toString(usingStack(temperatures)));

    }

    private static Integer[] usingStack(int[] temperatures) {

        Integer[] res = new Integer[temperatures.length];
        java.util.Stack<Integer[]> stack = new java.util.Stack<>(); 


        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                Integer[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new Integer[]{t, i});
        }
        return res;
    }

    // n^2
    private static int[] myApproach(int[] temperatures) {
        int len = temperatures.length;

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;

    }
}
