package neetcode.practice.Heaps;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.WeakHashMap;

public class _5_taskScheduling {
  public record Pair<K, V>(K key, V value) {}

  public static int leastInterval(char[] tasks, int n) {
    // Always try to complete the most frequent elements
    Map<Character, Integer> freq = new WeakHashMap<>();

    // Calculate frequencies
    for (char task : tasks) freq.put(task, freq.getOrDefault(task, 0) + 1);

    // Store all the frequencies in a PriorityQueue in decreasing order
    Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
    heap.addAll(freq.values());

    int time = 0;
    // A place to store tasks that cannot be processed due to the cycles
    // Stores pairs of frequencies and times when they can go back. Should be FIFO
    Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();

    while (!(heap.isEmpty() && queue.isEmpty())) {
      time++;

      if (!heap.isEmpty()) {
        int frequency = heap.poll() - 1;
        if (frequency > 0) queue.add(new Pair<>(frequency, time + n));
      }

      if (!queue.isEmpty() && queue.peekFirst().value() == time) heap.add(queue.poll().key());
    }

    return time;
  }
}
