package striver._6_linkedList._2;

class Node {
  Node prev;
  int val;
  Node next;

  Node(int d) {
    val = d;
    prev = null;
    next = null;
  }
}

public class _1_DLLHead {
  Node constructDLL(int arr[]) {
    int n = arr.length;

    if (n == 0) return null;

    Node head = new Node(arr[0]);
    Node current = head;

    for (int idx = 1; idx < n; idx++) {
      current.next = new Node(arr[idx]);
      current.next.prev = current;
      current = current.next;
    }

    return head;
  }
}
