package Graphs;

import java.util.*;

public class PathWithMinEffort {
  static class Node {
    int effort;
    int x;
    int y;

    Node(int effort, int x, int y) {
      this.effort = effort;
      this.x = x;
      this.y = y;
    }
  }

  static int minEffort(int[][] heights) {
    PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.effort - y.effort);

    int n = heights.length;
    int m = heights[0].length;
    int[][] dist = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dist[i][j] = Integer.MAX_VALUE;
      }
    }
    dist[0][0] = 0;
    pq.add(new Node(0, 0, 0));

    int[] dCol = { -1, 0, 1, 0 };
    int[] dRow = { 0, 1, 0, -1 };

    while (pq.size() != 0) {
      Node it = pq.remove();
      int diff = it.effort;
      int row = it.x;
      int col = it.y;

      if (row == n - 1 && col == m - 1)
        return diff;

      for (int i = 0; i < 4; i++) {
        int newRow = row + dRow[i];
        int newCol = col + dCol[i];

        if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
          int newEffort = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), diff);

          if (newEffort < dist[newRow][newCol]) {
            dist[newRow][newCol] = newEffort;
            pq.add(new Node(newEffort, newRow, newRow));
          }
        }
      }
    }
    return 0;
  }
}
