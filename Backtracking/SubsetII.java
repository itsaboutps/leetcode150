package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static void main(String[] args) {
        System.out.println("SubsetII");
        int[] nums = { 1, 2, 2 };
        SubsetIISolution backtracking = new SubsetIISolution();
        System.out.println(backtracking.subsetsWithDup(nums));
    }
}

class SubsetIISolution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);

        dfs(0);
        return ans;
    }

    private void dfs(int i) {

        //!base case for recursion
        if (i == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }

        t.add(nums[i]);
        dfs(i + 1);
        t.remove(t.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(i + 1);

    }
}
