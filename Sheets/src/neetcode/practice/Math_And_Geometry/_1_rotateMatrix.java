package neetcode.practice.Math_And_Geometry;

public class _1_rotateMatrix {
  static void reverse(int[] arr, int idxStart, int idxEnd) {
    for (; idxStart < idxEnd; idxStart++, idxEnd--) {
      int temp = arr[idxStart];
      arr[idxStart] = arr[idxEnd];
      arr[idxEnd] = temp;
    }
  }

  public static void rotate(int[][] matrix) {
    int n = matrix.length;
    int cnt = 0;

    /**
     *
     *
     * <pre>
     * 00 -> 00
     * 01 -> 10     11 -> 11
     * 02 -> 20     12 -> 21
     * </pre>
     */
    for (int i = 0; i < n - 1; i++) {
      for (int j = cnt; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
      cnt++;
    }

    for (int i = 0; i < n; i++) reverse(matrix[i], 0, n - 1);
  }
}
