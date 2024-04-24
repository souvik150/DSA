package Graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

class Pair {
  int first, second;

  Pair(int _first, int _second) {
    this.first = _first;
    this.second = _second;
  }
}

public class ShortestDirected {
  private static void topoSort(int node, ArrayList<ArrayList<Pair>> adj,
      int vis[], Stack<Integer> st) {

    vis[node] = 1;
    for (int i = 0; i < adj.get(node).size(); i++) {
      int v = adj.get(node).get(i).first;
      if (vis[v] == 0) {
        topoSort(v, adj, vis, st);
      }
    }
    st.add(node);
  }

  public static int[] shortestPath(int N, int M, int[][] edges) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      ArrayList<Pair> temp = new ArrayList<Pair>();
      adj.add(temp);
    }
    // We create a graph first in the form of an adjacency list.

    for (int i = 0; i < M; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int wt = edges[i][2];
      adj.get(u).add(new Pair(v, wt));
    }
    int vis[] = new int[N];

    // step 1 of algo
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < N; i++) {
      if (vis[i] == 0) {
        topoSort(i, adj, vis, st);
      }
    }

    // step 2 of algo
    int dist[] = new int[N];
    for (int i = 0; i < N; i++) {
      dist[i] = (int) (1e9);
    }

    dist[0] = 0;
    while (!st.isEmpty()) {
      int node = st.peek();
      st.pop();

      for (int i = 0; i < adj.get(node).size(); i++) {
        int v = adj.get(node).get(i).first;
        int wt = adj.get(node).get(i).second;

        if (dist[node] + wt < dist[v]) {
          dist[v] = wt + dist[node];
        }
      }
    }

    for (int i = 0; i < N; i++) {
      if (dist[i] == 1e9)
        dist[i] = -1;
    }
    return dist;
  }

  public static void main(String[] args) throws IOException {
    int n = 6, m = 7;
    int[][] edge = { { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 }, { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 }, { 5, 3, 1 } };
    int res[] = shortestPath(n, m, edge);
    for (int i = 0; i < n; i++) {
      System.out.print(res[i] + " ");
    }
    System.out.println();
  }
}
