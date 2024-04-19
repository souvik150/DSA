package Graphs;

import java.util.*;

public class CourseScheduling1 {
  public boolean isPossible(int V, int[][] prereq) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
    int m = prereq.length;
    for (int i = 0; i < m; i++) {
      adj.get(prereq[i][0]).add(prereq[i][1]);
    }

    int[] indegree = new int[V];
    for (int i = 0; i < V; i++) {
      for (int it : adj.get(i)) {
        indegree[it]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
      }
    }

    List<Integer> topo = new ArrayList<>();
    while (!q.isEmpty()) {
      int node = q.poll();
      topo.add(node);

      for (int it : adj.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0)
          q.offer(it);
      }
    }

    if (topo.size() == V)
      return true;
    return false;
  }
}
