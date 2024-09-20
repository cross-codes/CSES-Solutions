package neetcode.practice.Arrays;

public class _8_validSudoku {
  static boolean rowValidator(char[][] board, int rowNum) {
    int[] freq = new int[9];
    for (int i = 0; i < 9; i++) {
      char c = board[rowNum][i];
      if (c == '.') continue;
      else if (Character.isDigit(c)) {
        if (freq[c - '1'] == 1) return false;
        else freq[c - '1']++;
      }
    }

    return true;
  }

  static boolean columnValidator(char[][] board, int colNum) {
    int[] freq = new int[9];
    for (int i = 0; i < 9; i++) {
      char c = board[i][colNum];
      if (c == '.') continue;
      else if (Character.isDigit(c)) {
        if (freq[c - '1'] == 1) return false;
        else freq[c - '1']++;
      }
    }

    return true;
  }

  static boolean gridValidator(char[][] board, int upperLeftColNum, int upperLeftRowNum) {
    int[] freq = new int[9];
    for (int rowIterator = upperLeftRowNum; rowIterator < upperLeftRowNum + 3; rowIterator++) {
      for (int colIterator = upperLeftColNum; colIterator < upperLeftColNum + 3; colIterator++) {
        char c = board[rowIterator][colIterator];
        if (c == '.') continue;
        else if (Character.isDigit(c)) {
          if (freq[c - '1'] == 1) return false;
          else freq[c - '1']++;
        }
      }
    }

    return true;
  }

  public static boolean isValidSudoku(char[][] board) {
    // Check if all the rows contain 1 - 9 characters without duplicates
    boolean res;
    for (int i = 0; i < 9; i++) {
      res = rowValidator(board, i);
      if (!res) return false;
    }

    // Check if all the columns contain 1 - 9 characters without duplicates
    for (int i = 0; i < 9; i++) {
      res = columnValidator(board, i);
      if (!res) return false;
    }

    // Check if 3x3 grids contain 1 - 9 characters without duplicates
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        res = gridValidator(board, i, j);
        if (!res) return false;
      }
    }

    return true;
  }
}
