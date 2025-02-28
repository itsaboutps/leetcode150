package StacksQ;

public class LargestRectangleArea {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
        System.out.println(optimsedApproach(heights));

    }

    private static char[] optimsedApproach(int[] heights) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'optimsedApproach'");
    }

    private static int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];

            int rightMost = i + 1;
            while (rightMost < n && heights[rightMost] >= height) {
                rightMost++;
            }

            int leftMost = i;
            while (leftMost >= 0 && heights[leftMost] >= height) {
                leftMost--;
            }

            rightMost--;
            leftMost++;
            maxArea = Math.max(maxArea, height * (rightMost - leftMost + 1));
        }
        System.out.println(maxArea);
        return maxArea;
    }
}

