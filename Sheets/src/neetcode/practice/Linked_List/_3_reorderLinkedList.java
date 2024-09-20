package neetcode.practice.Linked_List;

public class _3_reorderLinkedList {
  public static void reorderList(ListNode head) {
    ListNode current = head;
    int n = 1;

    while (current.next != null) {
      current = current.next;
      n++;
    }

    ListNode[] nodes = new ListNode[n];

    current = head;

    for (int i = 0; i < n; i++) {
      nodes[i] = current;
      current = current.next;
    }

    int i = 0, j = n - 1, step = 0;
    while (j > i) {
      if ((step & 1) == 0) {
        nodes[i].next = nodes[j];
        i++;
        step++;
      } else {
        nodes[j].next = nodes[i];
        j--;
        step++;
      }
    }

    nodes[i].next = null;
  }
}
