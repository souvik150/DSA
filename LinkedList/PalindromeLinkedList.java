package LinkedList;

public class PalindromeLinkedList {
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  static Node reverseList(Node head) {
    Node prev = head;
    Node curr = head.next;
    head.next = null;

    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }

  private static Node findMiddleNode(Node head) {
    Node node = head;
    Node slow = node.next;
    Node fast = node.next.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  static boolean isLLPalindrome(Node head) {
    Node middle = findMiddleNode(head);
    Node t2 = reverseList(middle);
    Node t1 = head;

    while (t2 != null) {
      if (t1.data != t2.data) {
        return false;
      }
      t1 = t1.next;
      t2 = t2.next;
    }

    return true;
  }

  public static void main(String[] args) {
    Node head = new Node(2);
    head.next = new Node(3);
    head.next.next = new Node(3);
    head.next.next.next = new Node(2);
    head.next.next.next.next = new Node(1);

    boolean res = isLLPalindrome(head);
    System.out.println(res);
  }
}
