class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] ans = image;    // naya banauna xaina same rakhne kine vane baki ko number same huna paryo ans ma
        int[] deltaRow = {-1,0,+1,0};
        int[] deltaCol = {0,+1,0,-1};

        int prevColor = image[sr][sc];

        dfs(n,m,image,sr,sc,ans,color,prevColor,deltaRow,deltaCol);

        return ans;

    }

    private void dfs(int n, int m, int[][] image, int sr, int sc, int[][] ans, int color, int prevColor,int[] deltaRow, int[] deltaCol){
        ans[sr][sc] = color;
        for(int i = 0; i < 4; i++){
            int newRow = deltaRow[i] + sr;
            int newCol = deltaCol[i] + sc;

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && image[newRow][newCol] == prevColor
              && ans[newRow][newCol] != color){
                dfs(n,m,image, newRow, newCol, ans,color,prevColor,deltaRow,deltaCol);
              }
        }
    }
}