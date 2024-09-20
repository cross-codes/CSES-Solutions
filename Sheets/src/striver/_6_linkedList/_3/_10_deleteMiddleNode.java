package striver._6_linkedList._3;

public class _10_deleteMiddleNode {
  public static ListNode deleteMiddle(ListNode head) {
    if (head.next == null) return null;

    // Find the middle node using the hare, tortoise approach
    ListNode hare = head, tortoise = head, squid = null;

    while (hare != null && hare.next != null) {
      hare = hare.next.next;
      squid = tortoise;
      tortoise = tortoise.next;
    }

    // Now squid points to the pointer before tortoise
    squid.next = tortoise.next;
    return head;
  }
}
