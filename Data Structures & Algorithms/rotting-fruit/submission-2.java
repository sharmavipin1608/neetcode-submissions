class Solution {
    private static final int EMPTY = 0;
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == ROTTEN) {
                    queue.offer(new int[]{r,c});
                }
            }
        }

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int row = point[0];
                int col = point[1];

                grid[row][col] = ROTTEN;

                for (int[] dir : DIRS) {
                    int nR = row + dir[0];
                    int nC = col + dir[1];

                    if (nR < 0 || nR >= rows || nC < 0 || nC >= cols || grid[nR][nC] != FRESH) {
                        continue;
                    }
                    grid[nR][nC] = ROTTEN;
                    queue.offer(new int[]{nR, nC});
                }
            }

            time++;
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == FRESH) {
                    return -1;
                }
            }
        }

        return time > 0 ? time - 1 : 0;
    }
}
