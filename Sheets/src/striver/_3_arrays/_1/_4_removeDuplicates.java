package striver._3_arrays._1;

import java.util.ArrayList;
import java.util.Arrays;

public class _4_removeDuplicates {
  public static int removeDuplicatesBrute(int[] arr) {
    ArrayList<Integer> unique = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (!unique.contains(arr[i])) unique.add(arr[i]);
      else arr[i] = 101; // Constraint
    }
    Arrays.sort(arr);
    return unique.size();
  }

  public static int removeDuplicates(int[] arr) {
    int i = 0, j = 1;
    for (; j < arr.length; j++) {
      if (arr[j] != arr[i]) {
        i++;
        arr[i] = arr[j];
      }
    }
    return i + 1;
  }
}
