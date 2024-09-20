package striver._1_basics._2;

public class _11_binaryNumberTriangle {
  public static void nBinaryTriangle(int n) {
    boolean idx = false;
    int count = 1;
    for (int i = 0; i < n; count++, i++) {
      if (count % 2 != 0) idx = !idx;
      for (int j = 0; j < count; j++) {
        System.out.print((idx) ? (1 + " ") : (0 + " "));
        idx = !idx;
      }
      System.out.println();
    }
  }
}
