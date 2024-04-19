package Graphs;

import java.util.*;

public class CourseScheduling2 {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] prerequisite : prerequisites) {
      adj.get(prerequisite[1]).add(prerequisite[0]);
    }

    int[] indegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      for (int course : adj.get(i)) {
        indegree[course]++;
      }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
      }
    }

    int[] topo = new int[numCourses];
    int idx = 0;

    while (!q.isEmpty()) {
      int node = q.poll();
      topo[idx++] = node;

      for (int neighbor : adj.get(node)) {
        indegree[neighbor]--;
        if (indegree[neighbor] == 0) {
          q.offer(neighbor);
        }
      }
    }

    if (idx == numCourses) {
      return topo;
    }
    return new int[0];
  }
}
