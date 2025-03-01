package BinarySearch;

public class SearchRotated {
    public static void main(String[] args) {
        //! BinarySearch\FindMinInRotated.java [Please refer to this problem before this. Almost same approach]
        
        System.out.println("search-in-rotated-sorted-array");
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        System.out.println(myApproach(nums, target));
    }

    private static int myApproach(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            // if the array is not sorted
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // now i want to know if this mid value is part of left sorted portion or right
            // sorted portion

            // it means Mid is the part of left sorted portion
            if (nums[l] <= nums[mid]) {
                if ((target > nums[mid]) || target<nums[l]) {
                    l = mid + 1;
                } else{
                    r =  mid -1;
                }
            } else {
                if(target<nums[mid] || (target > nums[r])){
                    r = mid-1;
                } else{
                     l =mid+1;
                }
            }

        }
        return -1;
        // TODO Auto-generated method stub
    }
}
