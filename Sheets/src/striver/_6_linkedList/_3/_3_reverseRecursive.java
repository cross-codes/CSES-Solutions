package striver._6_linkedList._3;

public class _3_reverseRecursive {
  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode newHead = reverseList(head.next);

    ListNode front = head.next;
    front.next = head;
    head.next = null;

    return newHead;
  }
}
