class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        int[] ans = new int[queries.length];
        for(int i = 0 ; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i <= n-1; i++){
            adj.get(i).add(i+1);
        }

        int index = 0;
        for(int[] query : queries){
            int u = query[0];
            int v = query[1];
            adj.get(u).add(v);
            int distance = bfs(adj,n);
            ans[index++] = distance;
        }

        return ans;
        
    }

    private int bfs(ArrayList<ArrayList<Integer>> adj,int n){
        Queue<Integer> track = new LinkedList<>();
        boolean[] visited = new boolean[n];

        track.add(0);
        visited[0] = true;

        int level = 0;
        while(!track.isEmpty()){
            int size = track.size();
            for(int i = 0 ; i < size; i++){
                int node = track.poll();

                if(node  == n-1){
                    return level;
                }

                for(int adjNode : adj.get(node)){
                    if(!visited[adjNode]){
                        visited[adjNode] = true;
                        track.add(adjNode);
                    }
                }
            }
            level++;
        }
        return -1;

    }
}