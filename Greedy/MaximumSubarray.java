package Greedy;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println();

        MaximumSubarraySolution solution = new MaximumSubarraySolution();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}


class MaximumSubarraySolution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxHere = 0;
        for(int i =0;i< nums.length;i++){
            
            maxHere += nums[i];
            if(maxHere>max){
                max= maxHere;
            }
            if(maxHere<0){
                maxHere=0;
            }

        }
        return max;
        
    }
}