package striver._6_linkedList._4;

import java.util.ArrayList;

class Node {
  int data;
  Node next, prev;

  Node(int x) {
    this.data = x;
    this.next = this.prev = null;
  }
}

public class _2_findPairsWithSum {
  public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    // Set two pointers at the start and end
    // Use them because the DLL is already sorted

    Node pointerA = head;
    Node pointerB = head;
    int aPos = 0;
    int bPos = 0;

    while (pointerB.next != null) {
      pointerB = pointerB.next;
      bPos++;
    }

    while (aPos < bPos) {
      int val1 = pointerA.data, val2 = pointerB.data;
      if (val1 + val2 > target) {
        pointerB = pointerB.prev;
        bPos--;
        continue;
      }

      if (val1 + val2 < target) {
        pointerA = pointerA.next;
        aPos++;
        continue;
      }

      if (val1 + val2 == target) {
        ArrayList<Integer> pair = new ArrayList<>();
        pair.add(val1);
        pair.add(val2);
        ans.add(pair);
        pointerA = pointerA.next;
        aPos++;
        pointerB = pointerB.prev;
        bPos--;
        continue;
      }
    }

    return ans;
  }
}
