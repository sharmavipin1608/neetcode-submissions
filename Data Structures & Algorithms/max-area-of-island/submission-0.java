class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, scan(grid, i, j));
                }
            }
        }

        return res;
    }

    private int scan(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || rows <= row || col < 0 || cols <= col || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        int sum = 1;
        for (int[] dir : dirs) {
            sum += scan(grid, row + dir[0], col + dir[1]);
        }

        return sum;
    }
}
