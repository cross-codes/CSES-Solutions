package striver._3_arrays._2;

public class _11_setMatrixZeroes {
  public static void setZeroes(int[][] matrix) {
    // m -> Number of rows, n -> Number of columns
    // Rows are a downward traversal, columns are horizontal
    int m = matrix.length, n = matrix[0].length;
    boolean firstRowEdgeCase = false, firstColumnEdgeCase = false;

    // First iterate over every element.
    // If there is a zero, then use a marker in the first row, and the first column
    // The only exception is if the zero is in the first row and column itself
    // This case will be handled with boolean flags
    for (int row = 0; row < m; row++) {
      for (int column = 0; column < n; column++) {
        if (matrix[row][column] == 0) {
          if (row != 0 && column != 0) {
            matrix[0][column] = 0;
            matrix[row][0] = 0;
          }
          if (row == 0) firstRowEdgeCase = true;
          if (column == 0) firstColumnEdgeCase = true;
        }
      }
    }

    // Now, starting from the second row, if there is a marker
    // Iterate over every element in the row and set it to zero
    for (int row = 1; row < m; row++) {
      if (matrix[row][0] == 0) {
        for (int column = 0; column < n; column++) matrix[row][column] = 0;
      }
    }

    // Now, starting from the second column, if there is a marker
    // Iterate over every element in the column and set it to zero
    for (int column = 1; column < n; column++) {
      if (matrix[0][column] == 0) {
        for (int row = 0; row < m; row++) matrix[row][column] = 0;
      }
    }

    if (firstColumnEdgeCase) {
      for (int row = 0; row < m; row++) matrix[row][0] = 0;
    }

    if (firstRowEdgeCase) {
      for (int column = 0; column < n; column++) matrix[0][column] = 0;
    }
  }
}
