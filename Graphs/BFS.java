package Graphs;

import java.util.*;

public class BFS {
  static ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> nodes, int start) {

    ArrayList<Integer> res = new ArrayList<>();
    Queue<Integer> queue = new ArrayDeque<>();
    boolean[] vis = new boolean[V];

    queue.offer(start);
    vis[start] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      res.add(node);
      for (int i = 0; i < nodes.get(node).size(); i++) {
        int nextNode = nodes.get(node).get(i);
        if (!vis[nextNode]) {
          queue.offer(nextNode);
          vis[nextNode] = true;
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int V = 8;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<Integer>());
    }

    graph.get(0).add(1);
    graph.get(0).add(2);
    graph.get(1).add(3);
    graph.get(2).add(4);
    graph.get(2).add(5);
    graph.get(3).add(6);
    graph.get(4).add(6);
    graph.get(4).add(7);
    graph.get(5).add(2);
    graph.get(6).add(7);

    ArrayList<Integer> bfsResult = bfs(V, graph, 0);
    System.out.println("BFS traversal starting from node: " + bfsResult);
  }
}
