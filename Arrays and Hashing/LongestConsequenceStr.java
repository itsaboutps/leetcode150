import java.util.HashSet;
import java.util.Set;

public class LongestConsequenceStr {
    public static void main(String[] args) {
        System.out.println("LongestConsequenceStr");
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(f(nums));
    }

    private static int f(int[] nums) {
        // TODO Auto-generated method stub

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        // now I am checking if it is start of sequence.
        int ans = 0;

        for (int x : set) {
            if (!(set.contains(x - 1))) {
                int y = x + 1;
                while (set.contains(y)) {
                    y += 1;
                }
                ans = Math.max(ans, y - x);
            }
        }
        return ans;

    }
}
