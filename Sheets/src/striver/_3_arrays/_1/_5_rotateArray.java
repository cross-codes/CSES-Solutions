package striver._3_arrays._1;

public class _5_rotateArray {
  public static int swapStore(int x, int[] arr, int idx) {
    int temp2 = arr[idx];
    arr[idx] = x;
    return temp2;
  }

  public static void rotateOnce(int[] arr, int length) {
    int temp = arr[length - 1];
    int idxTemp = arr[0];
    for (int i = 0; i < length - 1; i++) {
      idxTemp = swapStore(idxTemp, arr, i + 1);
    }
    arr[0] = temp;
  }

  public static void rotateBad(int[] arr, int k) {
    int length = arr.length;
    for (int i = 0; i < k; i++) rotateOnce(arr, length);
  }

  public static void reverse(int[] arr, int idxStart, int idxEnd) {
    for (; idxStart < idxEnd; idxStart++, idxEnd--) {
      int temp = arr[idxStart];
      arr[idxStart] = arr[idxEnd];
      arr[idxEnd] = temp;
    }
  }

  public static void rotate(int[] arr, int k) {
    int length = arr.length;
    k = k % length;
    if (k < 0) k += length;
    reverse(arr, 0, length - k - 1);
    reverse(arr, length - k, length - 1);
    reverse(arr, 0, length - 1);
  }
}
