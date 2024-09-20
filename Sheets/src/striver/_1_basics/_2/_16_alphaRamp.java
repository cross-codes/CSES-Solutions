package striver._1_basics._2;

public class _16_alphaRamp {
  public static void alphaRamp(int n) {
    int count = 1;
    int num = 65;
    for (int i = 0; i < n; count++, i++, num++) {
      for (int j = 0; j < count; j++) {
        System.out.print((char) num + " ");
      }
      System.out.println();
    }
  }
}
