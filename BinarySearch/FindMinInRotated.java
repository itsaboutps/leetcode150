package BinarySearch;

import java.util.Arrays;

public class FindMinInRotated {
    public static void main(String[] args) {
        System.out.println("Find-minimum-in-rotated-sorted-array :: ");
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(myApproach1(nums));
        System.out.println(myApproach2(nums));
        System.out.println(optimsedApproach(nums));

    }

    private static int myApproach2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {

            } else if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
        // return Arrays.stream(nums).min().getAsInt(); throw new
        // UnsupportedOperationException("Unimplemented method 'myApproach2'");
    }

    private static int myApproach1(int[] nums) {

        int minimum = Arrays.stream(nums).min().getAsInt();
        // System.out.println(minimum);
        return minimum;
    }

    // * here we will try to find the pivot */
    private static int optimsedApproach(int[] nums) {
        int result = nums[0];
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] < nums[r]) {
                // case of already sorted array
                result = Math.min(result, nums[l]);
                break;
            }

            // if the array is not sorted
            int mid = l + (r - l) / 2;
            result = Math.min(nums[mid], result);

            // now i want to know if this value is part of left sorted portion or right
            // sorted portion

            // it means Mid is the part of left sorted portion
            if (nums[mid] >= nums[l]) {
                // than it means in this case we will search right sorted portion
                l = mid + 1;

            } else {
                // it means Mid is the part of rigth sorted portion
                // than it means in this case we will search left sorted portion
                r = mid - 1;

            }

        }
        return result;
    }
}
