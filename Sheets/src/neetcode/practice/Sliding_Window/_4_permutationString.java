package neetcode.practice.Sliding_Window;

import java.util.Arrays;

public class _4_permutationString {
  public static boolean checkInclusion(String s1, String s2) {
    int n = s1.length(), N = s2.length();
    if (N == 1) return s2.equals(s1);

    int[] freq = new int[26]; // Store frequencies from s1
    int start = 0, end = 1; // Window pointers

    // Fill up freq
    for (int i = 0; i < n; i++) freq[s1.charAt(i) - 'a']++;

    // Find the first instance where we have a match
    while (start < N && freq[s2.charAt(start) - 'a'] == 0) start++;

    if (start == N) return false;
    else {
      int[] windowFreq = new int[26];
      windowFreq[s2.charAt(start) - 'a']++;
      // Begin the sliding window
      end = start + 1;
      while (end < N) {
        if (Arrays.equals(windowFreq, freq)) return true;
        char c = s2.charAt(end);
        if (freq[c - 'a'] == 0) {
          // This character does not exist
          start = end + 1;
          windowFreq = new int[26];
        } else {
          // This character exists
          if (windowFreq[c - 'a'] == freq[c - 'a']) {
            // We need to move start till we find the same character
            for (int i = start; i < end; i++) {
              if (s2.charAt(i) != c) windowFreq[s2.charAt(i) - 'a']--;
              else {
                start = i;
                windowFreq[c - 'a']--;
                break;
              }
            }
          }
          windowFreq[c - 'a']++;
        }
        end++;
      }
      return Arrays.equals(windowFreq, freq);
    }
  }
}
