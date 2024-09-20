package striver._1_basics._2;

public class _3_nTriangles {
  public static void nTriangle(int n) {
    int count = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= count; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
      count++;
    }
  }
}
