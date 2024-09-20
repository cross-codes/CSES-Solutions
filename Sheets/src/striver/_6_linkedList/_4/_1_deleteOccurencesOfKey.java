package striver._6_linkedList._4;

class Node {
  int data;
  Node next;
  Node prev;

  Node(int data) {
    this.data = data;
    this.next = this.prev = null;
  }
}

public class _1_deleteOccurencesOfKey {
  public static Node deleteAllOccurOfX(Node head, int x) {
    Node current = head;
    while (current.next != null) {
      if (current.data == x) {
        if (current.next != null) current.next.prev = current.prev;
        if (current.prev != null) current.prev.next = current.next;
        current = current.next;
      } else current = current.next;
    }

    Node newHead = current;

    if (current.data == x) {
      if (current.prev != null) {
        newHead = current.prev;
        current.prev.next = null;
      } else return null;
    }

    while (newHead.prev != null) newHead = newHead.prev;

    return newHead;
  }
}
