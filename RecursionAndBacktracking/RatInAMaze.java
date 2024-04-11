package RecursionAndBacktracking;

import java.util.ArrayList;

public class RatInAMaze {
  static boolean isValid(int i, int j, int[][] mat, boolean[][] vis, int n, int m) {
    return (i < n && i >= 0 && j < m && j >= 0 && mat[i][j] == 1 && !vis[i][j]);
  }

  static void helper(int[][] arr, boolean[][] vis, int i, int j, String path, int n, int m,
      ArrayList<String> res) {

    if (arr[0][0] == 0 || arr[n - 1][m - 1] == 0) {
      return;
    }

    if (i == n - 1 && j == m - 1) {
      res.add(path);
      return;
    }

    if (isValid(i + 1, j, arr, vis, n, m)) {
      vis[i + 1][j] = true;
      helper(arr, vis, i + 1, j, path + 'D', n, m, res);
      vis[i + 1][j] = false;
    }

    if (isValid(i, j - 1, arr, vis, n, m)) {
      vis[i][j - 1] = true;
      helper(arr, vis, i, j - 1, path + 'L', n, m, res);
      vis[i][j - 1] = false;
    }

    if (isValid(i, j + 1, arr, vis, n, m)) {
      vis[i][j + 1] = true;
      helper(arr, vis, i, j + 1, path + 'R', n, m, res);
      vis[i][j + 1] = false;
    }

    if (isValid(i - 1, j, arr, vis, n, m)) {
      vis[i - 1][j] = true;
      helper(arr, vis, i - 1, j, path + 'U', n, m, res);
      vis[i - 1][j] = false;
    }
  }

  public static ArrayList<String> findPath(int[][] arr, int n) {
    ArrayList<String> res = new ArrayList<>();
    boolean[][] vis = new boolean[n][n];
    vis[0][0] = true;

    helper(arr, vis, 0, 0, "", n, n, res);
    return res;
  }
}
