package striver._5_strings._1;

public class _7_anagram {
  static long matchCount(String s, char c) {
    return s.chars().filter(ch -> ch == c).count();
  }

  public static boolean isAnagram(String s, String t) {
    int n = s.length();
    char[] checked = new char[26];

    if (n != t.length()) return false;

    for (int idx = 0; idx < n; idx++) {
      char c = s.charAt(idx);
      if (checked[(int) c - 97] == c) continue;
      long s_count = matchCount(s, c), t_count = matchCount(t, c);
      if (s_count != t_count) return false;
      else checked[(int) c - 97] = c;
    }

    return true;
  }
}
