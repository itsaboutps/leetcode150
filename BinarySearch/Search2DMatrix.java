package BinarySearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        System.out.println("Search 2D Matrix");
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        System.out.println(usingBinarySearch(matrix, target));
        System.out.println(optimsedApproach(matrix, target));

    }

    private static boolean optimsedApproach(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }

        if (!(top <= bot)) {
            return false;
        }
        int row = (top + bot) / 2;
        int l = 0, r = COLS - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
        // TODO Auto-generated method stub
    }

    // here time complexity is n*logm ...here m is the number of columns and n is no
    // of rows
    private static boolean usingBinarySearch(int[][] matrix, int target) {
        for (int[] row : matrix) {

            int l = 0;
            int r = row.length - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] < target) {
                    l = mid + 1;
                } else if (row[mid] > target) {
                    r = mid - 1;
                }
            }

        }
        return false;

    }
}
