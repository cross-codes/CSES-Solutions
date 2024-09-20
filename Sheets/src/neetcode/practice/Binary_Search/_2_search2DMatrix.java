package neetcode.practice.Binary_Search;

public class _2_search2DMatrix {
  public static boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    // Binary search with a translator
    int l = 0, r = m * n - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      int col = mid / n;
      int row = mid % n;
      if (matrix[col][row] < target) l = mid + 1;
      else if (matrix[col][row] > target) r = mid - 1;
      else return true;
    }

    return false;
  }
}
