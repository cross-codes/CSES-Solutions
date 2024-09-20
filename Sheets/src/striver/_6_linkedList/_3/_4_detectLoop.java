package striver._6_linkedList._3;

public class _4_detectLoop {
  public static boolean hasCycle(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) return false;

    ListNode tortoise = head, hare = head;

    while (hare != null && hare.next != null) {
      hare = hare.next.next;
      tortoise = tortoise.next;

      if (hare == tortoise) return true;
    }

    return false;
  }
}
