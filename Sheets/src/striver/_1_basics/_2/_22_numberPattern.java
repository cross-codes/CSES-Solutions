package striver._1_basics._2;

public class _22_numberPattern {
  public static void getNumberPattern(int n) {
    int count = n, lowerBound = -1, numToPrint = n, timesToRepeat = -1;
    // First half
    for (int i = 0; i < n; i++) {
      lowerBound = n - i;
      for (int j = 0; j < count; j++) {
        if (numToPrint >= lowerBound) System.out.print(numToPrint);
        if (numToPrint == lowerBound) continue;
        else numToPrint--;
      }

      timesToRepeat = lowerBound;
      for (int k = 1; k < count; k++) {
        if (k < timesToRepeat) System.out.print(numToPrint);
        else {
          numToPrint++;
          System.out.print(numToPrint);
        }
      }
      numToPrint = n;
      System.out.println();
    }

    // Second half (reversed)
    for (int i = n; i > 1; i--) {
      lowerBound = n - i + 2;
      for (int j = 0; j < count; j++) {
        if (numToPrint >= lowerBound) System.out.print(numToPrint);
        if (numToPrint == lowerBound) continue;
        else numToPrint--;
      }

      timesToRepeat = lowerBound;
      for (int k = 1; k < count; k++) {
        if (k < timesToRepeat) System.out.print(numToPrint);
        else {
          numToPrint++;
          System.out.print(numToPrint);
        }
      }
      numToPrint = n;
      System.out.println();
    }
  }
}
