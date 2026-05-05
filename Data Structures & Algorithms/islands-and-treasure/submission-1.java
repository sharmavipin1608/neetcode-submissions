class Solution {
    record Point(int row, int col) {}

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        Set<Point> visited = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited.add(new Point(i, j));
                }        
            }
        }

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int row = point[0];
                int col = point[1];

                grid[row][col] = dist;

                System.out.println(String.format("row [%s], col [%s] dist [%s]", row, col, dist));

                int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

                for (int[] dir : dirs) {
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];

                    System.out.println(nRow + " : " + nCol);

                    if (nRow < 0 || rows <= nRow || nCol < 0 || cols <= nCol) {
                        System.out.println("boundary breached");
                        continue;
                    }
                    if (visited.contains(new Point(nRow, nCol))) {
                        System.out.println("already visited");
                        continue;
                    }
                    if (grid[nRow][nCol] == -1) {
                        System.out.println("wall");
                        continue;
                    }
                    
                    System.out.println(nRow + " : " + nCol);
                    visited.add(new Point(nRow, nCol));
                    queue.offer(new int[]{nRow, nCol});
                }
            }

            dist++;
        }   
    }

    
}
