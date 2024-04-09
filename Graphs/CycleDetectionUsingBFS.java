package Graphs;

import java.util.*;

public class CycleDetectionUsingBFS {
  static class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  private static boolean hasCycle(int src, int V, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
    Queue<Pair> queue = new ArrayDeque<>();

    vis[src] = true;
    queue.offer(new Pair(src, -1));
    while (!queue.isEmpty()) {
      int node = queue.peek().first;
      int parent = queue.peek().second;
      queue.poll();

      for (int adjNode : graph.get(node)) {
        if (!vis[adjNode]) {
          vis[adjNode] = true;
          queue.offer(new Pair(adjNode, node));
        } else if (parent != adjNode) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
    boolean[] vis = new boolean[V];
    for (int i = 0; i < V; i++) {
      vis[i] = false;
    }

    for (int i = 0; i < V; i++) {
      if (!vis[i]) {
        if (hasCycle(i, V, graph, vis)) {
          return true;
        }
      }
    }

    return false;
  }
}
