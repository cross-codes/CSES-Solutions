package neetcode.practice.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _4_anagramGroups {
  static HashMap<Character, Integer> generateInfo(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        int freq = map.get(c);
        map.put(c, ++freq);
      } else map.put(c, 1);
    }

    return map;
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<Integer, HashMap<Character, Integer>> info =
        new HashMap<Integer, HashMap<Character, Integer>>();
    int n = strs.length;

    // Traverse through the array and store info about each elements frequency
    for (int i = 0; i < n; i++) {
      String s = strs[i];
      info.put(i, generateInfo(s));
    }

    List<List<String>> ans = new ArrayList<List<String>>();
    Set<Integer> excludedIndices = new LinkedHashSet<>();

    for (int i = 0; i < n; i++) {
      if (excludedIndices.contains(i)) continue;
      else {
        List<String> anagramGroup = new ArrayList<>();
        HashMap<Character, Integer> stringInfo = info.get(i);
        anagramGroup.add(strs[i]);
        excludedIndices.add(i);
        for (int j = i; j < n; j++) {
          if (excludedIndices.contains(j)) continue;
          else if (info.get(j).equals(stringInfo)) {
            anagramGroup.add(strs[j]);
            excludedIndices.add(j);
          }
        }
        ans.add(anagramGroup);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
    System.err.println(groupAnagrams(strs));
  }
}
