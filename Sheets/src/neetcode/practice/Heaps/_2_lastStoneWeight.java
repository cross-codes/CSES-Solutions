package neetcode.practice.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _2_lastStoneWeight {
  public static int lastStoneWeight(int[] stones) {
    Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int stone : stones) heap.add(stone);
    while (heap.size() > 1) {
      int x = heap.poll(), y = heap.poll();
      int res = Math.max(x, y) - Math.min(x, y);
      heap.add(res);
    }

    return (heap.size() > 0) ? heap.peek() : 0;
  }
}
