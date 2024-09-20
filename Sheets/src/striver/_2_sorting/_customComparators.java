package striver._2_sorting;

import java.util.Arrays;
import java.util.Comparator;

public class _customComparators {
  public static void main(String[] args) {
    int[] arr = {2, -4, 1, 5, 7, 9, 0};
    int n = arr.length;

    // Sort the array in ascending order:
    Arrays.sort(arr);

    for (int i = 0; i < n; i++) System.out.print(arr[i]);
    System.out.println();

    // Sort the array using a custom comparator
    // To use this, you need to convert primitive types into objects first
    // Is more optimal when the data types are already objects

    // Example: Sort in descending order
    Integer[] arrInt = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    Arrays.sort(arrInt, Comparator.reverseOrder());
    arr = Arrays.stream(arrInt).mapToInt(Integer::intValue).toArray();

    for (int i = 0; i < n; i++) System.out.print(arr[i]);
    System.out.println();

    // Example: Sort absolute values
    arrInt = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    Arrays.sort(
        arrInt,
        new Comparator<Integer>() {
          @Override
          public int compare(Integer a, Integer b) {
            // Return a positive value if you want a to come after b
            if (Math.abs(a) > Math.abs(b)) return 1;
            else return -1;
          }
        });
    arr = Arrays.stream(arrInt).mapToInt(Integer::intValue).toArray();
    for (int i = 0; i < n; i++) System.out.print(arr[i]);
    System.out.println();
  }
}
