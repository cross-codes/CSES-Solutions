package striver._1_basics._2;

public class _13_increasingNumberTriangle {
  public static void nNumberTriangle(int n) {
    int count = 1;
    int num = 1;
    for (int i = 0; i < n; count++, i++) {
      for (int j = 1; j <= count; num++, j++) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }
}
