package striver._1_basics._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7_function {
  public static void Maximum(int a, int b) {
    System.out.println(a > b ? a : b);
  }

  public static void Swap(int[] arr) {
    int a = arr[0], b = arr[1];
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    System.out.println(a + " " + b);
  }

  public static int[] ctoi(char[] array) {
    int[] res = new int[array.length];
    int index = 0;

    for (int i = 0; i < array.length; i++) {
      if (!Character.isSpaceChar(array[i])) {
        res[index++] = Character.getNumericValue(array[i]);
      }
    }
    return Arrays.copyOf(res, index);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int choice = Integer.parseInt(bf.readLine());
    char[] arr = bf.readLine().toCharArray();
    int[] conv = ctoi(arr);
    switch (choice) {
      case 1:
        Maximum(conv[0], conv[1]);
        break;
      case 2:
        Swap(conv);
        break;

      default:
        break;
    }
  }
}
