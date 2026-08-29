class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q=new LinkedList<>();
        int[][] result=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
             int[] current=q.poll();
             int row=current[0];
             int col=current[1];
             result[row][col]=count;
            if(row - 1 >= 0 && mat[row - 1][col] == 1){
            mat[row-1][col]=0;
            q.offer(new int[]{row-1,col});
        }
        if (row + 1 < mat.length && mat[row + 1][col] == 1) {
            mat[row+1][col]=0;
            q.offer(new int[]{row+1,col});
        }
        if (col - 1 >= 0 && mat[row][col - 1] == 1) {
            mat[row][col-1]=0;
            q.offer(new int[]{row,col-1});
        }
        if (col + 1 < mat[0].length && mat[row][col + 1] == 1) {
        mat[row][col+1]=0;
        q.offer(new int[]{row,col+1});
        }
            }
            count++;
        }
        return result;
    }
}