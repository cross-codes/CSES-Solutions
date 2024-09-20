package neetcode.practice.Linked_List;

public class _7_detectCycle {
  public static boolean hasCycle(ListNode head) {
    if (head.next == null) return false;

    ListNode tortoise = head, hare = head;
    while (hare != null) {
      hare = hare.next.next;
      tortoise = tortoise.next;
      if (hare == tortoise) return true;
    }

    return false;
  }
}
