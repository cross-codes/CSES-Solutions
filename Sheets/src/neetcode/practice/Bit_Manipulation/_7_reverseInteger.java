package neetcode.practice.Bit_Manipulation;

public class _7_reverseInteger {
  static void reverseArr(char[] arr, int idxStart, int idxEnd) {
    for (; idxStart < idxEnd; idxStart++, idxEnd--) {
      char temp = arr[idxStart];
      arr[idxStart] = arr[idxEnd];
      arr[idxEnd] = temp;
    }
  }

  public static int reverse(int x) {
    boolean isNeg = x < 0;
    if (isNeg) x = -x;

    char[] num = String.valueOf(x).toCharArray();
    int n = num.length;

    reverseArr(num, 0, n - 1);

    long ans = 0;
    for (int i = 0; i < n; i++)
      ans += Character.getNumericValue(num[i]) * (Math.pow(10, n - i - 1));

    ans = ans * ((isNeg) ? -1 : 1);

    return (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) ? 0 : (int) ans;
  }
}
