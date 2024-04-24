package Graphs;

import java.util.*;

public class ShortestDistBinaryMaze {
  static class Node {
    int distance;
    int x;
    int y;

    Node(int dis, int x, int y) {
      this.distance = dis;
      this.x = x;
      this.y = y;
    }
  }

  static int shortestPath(int[][] grid, int[] source, int[] destination) {
    if (source[0] == destination[0] && source[1] == destination[1]) {
      return 0;
    }

    Queue<Node> q = new LinkedList<>();
    int n = grid.length;
    int m = grid[0].length;

    int[][] dist = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dist[i][j] = Integer.MAX_VALUE;
      }
    }

    dist[source[0]][source[1]] = 0;
    q.add(new Node(0, source[0], source[1]));
    int[] dRow = { -1, 0, 1, 0 };
    int[] dCol = { 0, 1, 0, -1 };

    while (!q.isEmpty()) {
      Node it = q.peek();
      q.remove();

      int dis = it.distance;
      int r = it.x;
      int c = it.y;

      for (int i = 0; i < 4; i++) {
        int newr = r + dRow[i];
        int newc = c + dCol[i];

        if (newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {
          dist[newr][newc] = 1 + dis;
          if (newr == destination[0] && newc == destination[1])
            return dis + 1;

          q.add(new Node(1 + dis, newr, newc));
        }
      }
    }

    return -1;
  }
}
