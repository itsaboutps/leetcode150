package BinarySearch;

import java.util.Arrays;



public class MedianTwoSorted {
    public static void main(String[] args) {
        System.out.println("MedianTwoSorted");
        int[] nums1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] nums2 = { 1, 2, 3, 4, 5 };

        // System.out.println(bruteForce(nums1, nums2));

        // * https://www.youtube.com/watch?v=yD7wV8SyPrc
        // BinarySearch\mediantwosorted.png
        // LEETCODE HARD
        // https://leetcode.com/problems/merge-sorted-array/

        System.out.println(optimsedApproach(nums1, nums2));


    }

    private static double optimsedApproach(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return optimsedApproach(nums2, nums1);
        }

        
        int x = nums1.length;
        int y = nums2.length;
        // int total = len1+len2;
        // int half = total+1/2;

        int low = 0;
        int high = x;

        while(low<=high){

            int partionX = (low+high)/2;
            int partionY = ((x+y+1)/2) - partionX;

            // use the partioning condition and calculate l1,l2,l3,l4

            int maxLeftX = (partionX==0) ? Integer.MIN_VALUE : nums1[partionX-1];
            int minRightX = (partionX==x) ? Integer.MAX_VALUE : nums1[partionX];

            int maxLeftY = (partionY==0) ? Integer.MIN_VALUE : nums2[partionY-1];
            int minRightY = (partionY==y) ? Integer.MAX_VALUE : nums2[partionY];


            if((maxLeftX <= minRightY) && (maxLeftY<=minRightX) ){
                return ((x+y)%2 == 0) ? 
                (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0 : 
                Math.max(maxLeftX,maxLeftY);
            } else if(maxLeftX > minRightY){
                high = partionX-1;
            } else {
                low = partionX+1;
            }

        }

        throw new IllegalArgumentException("Input arrays");
    }

    private static double bruteForce(int[] nums1, int[] nums2) {
        // [1,3,5] => Median =3
        // [1,3,5,7] => Median = (3+5)/2 = 4.0

        // now we need to find the median of two sorted
        int[] merged = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, merged, 0, nums1.length);

        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);

        Arrays.sort(merged);

        int n = merged.length;

        if (n % 2 == 1) {
            return merged[n / 2];
        } else {
            return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
        }

    }

}
