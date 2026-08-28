class Solution {
    public int numIslands(char[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                // Found a new island
                if (grid[i][j] == '1') {

                    count++;

                    // Mark it visited
                    grid[i][j] = '2';

                    // Add its coordinate
                    q.offer(new int[]{i, j});

                    // BFS the entire island
                    while (!q.isEmpty()) {

                        int[] current = q.poll();

                        int row = current[0];
                        int col = current[1];

                        // UP
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            grid[row - 1][col] = '2';
                            q.offer(new int[]{row - 1, col});
                        }

                        // DOWN
                        if (row + 1 < grid.length && grid[row + 1][col] == '1') {
                            grid[row + 1][col] = '2';
                            q.offer(new int[]{row + 1, col});
                        }

                        // LEFT
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            grid[row][col - 1] = '2';
                            q.offer(new int[]{row, col - 1});
                        }

                        // RIGHT
                        if (col + 1 < grid[0].length && grid[row][col + 1] == '1') {
                            grid[row][col + 1] = '2';
                            q.offer(new int[]{row, col + 1});
                        }
                    }
                }
            }
        }

        return count;
    }
}