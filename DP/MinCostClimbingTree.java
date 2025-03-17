package DP;

public class MinCostClimbingTree {
    public static void main(String[] args) {
        System.out.println("Min Cost Climbing Tree");

        MinCostClimbingTreeBruteForce solution = new MinCostClimbingTreeBruteForce();
        System.out.println(solution.minCostClimbingStairs(new int[] { 10, 15, 20 }));

        MinCostClimbingTreeMemoization solution1 = new MinCostClimbingTreeMemoization();
        System.out.println(solution1.minCostClimbingStairs(new int[] { 10, 15, 20 }));

        MinCostClimbingTreeDP2 solution2 = new MinCostClimbingTreeDP2();    
        System.out.println(solution2.minCostClimbingStairs(new int[] { 10, 15, 20 }));

        MinCostClimbingTreeDP1 solution3 = new MinCostClimbingTreeDP1();
        System.out.println(solution3.minCostClimbingStairs(new int[] { 10, 15, 20 }));

    }
}

// Time complexity: O(2^N) - In the worst case, the number of recursive calls is 2^N.
class MinCostClimbingTreeBruteForce {
    private int[] cost;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        return Math.min(dfs(0), dfs(1));

    }

    private int dfs(int i){
        if(i>=cost.length){
            return 0;
        }
        return cost[i]+Math.min(dfs( i+1), dfs(i+2));
    }
}


// Time complexity: O(N) - The size of the recursion tree can go up to N.
// Space complexity: O(N) - The depth of the recursion tree can go up to N.
class MinCostClimbingTreeMemoization {
    private int[] cost;
    private int[] memo;

    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        this.memo = new int[cost.length];

        return Math.min(dfs(0), dfs(1));

    }

    private int dfs(int i){
        if(i>=cost.length){
            return 0;
        }
        if(memo[i]!=0){
            return memo[i];
        }
        memo[i] = cost[i]+Math.min(dfs(i+1), dfs(i+2));
        return memo[i];
    }
}


// Time complexity: O(N) - As it is a linear scan.
// Space complexity: O(1) - As we are using only constant space.
class MinCostClimbingTreeDP1 {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }
}


class MinCostClimbingTreeDP2 {
    

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<n; i++){
            dp[i] = cost[i]+Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
        
    }

}