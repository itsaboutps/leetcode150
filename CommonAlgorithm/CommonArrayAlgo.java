package CommonAlgorithm;

import java.util.Arrays;
import java.util.Collections;

public class CommonArrayAlgo {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 1, 4, 6, 2, 8 };
        reverseAnArray(arr);
    }

    //! to rever the primitive array of integer
    private static void reverseAnArray(int[] arr) {
        //! way-1
        Arrays.sort(arr);
        //*by default will sort the array [Quick sort ] [Time Complexity: N*LOG N]
        System.out.println(Arrays.toString(arr));

        //! way-2
        // *what if you want to sort in descending order
        //* as custom comparators does not support primitive int so we neet to convert to Wrapper classs*/
        Integer[] array = {5,2,1,4,5,9};
        Arrays.sort(array, Collections.reverseOrder());
        System.err.println(Arrays.toString(array));

        //! way-3
        //* another way to use the streams API */
        int[] arrs = {5,2,5,61,568,1};
        arrs = Arrays.stream(arrs) //convert to IntStream
        .boxed() // convert to Integer Streams
        .sorted((a,b)->b-a) // sort in descending 
        .mapToInt(Integer::intValue) // convert back to int[]
        .toArray();

        System.out.println(Arrays.toString(arrs));

    }
}
