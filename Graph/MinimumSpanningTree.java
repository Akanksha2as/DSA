import java.util.*;

public class MinimumSpanningTree {

    static class Edge {
        int u, v, wt;
        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) return;
            if (rank[xr] < rank[yr]) parent[xr] = yr;
            else if (rank[yr] < rank[xr]) parent[yr] = xr;
            else {
                parent[yr] = xr;
                rank[xr]++;
            }
        }
    }

    public static int minimumSpanningTree(int V, int[][] edges) {
        List<Edge> edgeList = new ArrayList<>();
        for (int[] e : edges) {
            edgeList.add(new Edge(e[0], e[1], e[2]));
        }

        edgeList.sort(Comparator.comparingInt(e -> e.wt));
        DSU dsu = new DSU(V);
        int mstWeight = 0;

        for (Edge edge : edgeList) {
            if (dsu.find(edge.u) != dsu.find(edge.v)) {
                mstWeight += edge.wt;
                dsu.union(edge.u, edge.v);
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
            {0, 1, 10},
            {0, 2, 6},
            {0, 3, 5},
            {1, 3, 15},
            {2, 3, 4}
        };

        int result = minimumSpanningTree(V, edges);
        System.out.println("Minimum Spanning Tree weight: " + result);
    }
}
