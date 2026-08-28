class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
            q.offer(new int[]{i, j});
        }
        if(grid[i][j]==1){
            fresh++;
        }
      }
    }
    int count=0;
    while(!q.isEmpty() && fresh>0){
        int size=q.size();
        for(int i=0;i<size;i++){
        int[] current=q.poll();
        int row=current[0];
        int col=current[1];
        if(row - 1 >= 0 && grid[row - 1][col] == 1){
            grid[row-1][col]=2;
            q.offer(new int[]{row-1,col});
            fresh--;
        }
        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            grid[row+1][col]=2;
            q.offer(new int[]{row+1,col});
            fresh--;
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            grid[row][col-1]=2;
            q.offer(new int[]{row,col-1});
            fresh--;
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
        grid[row][col+1]=2;
        q.offer(new int[]{row,col+1});
        fresh--;
        }
        }
        count++;
    }
    if (fresh > 0) {
            return -1;
        }
    return count;
    }
}