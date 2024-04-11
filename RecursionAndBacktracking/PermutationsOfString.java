package RecursionAndBacktracking;

public class PermutationsOfString {
  private static void printArray(char[] a) {
    System.out.println(new String(a));
  }

  private static void swap(char[] a, int i, int j) {
    char temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  private static void permute(char[] a, int l, int r) {
    if (l == r) {
      printArray(a);
      return;
    }

    for (int i = l; i <= r; i++) {
      swap(a, i, l);
      permute(a, l + 1, r);
      swap(a, i, l);
    }
  }

  public static void main(String[] args) {
    String s = "ABC";
    char[] a = s.toCharArray();
    permute(a, 0, a.length - 1);
  }
}
