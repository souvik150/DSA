package RecursionAndBacktracking;

public class GnerateParenthesis {
  public static void main(String[] args) {
    int n = 3;
    generateParenthesis(n, "", 0, 0, 0);
  }

  static void generateParenthesis(int n, String curr, int i, int open, int close) {
    if (i == 2 * n) {
      System.out.println(curr);
      return;
    }

    if (open < n) {
      curr = curr + '(';
      generateParenthesis(n, curr, i + 1, open + 1, close);
      curr = curr.substring(0, curr.length() - 1);
    }

    if (close < open) {
      curr = curr + ')';
      generateParenthesis(n, curr, i + 1, open, close + 1);
    }
  }
}
