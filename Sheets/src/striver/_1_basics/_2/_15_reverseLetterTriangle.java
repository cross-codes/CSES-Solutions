package striver._1_basics._2;

public class _15_reverseLetterTriangle {
  public static void nLetterTriangle(int n) {
    int count = n;
    for (int i = 0; i < n; count--, i++) {
      int num = 65;
      for (int j = 0; j < count; num++, j++) {
        System.out.print((char) num + " ");
      }
      System.out.println();
    }
  }
}
