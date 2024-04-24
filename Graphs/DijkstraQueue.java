package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraQueue {
  static class Pair {
    int distance;
    int node;

    Pair(int dist, int node) {
      this.distance = dist;
      this.node = node;
    }
  }

  static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

    int[] dist = new int[V];
    for (int i = 0; i < V; i++)
      dist[i] = Integer.MAX_VALUE;

    dist[S] = 0;
    pq.offer(new Pair(0, S));

    while (!pq.isEmpty()) {
      Pair current = pq.poll();
      int distance = current.distance;
      int node = current.node;

      if (distance > dist[node])
        continue;

      for (int i = 0; i < adj.get(node).size(); i++) {
        int adjNode = adj.get(node).get(i).get(0);
        int adjWeight = adj.get(node).get(i).get(1);

        if (distance + adjWeight < dist[adjNode]) {
          dist[adjNode] = distance + adjWeight;
          pq.offer(new Pair(dist[adjNode], adjNode));
        }
      }
    }

    return dist;
  }

  public static void main(String[] args) {
    int V = 5;
    int start = 0;
    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Format: Node u -> {v, weight}
    adj.get(0).add(new ArrayList<Integer>() {
      {
        add(1);
        add(9);
      }
    });
    adj.get(0).add(new ArrayList<Integer>() {
      {
        add(2);
        add(6);
      }
    });
    adj.get(1).add(new ArrayList<Integer>() {
      {
        add(2);
        add(3);
      }
    });
    adj.get(1).add(new ArrayList<Integer>() {
      {
        add(3);
        add(5);
      }
    });
    adj.get(2).add(new ArrayList<Integer>() {
      {
        add(4);
        add(2);
      }
    });
    adj.get(3).add(new ArrayList<Integer>() {
      {
        add(4);
        add(7);
      }
    });
    adj.get(4).add(new ArrayList<Integer>() {
      {
        add(0);
        add(1);
      }
    });

    // Run Dijkstra's algorithm
    int[] distances = dijkstra(V, adj, start);

    // Print shortest path distances
    System.out.println("Shortest distances from node " + start + ":");
    for (int i = 0; i < distances.length; i++) {
      System.out.println("Distance to " + i + ": " + distances[i]);
    }
  }
}
