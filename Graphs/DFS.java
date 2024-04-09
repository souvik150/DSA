package Graphs;

import java.util.*;

public class DFS {
  private static void dfs(int start, boolean[] vis, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> res) {
    vis[start] = true;
    res.add(start);

    for (int i = 0; i < graph.get(start).size(); i++) {
      int adjNode = graph.get(start).get(i);
      if (vis[adjNode] == false) {
        dfs(graph.get(start).get(i), vis, graph, res);
      }
    }
  }

  private static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> graph, int start) {
    boolean[] vis = new boolean[V];
    ArrayList<Integer> res = new ArrayList<>();

    vis[start] = true;
    dfs(start, vis, graph, res);
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

    ArrayList<Integer> dfsResult = dfsOfGraph(V, graph, 0);
    System.out.println("DFS traversal starting from node: " + dfsResult);
  }
}
