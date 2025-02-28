package BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Binary Search :: ");
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        // System.out.println(binarySearch(nums, target));
        // System.out.println(buildInFunction(nums, target));
        System.out.println(myApproach(nums, target));

    }
    // binarSearch

    private static int myApproach(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            //here you can do (l+r/2)
            // so here 
            int mid = l + ((r - l) / 2);
            if(target>nums[mid]){
                l = mid+1;

            }else if(target<nums[mid]){
                r = mid-1;
            } else if(nums[mid] == target){
                return mid;
            }
        }
        return -1;

        // TODO Auto-generated method stub
    }

    private static int buildInFunction(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -1;
        // TODO Auto-generated method stub
    }

    private static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
