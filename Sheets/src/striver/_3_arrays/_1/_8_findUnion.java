package striver._3_arrays._1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _8_findUnion {
  public static List<Integer> sortedArray(int[] arr1, int[] arr2) {
    int l1 = arr1.length, l2 = arr2.length;
    ArrayList<Integer> ans = new ArrayList<>();
    int minLength = (l1 > l2) ? l2 : l1;
    int maxLength = -1;
    int[] condArr;
    if (minLength == l1) {
      maxLength = l2;
      condArr = arr2;
    } else {
      maxLength = l1;
      condArr = arr1;
    }
    for (int i = 0; i < minLength; i++) {
      if (!ans.contains(arr1[i])) ans.add(arr1[i]);
      if (!ans.contains(arr2[i])) ans.add(arr2[i]);
    }
    for (int j = minLength; j < maxLength; j++) if (!ans.contains(condArr[j])) ans.add(condArr[j]);

    Collections.sort(ans);
    return ans;
  }
}
