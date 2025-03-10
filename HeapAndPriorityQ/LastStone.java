package HeapAndPriorityQ;

import java.util.PriorityQueue;

public class LastStone {
    public static void main(String[] args) {
        System.out.println();
    }
}


// Time complexity: O ( n log ⁡ n ) 
// Space complexity: O ( n )


class Solution {
    public int lastStoneWeight(int[] arr) {
        // int result = 0;
        // int[] arrDesc = Arrays.stream(arr).boxed()
        // .sorted(Collections.reverseOrder())
        // .mapToInt(Integer::intValue)
        // .toArray();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : arr) {
            minHeap.offer(-i);
        }

        while (minHeap.size()>1) {
            int first = minHeap.poll();
            int second = minHeap.poll();

            if(second>first){
                minHeap.offer(first - second);
            }

        }
        minHeap.offer(0);

        return Math.abs(minHeap.peek());

    }
}
