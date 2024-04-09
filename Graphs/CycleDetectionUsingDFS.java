package Graphs;

import java.util.*;

public class CycleDetectionUsingDFS {
  public boolean detectUsingDfs(int node, int parent, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
    vis[node] = true;

    for (int adjNode : graph.get(node)) {
      if (!vis[adjNode]) {
        if (detectUsingDfs(adjNode, node, graph, vis)) {
          return true;
        }
      } else if (adjNode != parent) {
        return true;
      }
    }
    return false;
  }

  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
    boolean[] vis = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!vis[i]) {
        if (detectUsingDfs(i, -1, graph, vis)) {
          return true;
        }
      }
    }
    return false;
  }
}
