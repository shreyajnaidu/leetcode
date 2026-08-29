class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        if(grid[0][0]==0){
            grid[0][0]=1;
            q.offer(new int[]{0,0});
        }else{
            return -1;
        }
        int count=1;
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] current = q.poll();

            int row = current[0];
            int col = current[1];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
            return count;
            }
            for (int k = 0; k < 8; k++) {

            int nr = row + dr[k];
            int nc = col + dc[k];

            if (nr >= 0 && nr < grid.length &&
                nc >= 0 && nc < grid[0].length &&
                grid[nr][nc] == 0) {
                grid[nr][nc] = 1;
                q.offer(new int[]{nr, nc});
            }
          }
        }
        count++;
        }
         return -1;
        
    }
}