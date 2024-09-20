package striver._6_linkedList._3;

import java.math.BigInteger;

public class _15_addTwoNumbers {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    BigInteger n1 = BigInteger.ZERO, n2 = BigInteger.ZERO;
    int digit1 = 0, digit2 = 0;

    ListNode current = l1;
    while (current != null) {
      n1 = n1.add(BigInteger.valueOf(current.val).multiply(BigInteger.valueOf(10).pow(digit1)));
      digit1++;
      current = current.next;
    }

    current = l2;
    while (current != null) {
      n2 = n2.add(BigInteger.valueOf(current.val).multiply(BigInteger.valueOf(10).pow(digit2)));
      digit2++;
      current = current.next;
    }

    String sum = n1.add(n2).toString(10);

    int n = sum.length();

    ListNode newHead = new ListNode(sum.charAt(n - 1) - '0');
    current = newHead;

    for (int i = n - 2; i >= 0; i--) {
      current.next = new ListNode(sum.charAt(i) - '0');
      current = current.next;
    }

    return newHead;
  }
}
