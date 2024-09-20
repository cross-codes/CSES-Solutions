package neetcode.practice.Linked_List;

public class _2_mergeTwoSortdLists {
  public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
    if (head1 == null && head2 == null) return null;
    if (head1 == null && head2 != null) return head2;
    if (head1 != null && head2 == null) return head1;

    ListNode current = null, up = head1, down = head2;
    if (up.val < down.val) {
      current = up;
      up = up.next;
    } else {
      current = down;
      down = down.next;
    }

    ListNode ans = current;

    while (up != null || down != null) {
      if (up == null) {
        current.next = down;
        down = down.next;
        current = current.next;
      } else if (down == null) {
        current.next = up;
        up = up.next;
        current = current.next;
      } else if (up.val < down.val) {
        current.next = up;
        up = up.next;
        current = current.next;
      } else {
        current.next = down;
        down = down.next;
        current = current.next;
      }
    }

    return ans;
  }
}
