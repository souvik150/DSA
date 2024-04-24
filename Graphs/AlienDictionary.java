package Graphs;

import java.util.*;

public class AlienDictionary {
  public String alienOrder(String[] dict) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    int[] visited = new int[26];
    boolean[] isPresent = new boolean[26];
    for (String s : dict) {
      for (char ch : s.toCharArray()) {
        isPresent[ch - 'a'] = true;
      }
    }

    for (int i = 0; i < 26; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < dict.length - 1; i++) {
      String s1 = dict[i];
      String s2 = dict[i + 1];

      if (s1.length() > s2.length() && s1.startsWith(s2)) {
        return "";
      }
      int len = Math.min(s1.length(), s2.length());
      for (int ptr = 0; ptr < len; ptr++) {
        if (s1.charAt(ptr) != s2.charAt(ptr)) {
          adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
          break;
        }
      }
    }

    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < 26; i++) {
      if (isPresent[i] && visited[i] == 0) {
        if (!dfs(i, visited, st, adj)) {
          return "";
        }
      }
    }

    StringBuilder ans = new StringBuilder();
    while (!st.isEmpty()) {
      ans.append((char) (st.pop() + (int) 'a'));
    }

    return ans.toString();
  }

  public boolean dfs(int i, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> graph) {
    vis[i] = 1;
    for (int it : graph.get(i)) {
      if (vis[it] == 0) {
        if (!dfs(it, vis, st, graph)) {
          return false;
        }
      } else if (vis[it] == 1) {
        return false;
      }
    }
    vis[i] = 2;
    st.push(i);
    return true;
  }
}
