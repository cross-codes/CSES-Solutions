package striver._6_linkedList._1;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class _5_search {
  public static boolean searchKey(int n, Node head, int key) {
    if (head != null) {
      Node current = head;
      while (current != null) {
        if (current.data == key) return true;
        current = current.next;
      }
    }
    return false;
  }
}
