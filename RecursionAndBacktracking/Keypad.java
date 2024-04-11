package RecursionAndBacktracking;

import java.util.*;

public class Keypad {
  static void smartKeyPadHelper(String input, String[] map, int index, List<String> ans, String curr) {
    if (index == input.length()) {
      ans.add(curr);
      return;
    }
    int keypadNumber = input.charAt(index) - '0';
    String keyPadString = map[keypadNumber];

    for (int i = 0; i < keyPadString.length(); i++) {
      curr = curr + keyPadString.charAt(i);
      smartKeyPadHelper(input, map, index + 1, ans, curr);
      curr = curr.substring(0, curr.length() - 1);
    }
  }

  public static List<String> letterCombinations(String digits) {
    String map[] = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> ans = new ArrayList<>();
    smartKeyPadHelper(digits, map, 0, ans, "");
    return ans;
  }

  public static void main(String[] args) {
    String x = "23";
    List<String> res = letterCombinations(x);
    System.out.println(res);
  }
}
