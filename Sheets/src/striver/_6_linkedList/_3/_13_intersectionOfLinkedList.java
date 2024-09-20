package striver._6_linkedList._3;

public class _13_intersectionOfLinkedList {
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode testA = headA, testB = headB;
    int m = 1, n = 1;

    while (testA.next != null) {
      testA = testA.next;
      m++;
    }

    while (testB.next != null) {
      testB = testB.next;
      n++;
    }

    ListNode currA = headA, currB = headB;

    if (m > n) {
      for (int i = 0; i < m - n; i++) currA = currA.next;
    } else if (m < n) {
      for (int i = 0; i < n - m; i++) currB = currB.next;
    }

    for (int i = 0; i < Math.min(m, n); i++) {
      if (currA == currB) return currA;
      currA = currA.next;
      currB = currB.next;
    }

    return null;
  }
}
