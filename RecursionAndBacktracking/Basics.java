package RecursionAndBacktracking;

public class Basics {
  public int fibbanoci(int n) {
    int[] f = new int[n + 2];
    f[0] = 0;
    f[1] = 1;

    for (int i = 2; i <= n; i++) {
      f[i] = f[i - 1] + f[i - 2];
    }

    return f[n];
  }

  public static int nCr(int n, int r) {
    if (r > n) {
      return 0;
    }
    if (n == r || r == 0) {
      return 1;
    }
    return nCr(n - 1, r - 1) + nCr(n - 1, r);
  }
}
