package striver._6_linkedList._1;

class Node {
  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

public class _2_insertNode {
  public static Node insertAtBeginning(Node head, int x) {
    Node newNode = new Node(x);
    newNode.next = head;
    head = newNode;
    return head;
  }

  public static Node insertAtEnd(Node head, int x) {
    if (head == null) {
      return new Node(x);
    }

    Node current = head;
    while (current.next != null) current = current.next;
    Node newNode = new Node(x);
    current.next = newNode;
    return head;
  }
}
