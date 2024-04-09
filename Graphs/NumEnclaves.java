package Graphs;

public class NumEnclaves {
  void dfs(int row, int col, int[][] vis, int[][] grid, int[] delRow, int[] delCol) {
    vis[row][col] = 1;
    int n = grid.length;
    int m = grid[0].length;

    for (int i = 0; i < 4; i++) {
      int nrow = row + delRow[i];
      int ncol = col + delCol[i];

      if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
        dfs(nrow, ncol, vis, grid, delRow, delCol);
      }
    }
  }

  public int numberOfEnclaves(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    int[][] vis = new int[n][m];
    int[] delRow = { -1, 0, 1, 0 };
    int[] delCol = { 0, 1, 0, -1 };

    for (int i = 0; i < n; i++) {
      if (grid[i][0] == 1 && vis[i][0] == 0)
        dfs(i, 0, vis, grid, delRow, delCol);
      if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0)
        dfs(i, m - 1, vis, grid, delRow, delCol);
    }

    for (int j = 0; j < m; j++) {
      if (grid[0][j] == 1 && vis[0][j] == 0)
        dfs(0, j, vis, grid, delRow, delCol);
      if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0)
        dfs(n - 1, j, vis, grid, delRow, delCol);
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1 && vis[i][j] == 0)
          count++;
      }
    }

    return count;
  }
}
