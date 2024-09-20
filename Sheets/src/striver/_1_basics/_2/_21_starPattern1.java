package striver._1_basics._2;

public class _21_starPattern1 {
  public static void getStarPattern(int n) {
    int count = n;
    int spcCount = n - 2;
    for (int i = 0; i < count; i++) {
      System.out.print("*");
    }
    System.out.println();
    for (int j = 0; j < n - 2; j++) {
      System.out.print("*");
      for (int l = 0; l < spcCount; l++) {
        System.out.print(" ");
      }
      System.out.println("*");
    }
    if (count == 1) {
      System.out.println();
    } else {
      for (int i = 0; i < count; i++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    getStarPattern(3);
  }
}
