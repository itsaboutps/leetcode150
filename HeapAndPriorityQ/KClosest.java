package HeapAndPriorityQ;

import java.util.*;

public class KClosest {
    public static void main(String[] args) {
        int[][] points = { { 1, 3 }, { -2, 2 } };
        int k = 1;
        kClosest(points, k);
    }

    private static void kClosest(int[][] points, int k) {

        HashMap<Integer, int[]> hashMap = new HashMap<>();
        PriorityQueue<Integer> minHeap  = new PriorityQueue<>();


        for(int[] point:points){
            int distance = point[0]+point[1];
            hashMap.put(distance, point);
            minHeap.offer(distance);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[][] res =  new int[k][k];
        int count =0;
        while(minHeap.size()>0){
            int f = minHeap.poll();
            int[] val = hashMap.get(f); 
            res[count++] = val;
        }
        

        System.out.println(Arrays.deepToString(res));
    }
}
