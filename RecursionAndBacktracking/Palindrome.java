package RecursionAndBacktracking;

public class Palindrome {
  static boolean result(String s, int start, int end) {
    while (start >= end) {
      return true;
    }

    if (s.charAt(start) != s.charAt(end)) {
      return false;
    }

    boolean res = result(s, start + 1, end - 1);
    return res;
  }

  static boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;

    boolean res = result(s, start, end);
    return res;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("null"));
    System.out.println(isPalindrome("abba"));

  }
}
