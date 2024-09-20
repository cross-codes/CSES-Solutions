package striver._6_linkedList._3;

import java.util.Arrays;

public class _11_sortList {
  public static ListNode sortList(ListNode head) {
    if (head == null) return null;

    ListNode test = head;
    int n = 1;
    while (test.next != null) {
      test = test.next;
      n++;
    }

    int[] linkedList = new int[n];
    ListNode squid = head;

    for (int idx = 0; idx < n; idx++) {
      linkedList[idx] = squid.val;
      squid = squid.next;
    }

    Arrays.sort(linkedList);

    head = new ListNode(linkedList[0]);
    ListNode current = head;

    for (int idx = 1; idx < n; idx++) {
      current.next = new ListNode(linkedList[idx]);
      current = current.next;
    }

    return head;
  }
}
