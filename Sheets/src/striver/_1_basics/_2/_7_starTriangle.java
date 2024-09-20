package striver._1_basics._2;

public class _7_starTriangle {
  public static void nStarTriangle(int n) {
    int spcCount = n - 1;
    int starCount = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < spcCount; j++) {
        System.out.print(" ");
      }
      spcCount -= 1;
      for (int k = 0; k < starCount; k++) {
        System.out.print("*");
      }
      starCount += 2;
      System.out.println();
    }
  }
}
