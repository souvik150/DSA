package StacksAndQueues;

import java.util.*;

public class SmallerElements {
  public static void main(String[] args) {
    int a[] = { 1, 4, 3, 2, 7, 9, 6, 4 };
    int ans[] = maxMinArray(a);

    for (int e : ans) {
      System.out.print(e + " ");
    }
  }

  static int[] maxMinArray(int a[]) {
    int n = a.length;
    int left[] = smallerOnLeft(a);
    int right[] = smallerOnRight(a);

    int ans[] = new int[n];
    Arrays.fill(ans, Integer.MIN_VALUE);

    for (int i = 0; i < n; i++) {
      int wl = right[i] - left[i] - 1;
      ans[wl - 1] = Math.max(ans[wl - 1], a[i]);
    }

    for (int i = n - 2; i >= 0; i--) {
      ans[i] = Math.max(ans[i], ans[i + 1]);
    }

    return ans;
  }

  static int[] smallerOnRight(int a[]) {
    int n = a.length;
    int ans[] = new int[n];

    ArrayDeque<Integer> stack = new ArrayDeque<>();

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
        stack.pop();
      }

      if (stack.isEmpty()) {
        ans[i] = n;
      } else {
        ans[i] = stack.peek();
      }
      stack.push(i);
    }
    return ans;
  }

  static int[] smallerOnLeft(int a[]) {
    int n = a.length;
    int ans[] = new int[n];

    ArrayDeque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < a.length; i++) {
      while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        ans[i] = -1;
      } else {
        ans[i] = stack.peek();
      }
      stack.push(i);
    }
    return ans;
  }
}
