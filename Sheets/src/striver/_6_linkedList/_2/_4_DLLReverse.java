package striver._6_linkedList._2;

class Node {
  int data;
  Node next, prev;

  Node(int data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

public class _4_DLLReverse {
  public static Node reverseDLL(Node head) {
    Node current = head;

    while (current.next != null) current = current.next;

    head = current;

    while (current != null) {
      Node prevNode = current.prev;
      Node nextNode = current.next;
      current.next = prevNode;
      current.prev = nextNode;
      current = current.next;
    }

    return head;
  }
}
