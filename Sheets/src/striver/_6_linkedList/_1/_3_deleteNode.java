package striver._6_linkedList._1;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

public class _3_deleteNode {
  public static void deleteNode(ListNode node) {
    // The previous pointer actually points to this very node
    // Hence, changing this node's value changes the previous pointer
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
