import java.util.HashSet;
import java.util.Set;

class ContainsDublicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4};
        System.out.println(containsDuplicatesHs(nums));
    }

    public static boolean containsDuplicatesHs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            
            //* O(1)
            set.add(num);
        }
        return false;
    }
}
//* what is time complexity of this code?
//* O(n)  