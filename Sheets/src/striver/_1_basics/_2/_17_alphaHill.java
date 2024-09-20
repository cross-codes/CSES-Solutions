package striver._1_basics._2;

public class _17_alphaHill {
  public static void alphaHill(int n) {
    int letterCount = 1;
    int spcCount = n - 1;
    for (int i = 0; i < n; i++, letterCount++, spcCount--) {
      int num = 65;
      for (int j = 0; j < spcCount; j++) {
        System.out.print(" ");
      }
      for (int k = 0; k < letterCount; k++, num++) {
        System.out.print((char) num + " ");
      }
      num -= 2;
      for (int l = 0; l < letterCount - 1; l++, num--) {
        System.out.print((char) num + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    alphaHill(3);
  }
}
