package striver._1_basics._2;

public class _5_seeding {
  public static void seeding(int n) throws Exception {
    int count = n;
    for (int i = 0; i < n; i++) {
      for (int j = count; j >= 1; j--) {
        System.out.print("* ");
      }
      System.out.println();
      count--;
    }
  }
}
