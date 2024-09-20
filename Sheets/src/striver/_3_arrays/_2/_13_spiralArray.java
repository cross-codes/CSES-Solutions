package striver._3_arrays._2;

import java.util.ArrayList;
import java.util.List;

public class _13_spiralArray {
  public static List<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> ans = new ArrayList<>();

    // Create four loops that are used to print horizontally and vertically
    // from the four corners of the square matrix

    int rowCount = matrix.length, colCount = matrix[0].length;
    int top = 0, bottom = rowCount - 1, left = 0, right = colCount - 1;

    while (top <= bottom && left <= right) {

      // Move left to right
      for (int idx = left; idx <= right; idx++) ans.add(matrix[top][idx]);
      top++;

      // Move top to bottom
      for (int idx = top; idx <= bottom; idx++) ans.add(matrix[idx][right]);
      right--;

      // Move right to left
      if (top <= bottom) {
        for (int idx = right; idx >= left; idx--) ans.add(matrix[bottom][idx]);
        bottom--;
      }

      // Move bottom to top
      if (left <= right) {
        for (int idx = bottom; idx >= top; idx--) ans.add(matrix[idx][left]);
        left++;
      }
    }

    return ans;
  }
}
