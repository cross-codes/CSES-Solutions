package neetcode.practice.Heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class _4_kthLargestElement {
  public static int findKthLargest(int[] nums, int k) {
    Queue<Integer> heap = new PriorityQueue<>();
    for (int num : nums) {
      heap.add(num);
      if (heap.size() > k) heap.poll();
    }
    return heap.peek();
  }
}
