package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {

    Set<Integer> col = new HashSet<>();
    Set<Integer> postDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("NQueen");
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, n, board);
        return res;
    }

    private static void backtrack(int r, int n, char[][] board) {
        if (r == n) {
            // hitting the base condition
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || postDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
                // skipping that column
            }
            col.add(c);
            postDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1, n, board);

            col.remove(c);
            postDiag.remove(r+c);
            negDiag.remove(r-c);
            board[r][c] = '.';


        }
    }
}


// Time complexity: O ( n ! ) 
// Space complexity: O ( n 2 ) 

//class Solution {



//}