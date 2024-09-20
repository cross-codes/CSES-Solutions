package striver._5_strings._2;

public class _7_sumOfBeauty {
  public static int beautySum(String s) {
    // Maintain a frequency storage per index
    int n = s.length(), ans = 0;
    int[][] freq = new int[26][n + 1];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 26; j++) freq[j][i + 1] = freq[j][i];
      freq[s.charAt(i) - 97][i + 1]++;
    }

    // Add all the beauty values for all substrings
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j <= n; j++) {
        String substr = s.substring(i, j);
        int max = 0, min = Integer.MAX_VALUE, len = substr.length();
        int frequency = 0;

        for (int idx = 0; idx < len; idx++) {
          char c = substr.charAt(idx);
          frequency = freq[c - 97][j] - freq[c - 97][i];
          if (frequency > max) max = frequency;
          if (frequency < min) min = frequency;
        }

        ans += max - min;
      }
    }

    return ans;
  }
}
