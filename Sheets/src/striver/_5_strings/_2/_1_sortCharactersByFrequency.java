package striver._5_strings._2;

public class _1_sortCharactersByFrequency {
  static int maxIndex(int[] arr) {
    int max = -1, n = arr.length, ans = -1;
    for (int idx = 0; idx < n; idx++)
      if (arr[idx] > max && arr[idx] > 0) {
        max = arr[idx];
        ans = idx;
      }
    return (max == -1) ? -1 : ans;
  }

  public static String frequencySort(String s) {
    int[] freq = new int[75]; // 122 - 48 + 1
    int n = s.length();

    if (n == 0) return "";

    for (int idx = 0; idx < n; idx++) freq[s.charAt(idx) - 48]++;
    StringBuilder ans = new StringBuilder("");
    while (true) {
      int idx = maxIndex(freq);
      if (idx == -1) break;
      for (int count = 0; count < freq[idx]; count++) ans.append((char) (idx + 48));
      freq[idx] = -1;
    }
    return ans.toString();
  }
}
