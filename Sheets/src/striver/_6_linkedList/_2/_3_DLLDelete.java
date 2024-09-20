package striver._6_linkedList._2;

class Node {
  int data;
  Node next;
  Node prev;

  Node(int d) {
    this.data = d;
    next = prev = null;
  }
}

public class _3_DLLDelete {
  public static Node deleteNode(Node head, int x) {
    int count = 1;
    Node current = head;

    while (count < x && current != null) {
      current = current.next;
      count++;
    }

    if (current != null) {
      Node nextNode = current.next;
      Node prevNode = current.prev;
      if (nextNode != null) nextNode.prev = prevNode;
      if (prevNode != null) prevNode.next = nextNode;
      else head = nextNode;
    }

    return head;
  }
}
