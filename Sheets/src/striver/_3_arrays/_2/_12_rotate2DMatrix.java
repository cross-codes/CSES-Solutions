package striver._3_arrays._2;

public class _12_rotate2DMatrix {
  static void reverse(int[] arr, int idxStart, int idxEnd) {
    for (; idxStart < idxEnd; idxStart++, idxEnd--) {
      int temp = arr[idxStart];
      arr[idxStart] = arr[idxEnd];
      arr[idxEnd] = temp;
    }
  }

  public static void rotate(int[][] matrix) {
    int n = matrix.length;

    // Rotation = Transpose + Reverse
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    for (int idx = 0; idx < n; idx++) reverse(matrix[idx], 0, n - 1);
  }
}
