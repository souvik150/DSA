package RecursionAndBacktracking;

public class OccurenceOfStringInAnother {
  public static int countOccurencesHelper(String t, String s, int i) {
    if (i > s.length() - t.length()) {
      return 0;
    }

    int subProblemAns = countOccurencesHelper(t, s, i + 1);
    boolean checkStartingChars = s.substring(i, i + t.length()).equals(t);

    if (checkStartingChars) {
      return subProblemAns + 1;
    }
    return subProblemAns;
  }
}
