package striver._1_basics._2;

public class _2_nHalfForest {
  public static void nForest(int n) {
    int count = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < count; j++) {
        System.out.print("* ");
      }
      System.out.println();
      count++;
    }
  }
}
