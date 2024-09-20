package striver._1_basics._2;

public class _6_reverseTriangle {
  public static void nNumberTriangle(int n) {
    int count = n;
    for (int i = 0; i < n; i++) {
      int num = 1;
      for (int j = count; j >= 1; j--) {
        System.out.print(num + " ");
        num++;
      }
      System.out.println();
      count--;
    }
  }
}
