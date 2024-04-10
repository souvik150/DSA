package LinkedList;

public class LongestPaindromeList {

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      next = null;
    }
  }

  public int maxPalindrome(ListNode head) {
    if (head == null)
      return 0;
    if (head.next == null)
      return 1;

    ListNode prev = null;
    ListNode curr = head;
    ListNode next;
    int maxLen = 0;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;

      int oddLengthMatch = longestMatchingLL(prev, next);
      int oddLength = 2 * oddLengthMatch + 1;
      maxLen = Math.max(maxLen, oddLength);

      int evenLengthMatch = longestMatchingLL(curr, next);
      int evenLength = 2 * evenLengthMatch;
      maxLen = Math.max(maxLen, evenLength);

      prev = curr;
      curr = next;
    }

    return maxLen;
  }

  public int longestMatchingLL(ListNode a, ListNode b) {
    int count = 0;
    while (a != null && b != null) {
      if (a.val == b.val) {
        count++;
        a = a.next;
        b = b.next;
      } else {
        break;
      }
    }
    return count;
  }
}
