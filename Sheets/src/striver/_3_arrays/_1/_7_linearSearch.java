package striver._3_arrays._1;

public class _7_linearSearch {
  public static int linearSearch(int n, int num, int[] arr) {
    for (int i = 0; i < n; i++) if (arr[i] == num) return i;
    return -1;
  }
}
