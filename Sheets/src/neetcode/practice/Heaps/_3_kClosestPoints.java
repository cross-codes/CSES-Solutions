package neetcode.practice.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _3_kClosestPoints {
  public static int[][] kClosest(int[][] points, int k) {
    Queue<int[]> heap =
        new PriorityQueue<>(
            new Comparator<int[]>() {
              @Override
              public int compare(int[] a, int[] b) {
                double dist1 = Math.pow(a[0], 2) + Math.pow(a[1], 2);
                double dist2 = Math.pow(b[0], 2) + Math.pow(b[1], 2);
                if (dist1 > dist2) return 1;
                else return -1;
              }
            });
    for (int[] point : points) heap.add(point);
    int[][] ans = new int[k][2];
    for (int i = 0; i < k; i++) ans[i] = heap.poll();
    return ans;
  }
}
