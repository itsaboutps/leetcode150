package DP;

public class ClimbingStarts {
    public static void main(String[] args) {
        System.out.println();

        ClimbingStartsSolution solution = new ClimbingStartsSolution();
        System.out.println(solution.climbStairs(5));

        ClimbingStartsSolutionUsingMemoization solution2 = new ClimbingStartsSolutionUsingMemoization();
        System.out.println(solution2.climbStairs(5));

        SolutionUsingDynamicProgramming solution3 = new SolutionUsingDynamicProgramming();
        System.out.println(solution3.climbStairs(5));

    }
}


// time complexity: O(n)
// space complexity: O(n)
class ClimbingStartsSolutionUsingMemoization {
    int n;
    int[] memo;

    public int climbStairs(int n) {
        this.n = n;
        this.memo = new int[n + 1];
        // think of the base case first
        return dfs(0);
    }

    private int dfs(int i) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1; // Reached the top, count as 1 way
        }
        if (memo[i] != 0) { // Check if already computed
            return memo[i];
        }
        // Compute and store in memo
        memo[i] = dfs(i + 1) + dfs(i + 2);
        return memo[i]; // Return computed result
    }
}



//normal recursion
// Time complexity: O(2^n)
class ClimbingStartsSolution {
    int n;
    int ans;

    public int climbStairs(int n) {
        this.n = n;
        // think of the base case first
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i > n) {
            return;
        }
        if (i == n) {
            ans++;
            return;
        }
        dfs(i + 1);
        dfs(i + 2);
    }
}


// Time complexity: O(n)
// Space complexity: O(1)
class SolutionUsingDynamicProgramming {
    public int climbStairs(int n) {
        int one = 1;
        int two = 1;

        for(int i =0;i<n-1;i++){
            int temp = one;
            one = one+two;
            two = temp;
        }

        return one ;
        
    }
}