package striver._5_strings._1;

public class _5_isomorphicStrings {
  public static boolean isIsomorphic(String s, String t) {
    int n = s.length();
    int[] sindex = new int[200];
    int[] tindex = new int[200];

    // Iterate once through the strings
    for (int idx = 0; idx < n; idx++) {
      // Compare the values of sindex[character] and tindex[potentially different character]
      // If they are not the same, they have been seen before with a different mapping
      if (sindex[s.charAt(idx)] != tindex[t.charAt(idx)]) return false;
      // Set them to be a same number
      sindex[s.charAt(idx)] = idx + 1;
      tindex[t.charAt(idx)] = idx + 1;
    }

    return true;
  }
}
