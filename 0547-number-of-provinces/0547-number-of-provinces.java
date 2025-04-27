class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int numberOfProv = 0;

        for(int city = 0; city < n; city++){
            if(!isVisited[city]){
                numberOfProv ++;
                dfs(city,isVisited,isConnected,n);
            }
        }
        return numberOfProv;
    }
    private void dfs(int src, boolean[] isVisited, int[][] isConnected, int n){
        isVisited[src] = true;
        
        // look for ajadacent city if 1 means connected otherwise 0

        for(int adjCity = 0; adjCity < n; adjCity++){
            if(isConnected[src][adjCity] == 1 && !isVisited[adjCity]){
                dfs(adjCity,isVisited,isConnected,n);
            }
        }
    }
}