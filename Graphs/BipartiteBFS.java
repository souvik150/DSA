package Graphs;

import java.util.*;

public class BipartiteBFS {
  private boolean check(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] colour) {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(start);
    colour[start] = 0;

    while (!q.isEmpty()) {
      int node = q.poll();
      for (int it : adj.get(node)) {
        if (colour[it] == -1) {
          colour[it] = 1 - colour[node];
          q.add(it);
        } else if (colour[it] == colour[node]) {
          return false;
        }
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
        if (check(i, V, adj, color) == false) {
          return false;
        }
      }
    }
    return true;
  }
}
