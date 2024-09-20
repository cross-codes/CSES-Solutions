package neetcode.practice.Heaps;

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {
  private int k;
  private Queue<Integer> heap;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    this.heap = new PriorityQueue<>();

    for (int num : nums) {
      heap.add(num);
      if (heap.size() > this.k) heap.poll();
    }
  }

  public int add(int val) {
    heap.add(val);
    if (heap.size() > this.k) heap.poll();
    return heap.peek();
  }
}
