package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import javafx.util.Pair;
import java.util.Queue;

public class NumberOfIsland {
    public static void main(String[] args) {
        System.out.println("Number of Island");
        NumberOfIslandSolution solution = new NumberOfIslandSolution();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid));
        
    }
}



class NumberOfIslandSolution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        HashSet<Pair<Integer, Integer>> visit = new HashSet<>();

        int res = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == '1' && !(visit.contains(new Pair<>(i, j)))) {
                    bfs(i, j, grid, visit);
                    res++;

                }
            }
        }
        return res;
    }

    private void bfs(int r, int c, char[][] grid, HashSet<Pair<Integer, Integer>> visit) {
        // remember bfs is not a recursive its iterative so we need data structure for
        // memory, Queue is normally used for BFS.
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        visit.add(new Pair<>(r, c));
        q.offer(new Pair<>(r, c));

        while (!(q.isEmpty())) {
            Pair<Integer, Integer> rowCol = q.poll();

            int row = rowCol.getKey();
            int col = rowCol.getValue();

            int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            int ROWS = grid.length;
            int COLS = grid[0].length;

            for (int[] dir : direction) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < ROWS && newCol >= 0 && newCol < COLS &&
                        grid[newRow][newCol] == '1' && !visit.contains(new Pair<>(newRow, newCol))) {
                    visit.add(new Pair<>(newRow, newCol));
                    q.offer(new Pair<>(newRow, newCol));
                }
            }
        }

    }
}