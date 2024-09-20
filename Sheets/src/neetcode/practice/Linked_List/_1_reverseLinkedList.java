package neetcode.practice.Linked_List;

public class _1_reverseLinkedList {
  public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode prev = null, nextNode = head.next, current = head;
    while (nextNode != null) {
      current.next = prev;
      prev = current;
      current = nextNode;
      nextNode = nextNode.next;
    }
    current.next = prev;

    return current;
  }
}
