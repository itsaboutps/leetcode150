
class ValidSuduko {
    public static void main(String[] args) {

        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                           { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
                           { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                           { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
                           { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                           { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
                           { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                           { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
                           { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        // f(board);
        char[][] board1 = { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                            { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
                            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                            { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
                            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                            { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
                            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                            { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
                            { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
                            
                            System.out.println(isValidSudoku(board1));
    }

    public static boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9]; // tracking numbers in row
        boolean[][] column = new boolean[9][9]; // tracking numbers in column

        boolean[][] subBox = new boolean[9][9]; // track numbers in each 3*3 sub-box

        // Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue; // skip empty cells
                }

                // remaining for future if want to convert the char to NUMBER
                // then directly do {character - '0'}
                // for example =>> '1' ==> '1' - '0' = 49-48 = 1
                // additional -1 because of zero based indexed
                int num = c - '0' - 1; 
                int k = (i / 3) * 3 + j / 3;

                if (row[i][num] || column[j][num] || subBox[k][num]) {
                    return false;
                }
                row[i][num] = true;
                column[j][num] = true;
                subBox[k][num] = true;
            }
        }
        return true;
    }
}