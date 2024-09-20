package striver._3_arrays._1;

public class _3_sortedAndRotated {
  public static boolean check(int[] nums) {
    // Try to find an inverse mapping from B -> A

    // B[(i+x) % B.length] = A[i]
    // x can range from 0 to B.length without overcounting
    int arrLength = nums.length, currentVal = Integer.MIN_VALUE, idx = -1;
    boolean check = false;
    for (int x = 0; x < arrLength; x++) {
      currentVal = Integer.MIN_VALUE;
      for (int i = 0; i < arrLength; i++) {
        idx = (i + x) % arrLength;
        if (currentVal <= nums[idx]) { // A[i]
          currentVal = nums[idx]; // Keep seeing if the elements of A are sorted
          check = true;
        } else {
          check = false; // Go to the next x value
          break;
        }
      }
      if (check) break; // Found a suitable value of x
    }
    return check;
  }
}
