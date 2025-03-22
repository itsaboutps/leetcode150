
// https://leetcode.com/problems/top-k-frequent-elements/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentEl {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 3, 3 };
        int k = 2;

        System.out.print(f(nums, k));
        System.out.print(m(nums, k));

    }

    // * using bucket sort most optimised in O(n)
    private static int[] m(int[] nums, int k) {
        // int[] result = new int[k];
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> frequencyBucket = new ArrayList<>();

        // here i have to initialize frequency buckets
        for (int i = 0; i <= nums.length; i++) {
            frequencyBucket.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            frequencyBucket.get(freq).add(num);

        }

        // here now we will collect the top k frequent elements
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 1; i--) {
            List<Integer> bucket = frequencyBucket.get(i);

            for (int num : bucket) {
                result.add(num);
                if (result.size() == k) {
                    break;
                }
            }
            if (result.size() == k) {
                break;
            }

        }

        // convert the list to array
        int[] resArray = new int[result.size()];

        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = result.get(i);
        }
        return resArray;

    }

    // using priority heap implementation
    private static int[] f(int[] nums, int k) {

        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        System.out.println(mp.entrySet());
        maxHeap.addAll(mp.entrySet());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = (maxHeap.poll().getKey());
        }
        return result;

    }
}
