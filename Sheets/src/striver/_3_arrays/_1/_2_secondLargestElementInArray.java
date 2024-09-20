package striver._3_arrays._1;

public class _2_secondLargestElementInArray {
  public static int[] getSecondOrderElements(int n, int[] arr) {
    int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
    int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      // Updating smallest and second smallest variables
      if (arr[i] < smallest) {
        secondSmallest = smallest;
        smallest = arr[i];
      } else if (arr[i] < secondSmallest && arr[i] > smallest) {
        secondSmallest = arr[i];
      }

      // Updating largest and second largest variables
      if (arr[i] > largest) {
        secondLargest = largest;
        largest = arr[i];
      } else if (arr[i] > secondLargest && arr[i] < largest) {
        secondLargest = arr[i];
      }
    }

    int[] ans = new int[2];
    ans[0] = secondLargest;
    ans[1] = secondSmallest;
    return ans;
  }
}
