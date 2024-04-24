package Graphs;

import java.util.*;

public class NumWaysToArriveDest {
  static class Pair {
    int node;
    long distance;

    Pair(int node, long distance) {
      this.node = node;
      this.distance = distance;
    }
  }

  static int countPaths(int n, List<List<Integer>> roads) {

    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      ArrayList<Pair> temp = new ArrayList<>();
      adj.add(temp);
    }
    int m = roads.size();
    for (int i = 0; i < m; i++) {
      adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
      adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
    }

    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> (int) (x.distance - y.distance));
    pq.add(new Pair(0, 0));
    long[] dist = new long[n];
    int[] ways = new int[n];
    for (int i = 0; i < n; i++) {
      dist[i] = Long.MAX_VALUE;
      ways[i] = 0;
    }
    dist[0] = 0;
    ways[0] = 1;
    while (pq.size() != 0) {
      Pair ele = pq.peek();
      pq.remove();
      int node = ele.node;
      long distance = ele.distance;

      for (Pair pair : adj.get(node)) {
        int adjNode = pair.node;
        long adjDist = pair.distance;
        if (adjDist + distance < dist[adjNode]) {
          dist[adjNode] = adjDist + distance;
          ways[adjNode] = ways[node];
          pq.add(new Pair(adjNode, adjDist + distance));
        } else if (adjDist + distance == dist[adjNode]) {
          ways[adjNode] = (ways[adjNode] + ways[node]);
        }
      }
    }
    return ways[n - 1];

  }

  public static void main(String[] args) {

    int n = 7;
    List<List<Integer>> roads = new ArrayList<>() {
      {
        add(new ArrayList<Integer>(Arrays.asList(0, 6, 7)));
        add(new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
        add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        add(new ArrayList<Integer>(Arrays.asList(1, 3, 3)));
        add(new ArrayList<Integer>(Arrays.asList(6, 3, 3)));
        add(new ArrayList<Integer>(Arrays.asList(3, 5, 1)));
        add(new ArrayList<Integer>(Arrays.asList(6, 5, 1)));
        add(new ArrayList<Integer>(Arrays.asList(2, 5, 1)));
        add(new ArrayList<Integer>(Arrays.asList(0, 4, 5)));
        add(new ArrayList<Integer>(Arrays.asList(4, 6, 2)));

      }
    };
    int ans = countPaths(n, roads);

    System.out.print(ans);
    System.out.println();
  }

}
