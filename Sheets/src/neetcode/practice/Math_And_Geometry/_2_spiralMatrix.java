package neetcode.practice.Math_And_Geometry;

import java.util.ArrayList;
import java.util.List;

public class _2_spiralMatrix {
  static boolean converged(int[] topLeft, int[] topRight, int[] bottomRight, int[] bottomLeft) {
    return (topLeft[0] > bottomRight[0] || topRight[1] < bottomLeft[1]);
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    // Markers
    int[] topLeft = {0, 0};
    int[] topRight = {0, n - 1};
    int[] bottomRight = {m - 1, n - 1};
    int[] bottomLeft = {m - 1, 0};

    // Tracker
    boolean[][] truth = new boolean[m][n];

    ArrayList<Integer> res = new ArrayList<>();
    while (!converged(topLeft, topRight, bottomRight, bottomLeft)) {
      // One clockwise round
      int i = topLeft[0], j = bottomLeft[1];
      for (; j < topRight[1]; j++) {
        if (truth[i][j]) break;
        res.add(matrix[i][j]);
        truth[i][j] = true;
      }
      topLeft[0]++;

      for (; i < bottomRight[0]; i++) {
        if (truth[i][j]) break;
        res.add(matrix[i][j]);
        truth[i][j] = true;
      }
      topRight[1]--;

      for (; j > bottomLeft[1]; j--) {
        if (truth[i][j]) break;
        res.add(matrix[i][j]);
        truth[i][j] = true;
      }
      bottomRight[0]--;

      for (; i >= topLeft[0]; i--) {
        if (truth[i][j]) break;
        res.add(matrix[i][j]);
        truth[i][j] = true;
      }
      bottomLeft[1]++;
    }

    if (m == n && n != 2 && (m & 1) == 1 && (n & 1) == 1) res.add(matrix[m / 2][n / 2]);

    return res;
  }
}
