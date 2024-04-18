package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
  private static void partitionHelper(String s, ArrayList<ArrayList<String>> ans, ArrayList<String> curr, int index) {
    if (index == s.length()) {
      ans.add(new ArrayList<>(curr));
      return;
    }

    for (int i = index; i < s.length(); i++) {
      if (isPalindrome(s, index, i)) {
        curr.add(s.substring(index, i + 1));
        partitionHelper(s, ans, curr, i + 1);
        curr.remove(curr.size() - 1);
      }
    }
  }

  public List<List<String>> partition(String s) {
    ArrayList<ArrayList<String>> ans = new ArrayList<>();
    ArrayList<String> curr = new ArrayList<>();
    partitionHelper(s, ans, curr, 0);
    return new ArrayList<>(ans);
  }

  private static boolean isPalindrome(String s, int i, int j) {
    while (i <= j) {
      if (s.charAt(i) != s.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }
}
