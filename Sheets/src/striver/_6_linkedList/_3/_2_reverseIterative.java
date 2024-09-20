package striver._6_linkedList._3;

public class _2_reverseIterative {
  public static ListNode reverseList(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;

    ListNode current, next, nextToNext;

    current = head;
    next = current.next;
    if (next != null) nextToNext = current.next.next;
    else nextToNext = null;

    current.next = null;
    next.next = current;
    current = next;
    next = nextToNext;

    if (nextToNext != null) {
      nextToNext = nextToNext.next;
    } else return current;

    while (nextToNext != null) {
      next.next = current;
      current = next;
      next = nextToNext;
      nextToNext = nextToNext.next;
    }

    next.next = current;
    current = next;
    return current;
  }
}
