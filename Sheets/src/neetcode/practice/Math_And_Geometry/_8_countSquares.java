package neetcode.practice.Math_And_Geometry;

import java.util.ArrayList;

class CountSquares {
  public record Pair<K, V>(K key, V value) {}

  private ArrayList<Pair<Integer, Integer>> grid;

  public CountSquares() {
    this.grid = new ArrayList<>();
  }

  public void add(int[] point) {
    Pair<Integer, Integer> pt = new Pair<>(point[0], point[1]);
    this.grid.add(pt);
  }

  public int count(int[] point) {
    // 1. Find any points on the same x-coordinate
    // 2. For every match, the other two points have two possibilities ; Check if they exist
    // 3. Increase your count for every match
    int x = point[0], y = point[1];
    int idx = 0, n = this.grid.size();
    int cnt = 0;

    for (; idx < n; idx++) {
      Pair<Integer, Integer> curPoint = this.grid.get(idx);
      if (curPoint.key() == x && curPoint.value() != y) {
        int y2 = curPoint.value(), len = Math.abs(y2 - y);

        // Left side
        int x3 = x - len, y3 = y;
        int x4 = x - len, y4 = y2;
        int numberOfMatchingPointsA = 0, numberOfMatchingPointsB = 0;

        for (int i = 0; i < n; i++) {
          Pair<Integer, Integer> pt = this.grid.get(i);
          if (pt.key() == x3 && pt.value() == y3) numberOfMatchingPointsA++;
          if (pt.key() == x4 && pt.value() == y4) numberOfMatchingPointsB++;
        }

        cnt += numberOfMatchingPointsA * numberOfMatchingPointsB;

        // Right side
        x3 = x + len;
        x4 = x + len;
        numberOfMatchingPointsA = 0;
        numberOfMatchingPointsB = 0;

        for (int i = 0; i < n; i++) {
          Pair<Integer, Integer> pt = this.grid.get(i);
          if (pt.key() == x3 && pt.value() == y3) numberOfMatchingPointsA++;
          if (pt.key() == x4 && pt.value() == y4) numberOfMatchingPointsB++;
        }

        cnt += numberOfMatchingPointsA * numberOfMatchingPointsB;

      } else continue;
    }

    return cnt;
  }
}
