package striver._6_linkedList._4;

class Node {
  int data;
  Node next, prev;

  Node(int x) {
    this.data = x;
    this.next = this.prev = null;
  }
}

public class _3_removeDuplicates {
  public static Node removeDuplicates(Node head) {
    Node current = head;
    while (current.next != null) {
      if (current.next.data == current.data) {
        current.next.prev = current.prev;
        if (current.prev != null) current.prev.next = current.next;
      }
      current = current.next;
    }

    while (current.prev != null) {
      current = current.prev;
    }

    return current;
  }
}
