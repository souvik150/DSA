package Graphs;

public class FloodFillAlgo {
  private static void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int[] delRow, int[] delCol,
      int initColor) {
    ans[row][col] = newColor;
    int n = image.length;
    int m = image[0].length;

    for (int i = 0; i < 4; i++) {
      int nrow = row + delRow[i];
      int ncol = col + delCol[i];
      if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initColor
          && ans[nrow][ncol] != newColor) {
        dfs(nrow, ncol, ans, image, newColor, delRow, delCol, initColor);
      }
    }
  }

  public static int[][] floodFill(int[][] arr, int sr, int sc, int newColor) {
    int initColor = arr[sr][sc];
    // Creating a deep copy of image to ans
    int[][] image = new int[arr.length][];
    for (int i = 0; i < arr.length; i++) {
      image[i] = arr[i].clone();
    }
    int[] delRow = { -1, 0, 1, 0 };
    int[] delCol = { 0, 1, 0, -1 };
    dfs(sr, sc, image, arr, newColor, delRow, delCol, initColor);
    return image;
  }

  public static void main(String[] args) {
    int[][] arr = {
        { 1, 1, 1 },
        { 1, 1, 0 },
        { 1, 0, 1 }
    };
    int sr = 1, sc = 1, newColor = 2;
    int[][] filledImage = floodFill(arr, sr, sc, newColor);
    for (int[] row : filledImage) {
      for (int pixel : row) {
        System.out.print(pixel + " ");
      }
      System.out.println();
    }
  }
}
