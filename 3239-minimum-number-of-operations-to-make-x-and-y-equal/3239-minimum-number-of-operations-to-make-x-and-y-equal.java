class Solution {
    public class Pair{
        int value;
        int distance;
        Pair(int value, int distance){
            this.value = value;
            this.distance = distance;
        }
    }
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(y > x){
            return (y-x);
        }
        Queue<Pair> track = new LinkedList<>();
        boolean[] visited = new boolean[10001];
        track.add(new Pair(x,0));
        visited[x] = true;

        while(!track.isEmpty()){
            Pair p = track.poll();
            int node = p.value;
            int distance = p.distance;

            if(y == node){
                return distance;
            }

            if(node-1 >= 1 && !visited[node-1]){
                visited[node-1] = true;
                track.add(new Pair(node-1, distance+1));
            }
            if (node % 5 == 0 && !visited[node / 5]) {
                visited[node / 5] = true;
                track.add(new Pair(node / 5, distance + 1));
            }

            if (node % 11 == 0 && !visited[node / 11]) {
                visited[node / 11] = true;
                track.add(new Pair(node / 11, distance + 1));
            }

            if (node + 1 < visited.length && !visited[node + 1]) {
                visited[node + 1] = true;
                track.add(new Pair(node + 1, distance + 1));
            }
        }
        return -1;
        
    }
}