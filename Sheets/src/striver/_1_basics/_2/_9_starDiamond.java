package striver._1_basics._2;

public class _9_starDiamond {
  public static void nStarDiamond(int n) {
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

    spcCount = 0;
    starCount = 2 * n - 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < spcCount; j++) {
        System.out.print(" ");
      }
      spcCount += 1;
      for (int k = 0; k < starCount; k++) {
        System.out.print("*");
      }
      starCount -= 2;
      System.out.println();
    }
  }
}
