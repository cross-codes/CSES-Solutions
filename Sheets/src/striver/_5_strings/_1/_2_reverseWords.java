package striver._5_strings._1;

public class _2_reverseWords {
  static void reverse(String[] arr, int idxStart, int idxEnd) {
    for (; idxStart < idxEnd; idxStart++, idxEnd--) {
      String temp = arr[idxStart];
      arr[idxStart] = arr[idxEnd];
      arr[idxEnd] = temp;
    }
  }

  public static String reverseWords(String s) {
    String[] splited = s.trim().split("\\s+");
    int n = splited.length;
    reverse(splited, 0, n - 1);
    StringBuffer ans = new StringBuffer();
    for (int idx = 0; idx < n; idx++) ans.append(splited[idx]).append(" ");
    return ans.toString().trim();
  }
}
