package DisjointSet;

import java.util.*;

public class NumberOfProvinces {
  static int numProvinces(int V, ArrayList<ArrayList<Integer>> graph) {
    int counter = 0;

    DisjointSet ds = new DisjointSet(V);
    for (int i = 0; i < V; i++) {
      for (int j = 0; i < V; j++) {
        if (graph.get(i).get(j) == 1) {
          ds.unionBySize(i, j);
        }
      }
    }

    for (int i = 0; i < V; i++) {
      if (ds.parent.get(i) == i)
        counter++;
    }

    return counter;
  }
}
