package neetcode.practice.Math_And_Geometry;

public class _3_setZeroes {
  static void destroyRowAndColumn(int[][] matrix, int i, int j, int m, int n) {
    for (int beam = 0; beam < n; beam++) matrix[i][beam] = 0;
    for (int beam = 0; beam < m; beam++) matrix[beam][j] = 0;
  }

  public static void setZeroes(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    boolean[][] complement = new boolean[m][n];

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++) if (matrix[i][j] == 0) complement[i][j] = true;

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++) if (complement[i][j]) destroyRowAndColumn(matrix, i, j, m, n);
  }
}
