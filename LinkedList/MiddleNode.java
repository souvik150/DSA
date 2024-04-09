package LinkedList;

public class MiddleNode {
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
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

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    // head.next.next.next.next.next = new Node(6);

    Node middle = findMiddleNode(head);
    System.out.println(middle.data);
  }
}
