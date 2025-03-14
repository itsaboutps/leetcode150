package Backtracking;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println("CombinationSum");
        SolutionN solution = new SolutionN();
        System.out.println(solution.combinationSum2(new int[]{2, 3, 6, 7}, 7));
    }
}


class SolutionN {
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, Integer> count = new HashMap<>();
    
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<Integer> cur = new ArrayList<>();
        List<Integer> A = new ArrayList<>();
        
        for (int num : nums) {
            if (!count.containsKey(num)) {
                A.add(num);
            }
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        backtrack(A, target, cur, 0);
        return res;
    }

    private void backtrack(List<Integer> nums, int target, List<Integer> cur, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || i >= nums.size()) {
            return;
        }

        if (count.get(nums.get(i)) > 0) {
            cur.add(nums.get(i));
            count.put(nums.get(i), count.get(nums.get(i)) - 1);
            backtrack(nums, target - nums.get(i), cur, i);
            count.put(nums.get(i), count.get(nums.get(i)) + 1);
            cur.remove(cur.size() - 1);
        }

        backtrack(nums, target, cur, i + 1);
    }
}