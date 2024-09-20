package striver._6_linkedList._5;

public class _1_reverseNodesInKGroup {
  public static ListNode reverseKGroup(ListNode head, int k) {
    if (head.next == null) return head;

    ListNode end1 = head; // End of half to be reversed
    ListNode end2 = head; // End of next half to be reversed

    int currCount = 0; // Counter to place ends

    ListNode prev = null, curr = head, next = head.next; // Prongs

    while (true) {
      while (currCount < k) {
        currCount++;
        end1 = end1.next;
      }

      currCount = 0;
      end2 = end1;

      while (currCount < k && end2.next != null) {
        currCount++;
        end2 = end2.next;
      }
      currCount = 0;

      if (currCount != k) end2 = end1.next;

      curr.next = end2;
      prev = curr;
      curr = next;
      next = next.next;
      while (next != end1) {
        curr.next = prev;
        prev = curr;
        curr = next;
        next = next.next;
      }

      end1 = end1.next;
      currCount++;
      next.next = curr;
      prev = next.next;
      curr = end1;
      next = curr.next;
    }
  }
}
