package striver._6_linkedList._2;

class Node {
  int data;
  Node next;
  Node prev;

  Node(int data) {
    this.data = data;
    next = prev = null;
  }
}

public class _2_DLLinsert {
  public static void addNode(Node head_ref, int pos, int data) {
    Node current = head_ref;
    int count = 0;

    while (count != pos) {
      current = current.next;
      count++;
    }

    Node nextNode = current.next;

    current.next = new Node(data);
    current.next.prev = current;
    current.next.next = nextNode;
  }
}
