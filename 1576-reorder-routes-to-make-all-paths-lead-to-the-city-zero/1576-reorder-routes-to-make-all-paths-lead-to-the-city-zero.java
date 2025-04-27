class Solution {
    public int minReorder(int n, int[][] connections) {
        boolean isVisited[] = new boolean[n];
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<Pair>());
        }

        for(int[] connection : connections){
            int from = connection[0];
            int to = connection[1];
            adjList.get(from).add(new Pair(to,1));  // original  idea yo xa ki original 1 xa ra add hudai janxa ra tei ans ho
            adjList.get(to).add(new Pair(from,0));   // reverse
        }
        return dfs(0,isVisited,adjList);
    }

    private int dfs(int src, boolean[] isVisited, ArrayList<ArrayList<Pair>> adjList){
        isVisited[src] = true;
        int reorderCount = 0;

        for(Pair neighbor : adjList.get(src)){
            int adjNode = neighbor.node;
            int direction = neighbor.direction;
            if(!isVisited[adjNode]){
                reorderCount += direction;
                reorderCount += dfs(adjNode,isVisited,adjList);
            }
        }
        return reorderCount;
    }
}
class Pair{
    int node;
    int direction;
    Pair(int node, int direction){
        this.node = node;
        this.direction = direction;
    }
}