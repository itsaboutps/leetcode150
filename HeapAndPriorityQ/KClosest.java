package HeapAndPriorityQ;

import java.util.*;

public class KClosest {
    public static void main(String[] args) {
        int[][] points = { { 1, 3 }, { -2, 2 } };
        int k = 1;
        kClosest(points, k);
    }

    private static void kClosest(int[][] points, int K) {

        PriorityQueue<int[]> minHeap  = new PriorityQueue<>(Comparator.comparing(a -> a[0]));


        for(int[] point:points){
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[]{dist, point[0], point[1]});
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; ++i) {
            int[] point = minHeap.poll();
            result[i] = new int[]{point[1], point[2]};
        }
        

        System.out.println(Arrays.deepToString(result));
    }
}
