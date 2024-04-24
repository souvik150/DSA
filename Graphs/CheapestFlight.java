package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlight {
  static class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  static class Node {
    int stop;
    int node;
    int dist;

    Node(int stop, int node, int dist) {
      this.stop = stop;
      this.node = node;
      this.dist = dist;
    }
  }

  public static int cheapestFlight(int n, int[][] flights, int src, int dst, int K) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
    }

    Queue<Node> q = new LinkedList<>();
    q.add(new Node(0, src, 0));
    int[] dist = new int[n];
    for (int i = 0; i < n; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[src] = 0;

    while (!q.isEmpty()) {
      Node it = q.remove();
      int stops = it.stop;
      int node = it.node;
      int cost = it.dist;

      if (stops > K)
        continue;

      for (Pair iter : adj.get(node)) {
        int adjNode = iter.first;
        int edW = iter.second;

        if (cost + edW < dist[adjNode] && stops <= K) {
          dist[adjNode] = cost + edW;
          q.add(new Node(stops + 1, adjNode, cost + edW));
        }
      }
    }

    if (dist[dst] == Integer.MAX_VALUE)
      return -1;
    return dist[dst];
  }
}
