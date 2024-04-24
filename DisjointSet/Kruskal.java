package DisjointSet;

import java.util.*;

class Edge implements Comparable<Edge> {
  int src, dest, weight;

  Edge(int _src, int _dest, int _wt) {
    this.src = _src;
    this.dest = _dest;
    this.weight = _wt;
  }

  // comparator is used to srot the edges based on weight
  public int compareTo(Edge comparEdge) {
    return this.weight - comparEdge.weight;
  }
}

public class Kruskal {
  static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    List<Edge> edges = new ArrayList<Edge>();

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < adj.get(i).size(); i++) {
        int adjNode = adj.get(i).get(j).get(0);
        int wt = adj.get(i).get(j).get(1);
        Edge temp = new Edge(i, adjNode, wt);
        edges.add(temp);
      }
    }

    DisjointSet ds = new DisjointSet(V);
    Collections.sort(edges);
    int mstWt = 0;

    for (int i = 0; i < edges.size(); i++) {
      int wt = edges.get(i).weight;
      int u = edges.get(i).src;
      int v = edges.get(i).dest;

      if (ds.findUPar(v) != ds.findUPar(v)) {
        mstWt += wt;
        ds.unionBySize(u, v);
      }
    }

    return mstWt;
  }
}
