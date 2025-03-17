package DP;

import java.util.Arrays;

public class HouseRobberII {
    public static void main(String[] args) {
        System.out.println("House Robber II");

        HouseRobberIIBruteForce solution1 = new HouseRobberIIBruteForce();
        System.out.println(solution1.rob(new int[]{2, 3, 2}));

        HouseRobberIIMemoization solution2 = new HouseRobberIIMemoization();
        System.out.println(solution2.rob(new int[]{2, 3, 2}));

        HouseRobberIIUsingDP1 solution3 = new HouseRobberIIUsingDP1();
        System.out.println(solution3.rob(new int[]{2, 3, 2}));

        HouseRobberIIUsingDP2 solution4 = new HouseRobberIIUsingDP2();
        System.out.println(solution4.rob(new int[]{2, 3, 2}));
    }


}


    // Time complexity: O(2^N) - In the worst case, the number of recursive calls is 2^N.
// Space complexity: O(N) - The depth of the recursion tree can go up to N.
class HouseRobberIIBruteForce {
    public int rob(int[] nums) {
        return Math.max(dfs(nums, 0, nums.length - 2),
                        dfs(nums, 1, nums.length - 1));
    }

    private int dfs(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        return Math.max(dfs(nums, start + 1, end),
                        nums[start] + dfs(nums, start + 2, end));
    }

    
}


// Time complexity: O(N^2) - The recursion tree has N nodes and for each node, we are calculating the result in O(N) time.
// Space complexity: O(N^2) - The depth of the recursion tree can go up to N and the memoization table has N * N cells.
class HouseRobberIIMemoization {
    private Integer[][] memo; // Memoization table
    private int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        memo = new Integer[nums.length][nums.length];

        return Math.max(dfs(0, nums.length - 2),
                        dfs(1, nums.length - 1));
    }

    private int dfs(int start, int end) {
        if (start > end) {
            return 0;
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        // Compute and store result in memo[start][end]
        int skip = dfs(start + 1, end);
        int rob = nums[start] + dfs(start + 2, end);
        memo[start][end] = Math.max(skip, rob);
        return memo[start][end];
    }
}


class HouseRobberIIUsingDP1 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)),
                        helper(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    private int helper(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[nums.length - 1];
    }
}



class HouseRobberIIUsingDP2 {
    public int rob(int[] nums) {
        return Math.max(nums[0], 
               Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)), 
               helper(Arrays.copyOfRange(nums, 0, nums.length - 1))));
    }

    private int helper(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int newRob = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    }
}

