package StacksAndQueues;

import java.util.*;

public class ReverseStack {
  public void addToBottom(Stack<Integer> s, int x) {
    if (s.isEmpty()) {
      s.push(x);
      return;
    }

    int z = s.peek();
    s.pop();
    addToBottom(s, x);

    s.push(z);
  }

  public void reverseStack(Stack<Integer> s) {
    if (!s.isEmpty()) {
      int x = s.peek();
      s.pop();
      reverseStack(s);
      addToBottom(s, x);
    }
  }
}
