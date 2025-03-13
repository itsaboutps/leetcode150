package Sorting;

public class Sorting {

    public static void main(String[] args) {
        Sorting sorter = new Sorting();
        int[] array = { 10, 7, 8, 9, 1, 5 };

        // *************************************************************************************************
        // */
        // *************************************************************************************************
        // */
        // sorter.quickSort(array);
        sorter.selectionSort(array);
        // *************************************************************************************************
        // */
        // *************************************************************************************************
        // */

        System.out.println("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    /* Selection sort */
    void selectionSort(int[] nums) {
        int n = nums.length;
        // Outer loop: unsorted range is [i, n-1]
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: find the smallest element within the unsorted range
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[k])
                    k = j; // Record the index of the smallest element
            }
            // Swap the smallest element with the first element of the unsorted range
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    void quickSort(int[] nums, int left, int right) {
        // Terminate recursion when subarray length is 1
        if (left >= right)
            return;
        // Partition
        int pivot = partition(nums, left, right);
        // Recursively process the left subarray and right subarray
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    /* Partition */
    int partition(int[] nums, int left, int right) {
        // Use nums[left] as the pivot
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left])
                j--; // Search from right to left for the first element smaller than the pivot
            while (i < j && nums[i] <= nums[left])
                i++; // Search from left to right for the first element greater than the pivot
            swap(nums, i, j); // Swap these two elements
        }
        swap(nums, i, left); // Swap the pivot to the boundary between the two subarrays
        return i; // Return the index of the pivot
    }

    /* Swap elements */
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}