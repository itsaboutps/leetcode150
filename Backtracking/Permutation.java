//package Backtracking;//package Backtracking;

 package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        System.out.println("Permutation");
//        Solutions solution = new Solutions();
        System.out.println(permute(new int[]{1, 2, 3}));
    }
    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }

        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> p : perms) {
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> p_copy = new ArrayList<>(p);
                p_copy.add(i, nums[0]);
                res.add(p_copy);
            }
        }
        return res;
    }


}

// class Solutions {

//}

// class Solution {
//     List<List<Integer>> res;
//     public List<List<Integer>> permute(int[] nums) {
//         res = new ArrayList<>();
//         backtrack(nums, 0);
//         return res;
//     }

//     public void backtrack(int[] nums, int idx) {
//         if (idx == nums.length) {
//             List<Integer> perm = new ArrayList<>();
//             for (int num : nums) perm.add(num);
//             res.add(perm);
//             return;
//         }
//         for (int i = idx; i < nums.length; i++) {
//             swap(nums, idx, i);
//             backtrack(nums, idx + 1);
//             swap(nums, idx, i);
//         }
//     }

//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }