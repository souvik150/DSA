package LinkedList;

public class InsertionPoint {

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      next = null;
    }
  }

  public static ListNode findIntersection(ListNode firstHead, ListNode secondHead) {
    int firstLength = getLength(firstHead);
    int secondLength = getLength(secondHead);

    int diff = Math.abs(firstLength - secondLength);

    if (firstLength > secondLength) {
      firstHead = advanceListByN(firstHead, diff);
    } else {
      secondHead = advanceListByN(secondHead, diff);
    }

    while (firstHead != null && secondHead != null) {
      if (firstHead == secondHead) {
        return firstHead;
      }
      firstHead = firstHead.next;
      secondHead = secondHead.next;
    }

    return null;
  }

  private static int getLength(ListNode head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }

  private static ListNode advanceListByN(ListNode head, int n) {
    while (head != null && n > 0) {
      head = head.next;
      n--;
    }
    return head;
  }
}
