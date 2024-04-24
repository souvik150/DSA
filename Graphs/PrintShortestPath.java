package Graphs;

import java.util.*;

public class PrintShortestPath {
  static class Node {
    int from;
    int to;
    int weight;

    Node(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }

  public static List<Integer> shortestPath(int n, int m, int[][] edges) {
    ArrayList<ArrayList<Node>> adj = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      adj.get(edges[i][0]).add(new Node(edges[i][0], edges[i][1], edges[i][2]));
      adj.get(edges[i][1]).add(new Node(edges[i][1], edges[i][0], edges[i][2]));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

    int[] dist = new int[n + 1];
    int[] parent = new int[n + 1];

    Arrays.fill(dist, Integer.MAX_VALUE);
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    dist[1] = 0;
    pq.add(new Node(0, 1, 0));

    while (!pq.isEmpty()) {
      Node it = pq.poll();
      int node = it.to;
      int dis = it.weight;

      for (Node iter : adj.get(node)) {
        int adjNode = iter.to;
        int edW = iter.weight;

        if (dis + edW < dist[adjNode]) {
          dist[adjNode] = dis + edW;
          pq.add(new Node(node, adjNode, dis + edW));
          parent[adjNode] = node;
        }
      }
    }

    List<Integer> path = new ArrayList<>();
    if (dist[n] == Integer.MAX_VALUE) {
      path.add(-1);
      return path;
    }

    path.add(dist[n]);

    int node = n;
    while (parent[node] != node) {
      path.add(node);
      node = parent[node];
    }
    path.add(1);
    Collections.reverse(path);

    return path;
  }

  public static void main(String[] args) {
    int n = 5, m = 6;
    int[][] edges = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
    List<Integer> result = shortestPath(n, m, edges);
    System.out.println("Path weight and nodes from source to destination:");
    result.forEach(node -> System.out.print(node + " "));
    System.out.println();
  }
}
