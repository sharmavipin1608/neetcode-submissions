class Solution {
    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == ROTTEN) {
                    queue.offer(new int[]{r,c});
                } else if (grid[r][c] == FRESH) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int time = 0;
        while (!queue.isEmpty() && freshCount > 0) {
            time++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int row = point[0];
                int col = point[1];

                //grid[row][col] = ROTTEN;

                for (int[] dir : DIRS) {
                    int nR = row + dir[0];
                    int nC = col + dir[1];

                    if (nR < 0 || nR >= rows || nC < 0 || nC >= cols || grid[nR][nC] != FRESH) {
                        continue;
                    }
                    grid[nR][nC] = ROTTEN;
                    queue.offer(new int[]{nR, nC});
                    freshCount--;
                }
            }
        }

        return freshCount == 0 ? time : -1;
    }
}
