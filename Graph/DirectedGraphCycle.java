import java.util.*;

public class DirectedGraphCycle {

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 1} 
        };

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) adj.get(edge[0]).add(edge[1]);

        Solution obj = new Solution();
        boolean hasCycle = obj.isCyclic(V, adj);
        System.out.println("Cycle Detected: " + hasCycle);
    }
}

class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack, adj)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, recStack, adj)) return true;
            } else if (recStack[neighbor]) {
                return true;  
            }
        }

        recStack[node] = false;
        return false;
    }
}
