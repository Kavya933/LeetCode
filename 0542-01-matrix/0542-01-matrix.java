class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        int[] deltaRow = {-1, 0, +1, 0};
        int[] deltaCol = {0, +1, 0, -1};

        Queue<Pair> track = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){     // put all 0 in queue - better approach than putting all 1 in queue
                    track.add(new Pair(i,j));
                    ans[i][j] = 0;
                }
                else{
                    ans[i][j] = -1;    // in ans array mark all as -1 if it's 1 in mat
                }
            }
        }

        int distance = 1;   // level order traversal
        while(!track.isEmpty()){

            int size = track.size();
            for(int i = 0; i < size; i++){
                Pair node = track.poll();
                int row = node.first;
                int col = node.second;

                for(int index = 0; index < 4; index++){
                    int newRow = row + deltaRow[index];
                    int newCol = col + deltaCol[index];         // reason for not creating visited array is ans array ma change hunxa -1 ko value ra next time same neighbor vayo vane ni -1 hunna so repeat hunna tei vayera ans ma -1 xa ki nai check gareko.
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && ans[newRow][newCol] == -1) {
                        track.add(new Pair(newRow,newCol));  // add all 4 direction nodes
                        ans[newRow][newCol] = distance;
                    }
                }
            }
            distance++;
        }
        return ans;
    }
}
  class Pair{
    int first;
    int second;
   
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
  }