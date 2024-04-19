package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
  public static void dfs(int i, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> graph) {
    vis[i] = 1;
    for (int it : graph.get(i)) {
      if (vis[it] == 0) {
        dfs(it, vis, st, graph);
      }
    }
    st.push(i);
  }

  public static int[] topoSort(ArrayList<ArrayList<Integer>> graph, int n) {
    Stack<Integer> st = new Stack<>();
    int[] vis = new int[n];

    for (int i = 0; i < n; i++) {
      if (vis[i] == 0) {
        dfs(i, vis, st, graph);
      }
    }

    int i = 0;
    int[] ans = new int[n];
    while (!st.isEmpty()) {
      ans[i++] = st.peek();
      st.pop();
    }

    return ans;
  }
}
