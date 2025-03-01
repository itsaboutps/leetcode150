package BinarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println("KokoEatingBananas");
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        // System.out.println(approach1(piles, h));

        System.out.println(optimsedAppraoch(piles, h));

    }

    // Time complexity: O(m∗n)
    // Space complexity: O(1)

    private static int optimsedAppraoch(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int k = (l + r) / 2;

            long totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / k);
            }
            if (totalTime <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
        // TODO Auto-generated method stub
    }

    private static int approach1(int[] piles, int h) {
        int speed = 1;
        while (true) {
            long totalTime = 0;
            for (int pile : piles) {
                totalTime += (int) Math.ceil((double) pile / speed);
            }

            if (totalTime <= h) {
                return speed;
            }
            speed++;
        }
    }
}
