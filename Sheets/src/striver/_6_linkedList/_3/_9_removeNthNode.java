package striver._6_linkedList._3;

public class _9_removeNthNode {
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    // Case: 1 node
    if (head.next == null) return null;

    // Case: 2 nodes
    if (head.next.next == null) {
      if (n == 1) {
        head.next = null;
        return head;
      }
      if (n == 2) {
        head = head.next;
        return head;
      }
    }

    // Case: Else
    ListNode current = head, nextNode = head.next, nextToNext = head.next.next;
    ListNode squid = head;

    int currCount = 1;
    // First send squid n steps ahead. Then send the group and squid till squid reaches the end
    while (currCount++ < n) squid = squid.next;

    // If squid is at the end
    if (squid.next == null) {
      head = nextNode;
      return head;
    }

    while (squid.next.next != null) {
      squid = squid.next;
      current = current.next;
      nextNode = nextNode.next;
      nextToNext = nextToNext.next;
    }

    // Now current points to the node before the required node
    current.next = nextToNext;
    nextNode.next = null;
    return head;
  }
}
