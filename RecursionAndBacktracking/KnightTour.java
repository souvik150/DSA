package RecursionAndBacktracking;

public class KnightTour {

  private static boolean isValid(int n, int m, int[][] a, int x, int y) {
    return (x >= 0 && y >= 0 && x < n && y < m && a[x][y] == -1);
  }

  private static boolean knightTourHelper(int n, int[][] arr, int[] movesX, int[] movesY, int curX, int curY,
      int step) {
    if (step == n * n)
      return true;

    for (int i = 0; i < 8; i++) {
      int nextX = curX + movesX[i];
      int nextY = curY + movesY[i];
      if (isValid(n, n, arr, nextX, nextY)) {
        arr[nextX][nextY] = step;
        boolean tourCompleted = knightTourHelper(n, arr, movesX, movesY, nextX, nextY, step + 1);
        if (tourCompleted) {
          return true;
        } else {
          arr[nextX][nextY] = -1;
        }
      }
    }

    return false;

  }

  public static int[][] knightTour(int n) {
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = -1;
      }
    }

    arr[0][0] = 0;
    int[] movesX = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int[] movesY = { 1, 2, 2, 1, -1, -2, -2, -1 };

    knightTourHelper(n, arr, movesX, movesY, 0, 0, 1);

    return arr;
  }

  public static void main(String[] args) {

    int n = 5;
    int[][] arr = knightTour(n);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}
