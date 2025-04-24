class Solution {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // Initialize adjacency list
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // One-based indexing
            adjList.add(new ArrayList<Pair>());
        }

        // Build adjacency list
        for (int[] nodes : times) {
            int u = nodes[0];
            int v = nodes[1];
            int time = nodes[2];
            adjList.get(u).add(new Pair(v, time));
        }

        // Priority queue for Dijkstra's algorithm
        PriorityQueue<Pair> track = new PriorityQueue<>((a, b) -> a.second - b.second);

        // Shortest time array, one-based indexing
        int[] shortestTime = new int[n + 1];
        Arrays.fill(shortestTime, Integer.MAX_VALUE);
        shortestTime[k] = 0; // Start from source

        track.add(new Pair(k, 0));

        while (!track.isEmpty()) {
            Pair p = track.poll();
            int node = p.first;
            int timeOfNode = p.second;

            for (Pair adjVertex : adjList.get(node)) {
                int adjNode = adjVertex.first;
                int timeOfAdjNode = adjVertex.second;
                int totalTime = timeOfNode + timeOfAdjNode;

                if (totalTime < shortestTime[adjNode]) {
                    shortestTime[adjNode] = totalTime;
                    track.add(new Pair(adjNode, totalTime));
                }
            }
        }

        // Calculate maximum time taken
        int timeTaken = 0;
        for (int i = 1; i <= n; i++) { // Ignore index 0
            if (shortestTime[i] == Integer.MAX_VALUE) {
                return -1; // Node is unreachable
            }
            timeTaken = Math.max(timeTaken, shortestTime[i]);
        }
        return timeTaken;
    }
}
