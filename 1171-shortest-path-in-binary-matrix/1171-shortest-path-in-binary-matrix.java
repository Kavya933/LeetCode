class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] deltaRow = {-1, -1, -1,  0,  1,  1,  1,  0};
        int[] deltaCol = { 0,  1, -1,  1,  0,  1, -1, -1};

        PriorityQueue<Tuple> track = new PriorityQueue<>((a,b) -> a.length - b.length);
        int[][] minDistance = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                minDistance[i][j] = (int)(1e9); 
            }
        }

        // If the start or end cell is blocked, return -1
        if (grid[0][0] != 0 || grid[n-1][m-1] != 0) {
            return -1;
        }
        // Add the starting point with 1 length
        track.add(new Tuple(0, 0,1));
        minDistance[0][0] = 0;

        while (!track.isEmpty()) {
            Tuple current = track.poll();
            int row = current.row;
            int col = current.col;
            int length = current.length;

            if(row == n-1 && col == m-1){
                return length;
            }

            for(int i = 0; i < 8; i++){
                int newRow = deltaRow[i]+row;
                int newCol = deltaCol[i]+col;

         // Check if the new cell is within bounds, unvisited, and not blocked
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                    if(grid[newRow][newCol] == 0){
                        int newLength = length + 1;
                        // Mark the new cell as visited and add it to the queue
                        if(newLength < minDistance[newRow][newCol]){
                            minDistance[newRow][newCol] = newLength;
                            track.add(new Tuple(newRow,newCol,newLength));
                        }                        
                    }       
                } 
            }
        }
        return -1;

    }
}
// Tuple class to hold row, column, and cost
class Tuple {
    int row, col, length;

    Tuple(int row, int col, int length) {
        this.row = row;
        this.col = col;
        this.length = length;
    }
}