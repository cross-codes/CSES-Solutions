package neetcode.practice.Linked_List;

import java.util.LinkedHashMap;
import java.util.Map;

class Node {
  int val;
  Node next, random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

public class _5_copyListWithRandomPointer {
  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new LinkedHashMap<>();
    map.put(null, null);

    Node current = head;

    while (current != null) {
      Node copy = new Node(current.val);
      map.put(current, copy);
      current = current.next;
    }

    current = head;

    while (current != null) {
      Node copy = map.get(current);
      copy.next = map.get(current.next);
      copy.random = map.get(current.random);
      current = current.next;
    }

    return map.get(head);
  }
}
