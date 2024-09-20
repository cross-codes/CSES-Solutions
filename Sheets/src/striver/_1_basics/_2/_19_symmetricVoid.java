package striver._1_basics._2;

public class _19_symmetricVoid {
  public static void symmetry(int n) {
    int count = 2 * n;
    int spcCount = 0;
    // First half
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

    // Second half
    count = 2;
    spcCount = 2 * n - 2;
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
  }

  public static void main(String[] args) {
    symmetry(6);
  }
}
