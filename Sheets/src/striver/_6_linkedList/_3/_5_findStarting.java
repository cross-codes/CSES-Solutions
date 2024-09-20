package striver._6_linkedList._3;

public class _5_findStarting {
  public static ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) return null;
    // If L is the length of the cycle, then the pointers
    // meet such that A_i = A_(i + kL)
    // But if the pointers move twice as fast, A_(i + kL) = A_2i
    // Hence, i = kL. Set the slow pointer back to the start,
    // and move all the pointers at the same pace. After some
    // number of loops (kL) the fast (now same pace) pointer and
    // the reset pointer will meet at i (= kL)
    ListNode hare = head, tortoise = head, squid = head;

    while (hare != null && hare.next != null) {
      hare = hare.next.next;
      tortoise = tortoise.next;

      if (tortoise == hare) {
        while (squid != hare) {
          squid = squid.next;
          hare = hare.next;
        }
        return squid;
      }
    }

    return null;
  }
}
