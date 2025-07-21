import java.util.*;

public class DFSGraph {

    public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
        visited[node] = true;
        res.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, res);
            }
        }
    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        dfs(0, visited, adj, res);
        return res;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);

        ArrayList<Integer> result = dfsOfGraph(V, adj);

        System.out.println("DFS Traversal: " + result);
    }
}
