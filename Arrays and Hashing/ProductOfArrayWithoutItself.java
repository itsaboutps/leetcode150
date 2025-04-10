import java.util.Arrays;

public class ProductOfArrayWithoutItself {
    public static void main(String[] args) {
        System.out.println("Product of Array without itself.");
        int[] nums = { 1, 2, 3, 4 };
        fn(nums);
    }

    private static int[] fn(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0,left=1; i < n; i++) {
            ans[i] = left;
            left *= nums[i];
        }
        System.out.println(Arrays.toString(ans));
        for (int i = n-1,right=1; i >= 0; i--) {
            ans[i] *=right;
            right *=nums[i];
        }
        System.out.println(Arrays.toString(ans));
        return ans;

    }
}
