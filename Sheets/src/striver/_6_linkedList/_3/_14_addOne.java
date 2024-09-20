package striver._6_linkedList._3;

class Node {
  int data;
  Node next;

  Node(int x) {
    this.data = x;
    this.next = null;
  }
}

public class _14_addOne {

  static boolean isPosANine(Node head, int pos) {
    Node current = head;
    int currPos = 1;
    while (currPos < pos) {
      current = current.next;
      currPos++;
    }

    return (current.data == 9);
  }

  static Node addOneToPos(Node head, int pos) {
    Node current = head;
    int currPos = 1;
    while (currPos < pos) {
      current = current.next;
      currPos++;
    }

    if (current.data < 9) current.data++;
    else current.data = 0;

    return head;
  }

  public static Node addOne(Node head) {
    Node current = head;
    int n = 1;

    while (current.next != null) {
      current = current.next;
      n++;
    }

    // If the end is a digit from 0 - 8
    if (current.data < 9) {
      current.data++;
      return head;
    } else {
      // The digit is a 9
      while (isPosANine(head, n) && n > 0) {
        addOneToPos(head, n);
        n--;
      }

      if (!isPosANine(head, n) && n > 0) {
        addOneToPos(head, n);
        return head;
      } else if (n == 0) {
        Node newHead = new Node(1);
        newHead.next = head;
        return newHead;
      }
    }
    return null;
  }
}
