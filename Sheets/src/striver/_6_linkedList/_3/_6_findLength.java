package striver._6_linkedList._3;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class _6_findLength {
  public static int countNodesinLoop(Node head) {
    // Use the same logic from _5
    if (head == null || head.next == null) return 0;
    Node tortoise = head, hare = head, squid = head;
    boolean isCircular = false;

    while (hare != null && hare.next != null) {
      hare = hare.next.next;
      tortoise = tortoise.next;

      if (hare == tortoise) {
        while (squid != hare) {
          squid = squid.next;
          hare = hare.next;
        }
        isCircular = true;
        break;
      }
    }

    if (!isCircular) return 0;

    hare = hare.next;
    int count = 1;
    while (squid != hare) {
      hare = hare.next;
      count++;
    }

    return count;
  }
}
