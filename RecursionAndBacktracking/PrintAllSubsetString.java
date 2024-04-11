package RecursionAndBacktracking;

public class PrintAllSubsetString {
  static void printAllSubsetsHelper(String s, int i, String curr) {
    if (i == s.length()) {
      System.out.println(curr);
      return;
    }

    // at any point we have 2 choices either include or dont include

    printAllSubsetsHelper(s, i + 1, curr + s.charAt(i)); // included the char
    printAllSubsetsHelper(s, i + 1, curr); // didnt include

    return;
  }

  public static void main(String[] args) {
    printAllSubsetsHelper("null", 0, "");
  }
}
