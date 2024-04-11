package RecursionAndBacktracking;

import java.util.ArrayList;

public class PrintAllSubsequences {
  public static void printSubsequences(int[] arr, int index,
      ArrayList<Integer> res) {

    if (index == arr.length) {
      if (res.size() > 0)
        System.out.println(res);
    }

    else {
      printSubsequences(arr, index + 1, res);
      res.add(arr[index]);

      printSubsequences(arr, index + 1, res);
      res.remove(res.size() - 1);
    }
    return;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3 };
    ArrayList<Integer> res = new ArrayList<>();

    printSubsequences(arr, 0, res);
  }
}
