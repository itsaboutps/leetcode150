package StacksQ;

import java.util.Arrays;

public class CarFleet {
    public static void main(String[] args) {
        System.out.println("Car Fleet :: ");
        int target = 10;
        int[] position = { 4, 1, 0, 7 };
        int[] speed = { 2, 2, 1, 1 };
        carFleet(target, position, speed);
    }

    private static int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair,(a,b)->
            Integer.compare(b[0], a[0])
        );
        java.util.Stack<Double> stack = new java.util.Stack();

        for(int[] p  : pair){
            stack.push((double)(target - p[0]) / p[1]);
            if((stack.size() >=2) && stack.peek()<=stack.get(stack.size()-2)){
                stack.pop();
            }

        }
        System.out.println(stack.size());
        return stack.size();
        // TODO Auto-generated method stub
    }
}
