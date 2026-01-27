import java.util.*;

public class Solution {

    public int minCost(int n, int[][] edges) {

        // Build graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], c = edge[2];
            graph.get(u).add(new int[]{v, c});
            graph.get(v).add(new int[]{u, 2 * c});
        }

        // Dijkstra
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e8);
        dist[0] = 0;

        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];

            if (vis[node]) continue;
            vis[node] = true;
            if (node == n-1) break;

            for (int[] next : graph.get(node)) {
                int nei = next[0], w = next[1];
                if (!vis[nei] && dist[nei] > dist[node] + w) {
                    dist[nei] = dist[node] + w;
                    pq.offer(new int[]{nei, dist[nei]});
                }
            }
        }

        return vis[n-1] ? dist[n-1] : -1;
    }
}
