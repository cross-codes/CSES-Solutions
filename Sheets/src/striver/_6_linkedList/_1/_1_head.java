package striver._6_linkedList._1;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class _1_head {
  public static Node constructLL(int arr[]) {
    int n = arr.length;

    if (n == 0) return null;

    Node head = new Node(arr[0]);
    Node current = head;

    for (int idx = 1; idx < n; idx++) {
      current.next = new Node(arr[idx]);
      current = current.next;
    }

    return head;
  }
}
