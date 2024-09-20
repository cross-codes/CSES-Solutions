package striver._1_basics._5;

public class _1_printNosWithRecursion {

  public static void populateArray(int[] numArray, int idx) {
    if (idx < numArray.length) {
      numArray[idx] = idx + 1;
      populateArray(numArray, ++idx);
    }
  }

  public static int[] printNos(int x) {
    int[] numbers = new int[x];
    populateArray(numbers, 0);
    return numbers;
  }
}
