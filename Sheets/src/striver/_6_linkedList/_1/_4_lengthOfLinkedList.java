package striver._6_linkedList._1;

class Node {
  int data;
  Node next;

  Node(int a) {
    data = a;
    next = null;
  }
}

public class _4_lengthOfLinkedList {
  public static int getCount(Node head) {
    int count = 0;
    Node current = head;

    if (current != null) {
      while (current != null) {
        current = current.next;
        count++;
      }
    }
    return count;
  }
}
