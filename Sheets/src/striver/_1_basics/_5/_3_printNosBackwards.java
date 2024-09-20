package striver._1_basics._5;

public class _3_printNosBackwards {
  public static void populateArray(int[] arr, int idx) {
    if (idx < arr.length) {
      arr[idx] = idx + 1;
      populateArray(arr, ++idx);
    }
  }

  public static void reverse(int[] arr, int length) {
    int temp;
    for (int i = 0; i < length / 2; i++) {
      temp = arr[i];
      arr[i] = arr[length - i - 1];
      arr[length - i - 1] = temp;
    }
  }

  public static int[] printNos(int x) {
    int[] numbers = new int[x];
    populateArray(numbers, 0);
    reverse(numbers, numbers.length);
    return numbers;
  }
}
