package striver._1_basics._2;

public class _1_nForest {
  public static void nForest(int n) {
    for (int i = 0; i < n * n; i++) {
      System.out.print("* ");
      if ((i + 1) % n == 0) {
        System.out.println();
      }
    }
  }
}
