package Graphs;

import java.util.*;

class Pair {
  int first;
  int second;

  public Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }
}

public class NumberOfIslands {
  private static void bfs(int row, int col, int[][] vis, int[][] grid) {
    vis[row][col] = 1;
    Queue<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(row, col));

    int N = grid.length;
    int M = grid[0].length;

    // Directions: up, down, left, right
    int[] rowNbr = new int[] { -1, 1, 0, 0 };
    int[] colNbr = new int[] { 0, 0, -1, 1 };

    while (!queue.isEmpty()) {
      int currRow = queue.peek().first;
      int currCol = queue.peek().second;
      queue.poll();

      for (int k = 0; k < 4; k++) {
        int nextRow = currRow + rowNbr[k];
        int nextCol = currCol + colNbr[k];

        // Check if the new position is valid and not visited
        if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && grid[nextRow][nextCol] == 1
            && vis[nextRow][nextCol] == 0) {
          vis[nextRow][nextCol] = 1;
          queue.offer(new Pair(nextRow, nextCol));
        }
      }
    }
  }

  private static int NumOfIslands(int[][] grid) {
    int N = grid.length;
    int M = grid[0].length;
    int counter = 0;

    int[][] vis = new int[N][M];

    for (int row = 0; row < N; row++) {
      for (int col = 0; col < M; col++) {
        if (vis[row][col] == 0 && grid[row][col] == 1) {
          bfs(row, col, vis, grid);
          counter++;
        }
      }
    }

    return counter;
  }

  public static void main(String[] args) {
    int[][] grid = {
        { 0, 1, 1, 0 },
        { 0, 1, 1, 0 },
        { 0, 0, 1, 0 },
        { 0, 0, 0, 0 },
        { 1, 1, 0, 1 },
    };

    int numIslands = NumOfIslands(grid);
    System.out.println(numIslands);
  }
}
