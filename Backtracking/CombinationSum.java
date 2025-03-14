package Backtracking;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println("CombinationSum");
        SolutionCombinationSum solutionN = new SolutionCombinationSum();
        System.out.println(solutionN.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}

class SolutionCombinationSum {
    List<List<Integer>> res ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(candidates, target, cur,0);
        return res;
    }

    private void backtrack(int[] nums, int target, List<Integer> cur, int i){
        if(target == 0){
            res.add(new ArrayList(cur));
            return;
        }
        if(target<0  || i>=nums.length){
            return ;
        }

        cur.add(nums[i]);
        backtrack(nums, target - nums[i], cur,i);
        cur.remove(cur.size()-1);
        backtrack(nums,target,cur,i+1);
    }
}