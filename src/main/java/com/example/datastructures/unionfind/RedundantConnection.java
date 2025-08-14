package com.example.datastructures.unionfind;

/**
 * @version 1.0
 * @description:
 * @author: sonhoangthanh
 * @date: 04/08/2025 17:34
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            if (uf.find(u) == uf.find(v)) {
                return edge;
            }

            uf.unionSet(u, v);
        }

        return new int[0]; // Không tìm thấy cạnh dư thừa
    }

    public static void main(String[] args) {
        RedundantConnection i = new RedundantConnection();
//        System.out.println(i.findRedundantConnection(new int[][]{{1,2}, {1,3}, {3,4}, {1,4}, {1,5}}));  //[1,4]
//        System.out.println(i.findRedundantConnection(new int[][]{{1,2}, {2,3}, {3,4}, {2,4}, {5,6}}));  //[2,4]
        System.out.println(i.findRedundantConnection(new int[][]{{1,2},{3,4},{2,3},{2,4}}));  //[2,4]

    }

}

class UnionFind {
    int[] parent;
    int[] rank;

    // Initialize Union-Find structure with parent and rank arrays.
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        // Initially, each element is its own parent (self loop).
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    // Find the root representative of the set containing x with path compression.
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression.
        }
        return parent[x];
    }

    // Union two sets containing x and y using union by rank.
    public void unionSet(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // If they are in the same set, do nothing.
        if (rootX == rootY) {
            return;
        }

        // Union by rank.
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        }
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
