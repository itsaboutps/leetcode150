
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// https://neetcode.io/solutions/sliding-window-maximum
public class SlidingWindowMax {
    public static void main(String[] args) {
        System.out.println("Sliding Window Maximum");
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        // * output = [3,3,5,5,6,7];
        // System.out.println(Arrays.toString(bruteForce(nums, k)));
        // slidingWindowMax(nums, k);

        //using Deque solutions
        //* Monotonically decreasing queue */
        System.out.println(Arrays.toString(optimisedApproach(nums, k)));

    }

    private static int[] optimisedApproach(int[] nums, int k) {
        int length = nums.length;

        int[] output = new int[length-k+1];
        int l,r;
        l=r=0;

        //this will contain indexes
        Deque<Integer> deque = new LinkedList<>();

        while(r<length){

            //pop the smaller values from the queue
            while(!(deque.isEmpty()) && (nums[deque.getLast()] < nums[r])){
                deque.removeLast();
            }
            deque.addLast(r);

            if(l>deque.getFirst()){
                deque.removeFirst();
            }
            if((r+1)>=k){
                output[l] = nums[deque.getFirst()];
                l++;
            }
            r++;
        }
            return output;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'optimisedApproach'");
    }

    private static int[] bruteForce(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 || n == 0) {
            return nums;
        }
        int[] output = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }
}
