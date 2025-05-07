class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] deltaRow= {-1,0,+1,0};
        int[] deltaCol = {0,+1,0,-1};
        boolean[][] visited = new boolean[n][m];
        for(boolean[] node : visited){
            Arrays.fill(node,false);
        }
        
        int count = 0;
        for(int i = 0; i <n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(n,m,i,j,grid,deltaRow,deltaCol,visited);
                }
            }
        }
        return count;
    }

    private void dfs(int n,int m,int row, int col, char[][] grid, int[] deltaRow, int[] deltaCol,boolean[][] visited){
        visited[row][col] = true;
        for(int i = 0; i < 4; i++){
            int newRow = deltaRow[i] + row;
            int newCol = deltaCol[i] + col;

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                if(!visited[newRow][newCol]){
                    if(grid[newRow][newCol] == '1'){
                        dfs(n,m,newRow,newCol,grid,deltaRow,deltaCol,visited);
                    }
                }
            }
        }
    }
}