package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
  static ArrayList<ArrayList<Integer>> combinationSum(int[] a, int sum) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> curr = new ArrayList<>();
    Arrays.sort(a);
    combinationSumHelper(a, sum, ans, curr, 0);
    return ans;
  }

  static void combinationSumHelper(int[] a, int sum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur,
      int index) {
    if (sum < 0) {
      return;
    }

    if (sum == 0) {
      ans.add(new ArrayList<>(cur));
      return;
    }

    for (int i = index; i < a.length; i++) {
      cur.add(a[i]);
      combinationSumHelper(a, sum - a[i], ans, cur, i + 1);
      cur.remove(cur.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] a = { 8, 1, 3, 7, 2, 1, 5 };
    int sum = 12;

    ArrayList<ArrayList<Integer>> ans = combinationSum(a, sum);
    System.out.println(ans);
  }
}
