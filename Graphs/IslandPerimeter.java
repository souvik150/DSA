package Graphs;

import java.util.HashSet;
import java.util.Set;

public class IslandPerimeter {
  static int total;

  public static int islandPerimeter(int[][] grid) {
    total = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          Set<String> visited = new HashSet<>();
          visited.add(i + "," + j);
          dfs(grid, i, j, visited);
          return total;
        }
      }
    }
    return 0;
  }

  private static void dfs(int[][] grid, int row, int col, Set<String> visited) {
    int[] dRow = { 0, -1, 0, 1 };
    int[] dCol = { 1, 0, -1, 0 };
    int edges = 4;

    for (int i = 0; i < 4; i++) {
      int nrow = row + dRow[i];
      int ncol = col + dCol[i];
      if (0 <= nrow && nrow < grid.length && 0 <= ncol && ncol < grid[0].length && grid[nrow][ncol] == 1) {
        edges -= 1;
        if (!visited.contains(nrow + "," + ncol)) {
          visited.add(nrow + "," + ncol);
          dfs(grid, nrow, ncol, visited);
        }
      }
    }
    total += edges;
  }
}
