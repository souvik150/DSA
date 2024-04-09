package Graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NearestCellOne {
  static class Node {
    int first;
    int second;
    int dist;

    Node(int first, int second, int dist) {
      this.first = first;
      this.second = second;
      this.dist = dist;
    }
  }

  public int[][] nearest(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[][] vis = new int[n][m];
    int[][] dist = new int[n][m];

    Queue<Node> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          q.offer(new Node(i, j, 0));
          vis[i][j] = 1;
        } else {
          vis[i][j] = 0;
        }
      }
    }

    int[] drow = { -1, 0, 1, 0 };
    int[] dcol = { 0, 1, 0, -1 };

    while (!q.isEmpty()) {
      Node node = q.poll();
      int row = node.first;
      int col = node.second;
      int steps = node.dist;

      dist[row][col] = steps;
      for (int i = 0; i < 4; i++) {
        int nrow = row + drow[i];
        int ncol = col + dcol[i];

        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
          vis[nrow][ncol] = 1;
          q.add(new Node(nrow, ncol, steps + 1));
        }
      }
    }

    return dist;
  }
}
