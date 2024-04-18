package StacksAndQueues;

import java.util.*;

public class LargestRectHist {
  static class Pair {
    int index;
    int height;

    Pair(int index, int height) {
      this.index = index;
      this.height = height;
    }
  }

  public static int largestRectangleArea(int[] heights) {
    int largestArea = 0;
    Stack<Pair> stack = new Stack<>();
    int i = 0;
    for (i = 0; i < heights.length; i++) {
      // Ensure the stack is not empty and the current height is less than the height
      // of the top of the stack
      while (!stack.isEmpty() && stack.peek().height > heights[i]) {
        Pair top = stack.pop();
        // Calculate area with 'top.height' as the smallest (or minimum height) bar 'i'
        int width = stack.isEmpty() ? i : i - stack.peek().index - 1;
        largestArea = Math.max(largestArea, top.height * width);
      }
      stack.push(new Pair(i, heights[i]));
    }

    // Now pop the remaining bars from stack and calculate area with every popped
    // bar
    while (!stack.isEmpty()) {
      Pair top = stack.pop();
      int width = stack.isEmpty() ? i : i - stack.peek().index - 1;
      largestArea = Math.max(largestArea, top.height * width);
    }

    return largestArea;
  }

  public static void main(String[] args) {
    int[] heights = { 2, 1, 5, 6, 2, 3 };
    int area = largestRectangleArea(heights);
    System.out.println("Largest rectangle area: " + area);
  }
}
