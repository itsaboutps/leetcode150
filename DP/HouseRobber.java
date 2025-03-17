package DP;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println("House Robber");

        SolutionBruteForce solution = new SolutionBruteForce();
        System.out.println(solution.rob(new int[]{2,1,1,2}));

        SolutionMemoization solutionMemoization = new SolutionMemoization();
        System.out.println(solutionMemoization.rob(new int[]{2,1,1,2}));

        SolutionUsingDP1 solutionUsingDP1 = new SolutionUsingDP1();
        System.out.println(solutionUsingDP1.rob(new int[]{2,1,1,2}));

        SolutionUsingDP2 solutionUsingDP2 = new SolutionUsingDP2();
        System.out.println(solutionUsingDP2.rob(new int[]{2,1,1,2}));



    }
}

// Time complexity: O(2^N) - In the worst case, the number of recursive calls is 2^N.
// Space complexity: O(N) - The depth of the recursion tree can go up to N.
class SolutionBruteForce {
    public int rob(int[] nums) {
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        return Math.max(dfs(nums, i + 1),
                        nums[i] + dfs(nums, i + 2));
    }
}


class SolutionMemoization {
    private Integer[] memo; // Memoization table
    private int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        memo = new Integer[nums.length];

        return dfs( 0);
    }

    private int dfs( int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        // Compute and store result in memo[i]
        int skip = dfs(i + 1);
        int rob = nums[i] + dfs( i + 2);
        memo[i] = Math.max(skip, rob);

        return memo[i];
    }
}



class SolutionUsingDP1 {
    public int rob(int[] nums) {
        int rob1 =0;
        int rob2 = 0;

        for(int num : nums){
            int temp = Math.max((rob1+ num), rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}


class SolutionUsingDP2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        // dp[i] = max money from house i to the end
        int[] dp = new int[n + 2]; // +2 to handle i+2 for the last house
        
        // Base case: no houses left
        dp[n] = 0;
        dp[n + 1] = 0;
        
        // Compute from the last house backward
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        
        return dp[0];
    }
}



// For nums = [1, 1, 3, 3]:

// Initialize dp[4] = 0, dp[5] = 0.

// Compute backward:

// dp[3] = max(dp[4], 3 + dp[5}) = 3

// dp[2] = max(dp[3}, 3 + dp[4}) = 3

// dp[1] = max(dp[2}, 1 + dp[3}) = 4

// dp[0] = max(dp[1}, 1 + dp[2}) = 4





// let's try to understand how someone comes up with the recursive logic for the House Robber problem. The problem is that you can't rob adjacent houses, and you need to maximize the money you take. So, how do you approach this?

// First, maybe I should think about small examples. Let's say there's just one house. Then obviously, you rob it. If there are two houses, you pick the one with more money. But for three houses, it's either the first and third or just the second. So, the decision depends on the sum.

// Hmm, maybe recursion is a way to break down the problem. If I have n houses, the maximum I can get is either robbing the first house plus the maximum from the remaining houses starting from the third (since the second is adjacent), or skipping the first and taking the maximum from the remaining starting from the second.

// Wait, that sounds like the logic. So, for the ith house, the decision is: rob it and add its value to the result of starting from i+2, or skip it and take the result from i+1. That way, you're considering all possible non-adjacent combinations.

// But why does this cover all possibilities? Let's see. If you choose to rob house i, then the next available is i+2. If you skip i, then you can consider i+1. So, recursively, each step reduces the problem size, and the maximum of these two choices should give the overall maximum.

// But how do you ensure that all possible valid combinations are considered? Well, every time you make a choice at i, you're branching into two paths. Over all possible i's, this should cover all valid sequences where no two are adjacent. Even if you skip multiple houses in a row, the recursion would eventually reach those decisions.

// Wait, but in the recursive approach, the base case is when i exceeds the array length, returning 0. That makes sense because there are no more houses to consider. So, each recursive call either adds the current house's value and skips the next, or skips the current and moves to the next.

// I think the key here is breaking the problem into subproblems where each subproblem is the maximum amount obtainable starting from a particular house index. By solving these subproblems recursively and combining their results with the current decision (rob or skip), you can build up the solution.

// But why does this formula work? Let's take an example. Suppose nums = [1,2,3,4]. Starting at index 0:

// If you rob index 0 (1), then you can't rob 1, so you take 1 + dfs(2). dfs(2) would then consider robbing 3 (3 + dfs(4)) or skipping to dfs(3). dfs(4) is 0, so robbing 3 gives 3. Skipping to dfs(3) would be max(dfs(4), 4 + dfs(5)) = 4. So dfs(2) is max(3,4) = 4. So robbing 0 gives 1 +4=5.