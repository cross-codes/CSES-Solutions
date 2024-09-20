package neetcode.practice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _6_stringEncodeAndDecode {
  public static String encode(List<String> strs) {
    if (strs.isEmpty()) return null;
    return String.join("\u001F", strs);
  }

  public static List<String> decode(String str) {
    if (str == null) return new ArrayList<>();
    List<String> decoded = Arrays.asList(str.split("\u001F"));
    if (decoded.isEmpty()) return new ArrayList<String>();
    return decoded;
  }
}
