package striver._6_linkedList._3;

public class _8_oddEvenLinkedList {
  public static ListNode oddEvenList(ListNode head) {
    // Don't ever create a cycle, that's a lost cause
    if (head == null || head.next == null || head.next.next == null) return head;

    ListNode odd = head, even = head.next, evenHead = even;

    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }

    odd.next = evenHead;

    return head;
  }
}
