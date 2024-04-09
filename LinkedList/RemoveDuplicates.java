package LinkedList;

public class RemoveDuplicates {
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private static Node removeDuplicates(Node head) {
    if (head == null)
      return null;

    Node current = head;

    while (current != null && current.next != null) {
      if (current.data == current.next.data) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
    return head;
  }

  private static void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Node head = new Node(-1);
    head.next = new Node(-1);
    head.next.next = new Node(2);
    head.next.next.next = new Node(2);
    head.next.next.next.next = new Node(3);
    head.next.next.next.next.next = new Node(3);

    System.out.println("Original list:");
    printList(head);

    Node newHead = removeDuplicates(head);
    System.out.println("List after removing duplicates:");
    printList(newHead);
  }
}
