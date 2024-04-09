package Graphs;

import java.util.ArrayList;

public class BipartiteDFS {
  public boolean dfs(int node, int col, int[] colour, ArrayList<ArrayList<Integer>> adj) {
    colour[node] = col;

    for (int it : adj.get(node)) {
      if (colour[it] == -1) {
        if (!dfs(it, 1 - col, colour, adj)) {
          return false;
        }
      } else if (colour[it] == colour[node]) {
        return false;
      }
    }
    return true;
  }

  public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
    int[] color = new int[V];
    for (int i = 0; i < V; i++)
      color[i] = -1;

    for (int i = 0; i < V; i++) {
      if (color[i] == -1) {
        if (dfs(i, 0, color, adj) == false) {
          return false;
        }
      }
    }
    return true;
  }
}
