package striver._1_basics._2;

public class _20_symmetry {
  public static void symmetry(int n) {
    int count = 2;
    int spcCount = 2 * n - 2;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < count / 2; j++) {
        System.out.print("* ");
      }
      for (int k = 0; k < spcCount; k++) {
        System.out.print(" ");
      }
      for (int l = 0; l < count / 2; l++) {
        System.out.print("* ");
      }
      System.out.println();
      spcCount -= 2;
      count += 2;
    }

    count = 2 * n - 2;
    spcCount = 2;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < count / 2; j++) {
        System.out.print("* ");
      }
      for (int k = 0; k < spcCount; k++) {
        System.out.print(" ");
      }
      for (int l = 0; l < count / 2; l++) {
        System.out.print("* ");
      }
      System.out.println();
      spcCount += 2;
      count -= 2;
    }
  }
}
