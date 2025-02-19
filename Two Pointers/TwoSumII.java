
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 3;

        // BRUTE FORCE
        // SPACE: O[1]
        // TIME : O[N^2]
        System.out.println(Arrays.toString(f((arr),target)));


        


        //using two pointers
        //time and space both are O(n) and O(1)
        System.out.println(Arrays.toString(g((arr),target)));


        //using hashmap
        //time and space both are O(n)
        System.out.println(Arrays.toString(k((arr),target)));


        //BINARY SEARCH 
        //TIME N[LOG N] === Binary search algo
        //SPACE: O[1]
        System.out.println(Arrays.toString(l((arr),target)));



        //
    }



    private static int[] f(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i + 1, j + 1 };
                }
            }
        }
        return new int[0];

    }

    private static int[] g(int[] numbers, int target) {

        // for (int i = 0; i < numbers.length; i++) {
            int l=0, 
            r = numbers.length-1;


            while(l<=r){
                int currentSum  = numbers[l] + numbers[r];
                if(currentSum>target){
                    r-=1;
                }else if(currentSum<target){
                    l+=1;
                }

                //last case is when current sum is equal to target ==> our answer
                else{
                    return new int[]{l+1,r+1};
                }

            }
        return new int[]{};


    }

    private static int[] k(int[] numbers, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int tmp = target - numbers[i];
            if (mp.containsKey(tmp)) {
                return new int[] { mp.get(tmp), i + 1 };
            }
            mp.put(numbers[i], i + 1);
        }
        return new int[0];
    }

    private static int[] l(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1, r = numbers.length - 1;
            int tmp = target - numbers[i];
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] == tmp) {
                    return new int[] { i + 1, mid + 1 };
                } else if (numbers[mid] < tmp) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return new int[0];

        
    }
}
