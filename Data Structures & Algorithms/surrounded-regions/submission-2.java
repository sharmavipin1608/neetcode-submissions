class Solution {
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;    

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
                    if (board[r][c] == 'O') {
                        dfs(board, r, c);
                    }
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;    

        if (row < 0 || rows <= row || col < 0 || cols <= col || board[row][col] != 'O') return;

        board[row][col] = '#';

        for (int[] dir : DIRS) {
            dfs(board, row + dir[0], col + dir[1]);
        }
    }
}
