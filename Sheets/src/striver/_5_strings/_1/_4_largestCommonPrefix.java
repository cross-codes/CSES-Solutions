package striver._5_strings._1;

public class _4_largestCommonPrefix {
  public static String longestCommonPrefix(String[] strs) {
    // Find the maximum possible length of the prefix
    int min = Integer.MAX_VALUE, n = strs.length;
    for (int idx = 0; idx < n; idx++) if (strs[idx].length() < min) min = strs[idx].length();

    StringBuilder ans = new StringBuilder("");
    char toAppend;
    boolean fail = false;
    if (!strs[0].equals("")) {
      for (int count = 0; count < min; count++) {
        toAppend = strs[0].charAt(count);
        for (int idx = 0; idx < n; idx++)
          if (strs[idx].charAt(count) != toAppend) {
            fail = true;
            break;
          }
        if (!fail) ans.append(toAppend);
        else break;
      }
    }
    return ans.toString();
  }
}
