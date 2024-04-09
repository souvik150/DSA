package Graphs;

import java.util.*;

public class NumberOfProvinces {
  private static void dfs(int start, boolean[] vis, ArrayList<ArrayList<Integer>> graph) {
    vis[start] = true;
    for (int i = 0; i < graph.get(start).size(); i++) {
      int nextNode = graph.get(start).get(i);
      if (!vis[nextNode]) {
        dfs(nextNode, vis, graph);
      }
    }
  }

  private static int numProvinces(int V, ArrayList<ArrayList<Integer>> graph) {
    int counter = 0;
    boolean[] vis = new boolean[V + 1];

    for (int i = 0; i < V; i++) {
      if (!vis[i]) {
        dfs(i, vis, graph);
        counter++;
      }
    }

    return counter;
  }

  public static void main(String[] args) {
    int V = 8; // Number of vertices
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);

    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }

    graph.get(0).add(1);
    graph.get(1).add(0);
    graph.get(1).add(2);
    graph.get(2).add(1);

    graph.get(3).add(4);
    graph.get(4).add(3);

    graph.get(6).add(7);
    graph.get(7).add(6);

    int numberOfProvinces = numProvinces(V, graph);
    System.out.println("Number of provinces: " + numberOfProvinces);
  }
}
