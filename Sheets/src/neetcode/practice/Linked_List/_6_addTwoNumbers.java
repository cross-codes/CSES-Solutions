package neetcode.practice.Linked_List;

public class _6_addTwoNumbers {
  static void reverse(char[] arr, int idxStart, int idxEnd) {
    for (; idxStart < idxEnd; idxStart++, idxEnd--) {
      char temp = arr[idxStart];
      arr[idxStart] = arr[idxEnd];
      arr[idxEnd] = temp;
    }
  }

  public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
    long n1 = 0, n2 = 0;

    ListNode current = head1;
    int k = 0;
    while (current != null) {
      n1 += current.val * Math.pow(10, k);
      k++;
      current = current.next;
    }

    current = head2;
    k = 0;

    while (current != null) {
      n2 += current.val * Math.pow(10, k);
      k++;
      current = current.next;
    }

    long ans = n1 + n2;
    char[] ansArray = String.valueOf(ans).toCharArray();
    int n = ansArray.length;
    reverse(ansArray, 0, n - 1);

    ListNode head = new ListNode(Character.getNumericValue(ansArray[0]));
    current = head;

    for (int i = 1; i < n; i++) {
      current.next = new ListNode(Character.getNumericValue(ansArray[i]));
      current = current.next;
    }

    return head;
  }
}
