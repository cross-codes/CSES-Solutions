package striver._6_linkedList._3;

public class _7_checkPalindrome {
  public static boolean isPalindrome(ListNode head) {
    if (head == null) return false;
    else if (head.next == null) return true;
    else if (head.next.next == null) return (head.val == head.next.val);

    // Reverse the second half
    ListNode hare = head, tortoise = head, squid = head;

    while (hare != null && hare.next != null) {
      hare = hare.next.next;
      tortoise = tortoise.next;
    }

    squid = tortoise; // Middle of the node

    ListNode nextNode = squid.next, nextToNext = null;
    if (nextNode != null) nextToNext = nextNode.next;
    boolean stop = false;
    squid.next = null;
    nextNode.next = squid;
    squid = nextNode;
    nextNode = nextToNext;

    if (nextToNext != null) nextToNext = nextToNext.next;
    else stop = true;

    while (!stop && nextToNext != null) {
      nextNode.next = squid;
      squid = nextNode;
      nextNode = nextToNext;
      nextToNext = nextToNext.next;
    }

    if (!stop) {
      nextNode.next = squid;
      squid = nextNode; // Head of the reversed list
    }

    tortoise = head;

    while (squid != null) {
      if (tortoise.val != squid.val) return false;
      tortoise = tortoise.next;
      squid = squid.next;
    }

    return true;
  }
}
