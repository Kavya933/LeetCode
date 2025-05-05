class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adjList.get(v).add(u);  // added ulta so that it will verify the condition
        }
        
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(dfs(i,adjList,visited, pathVisited)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int src, ArrayList<ArrayList<Integer>> adjList,  boolean[] visited,  boolean[] pathVisited){
        visited[src] = true;
        pathVisited[src] = true;

        for(int adjNode : adjList.get(src)){
            if(!visited[adjNode]){
                if(dfs(adjNode,adjList,visited,pathVisited)){
                    return true;  // cycle xa vane
                }
            }
            else if(pathVisited[adjNode]){
                return true;   // cycle detected 
            }
        }
        pathVisited[src] = false;
        return false;
    }
}