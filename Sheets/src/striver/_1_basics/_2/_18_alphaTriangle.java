package striver._1_basics._2;

public class _18_alphaTriangle {
  public static void alphaTriangle(int n) {
    int count = 1;
    for (int i = 0; i < n; count++, i++) {
      int num = 64 + n;
      for (int j = 0; j < count; j++, num--) {
        System.out.print((char) num + " ");
      }
      System.out.println();
    }
  }
}
