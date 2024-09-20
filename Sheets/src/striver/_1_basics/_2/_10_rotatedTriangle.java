package striver._1_basics._2;

public class _10_rotatedTriangle {
  public static void nStarTriangle(int n) {
    int count = 1;
    for (int i = 0; i < n; count++, i++) {
      for (int j = 0; j < count; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    count = n - 1;
    for (int i = 0; i < n - 1; count--, i++) {
      for (int j = 0; j < count; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
