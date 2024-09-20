package striver._1_basics._2;

public class _12_numberCrown {
  public static void numberCrown(int n) {
    int spcCount = 2 * n - 2;
    int count = 1;
    for (int i = 0; i < n; count++, i++) {
      for (int j = 1; j <= count; j++) {
        System.out.print(j + " ");
      }
      for (int k = 0; k < spcCount; k++) {
        System.out.print(" ");
      }
      for (int l = count; l >= 1; l--) {
        System.out.print(l + " ");
      }
      System.out.println();
    }
  }
}
