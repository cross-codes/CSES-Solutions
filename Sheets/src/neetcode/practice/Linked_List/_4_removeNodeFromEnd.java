package neetcode.practice.Linked_List;

public class _4_removeNodeFromEnd {
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || head.next == null) return null;
    ListNode marker = head, current = head, prev = null;

    for (int i = 1; i < n; i++) marker = marker.next;

    while (marker.next != null) {
      prev = current;
      current = current.next;
      marker = marker.next;
    }

    if (prev != null) {
      prev.next = current.next;
    } else {
      head = head.next;
    }
    return head;
  }
}
