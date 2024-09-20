package striver._3_arrays._1;

public class _10_maxConsecutiveOnes {
  public static int findMaxConsecutiveOnes(int[] arr) {
    int count = 0, n = arr.length;
    if (n == 1) return (arr[0] == 1) ? 1 : 0;
    int maxConsecutive = -1;
    boolean prematureExit = false;
    for (int i = 0; i < n; i++) {
      if (arr[i] != 1) {
        if (count > maxConsecutive) maxConsecutive = count;
        count = 0;
        prematureExit = false;
      } else {
        count++;
        prematureExit = true;
      }
    }
    if (prematureExit && count > maxConsecutive) maxConsecutive = count;
    return maxConsecutive;
  }
}
