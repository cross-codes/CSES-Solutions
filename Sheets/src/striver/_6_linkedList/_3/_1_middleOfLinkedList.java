package striver._6_linkedList._3;

public class _1_middleOfLinkedList {
  public static ListNode middleNode(ListNode head) {
    ListNode tortoise = head, hare = head;

    while (hare != null && hare.next != null) {
      tortoise = tortoise.next;
      hare = hare.next.next;
    }

    return tortoise;
  }
}
