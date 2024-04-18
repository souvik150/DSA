package RecursionAndBacktracking;

import java.util.*;

public class PrintSubsequenceArray {
  static ArrayList<ArrayList<Integer>> subsequenceArray(int[] a) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> curr = new ArrayList<>();
    Arrays.sort(a);
    subsequenceArrayHelper(a, ans, curr, 0);
    return ans;
  }

  static void subsequenceArrayHelper(int[] a, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur, int index) {
    ans.add(new ArrayList<>(cur));

    for (int i = index; i < a.length; i++) {
      cur.add(a[i]);
      subsequenceArrayHelper(a, ans, cur, i + 1);
      cur.remove(cur.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] a = { 4, 5, 7 };

    ArrayList<ArrayList<Integer>> ans = subsequenceArray(a);
    System.out.println(ans);
  }
}
