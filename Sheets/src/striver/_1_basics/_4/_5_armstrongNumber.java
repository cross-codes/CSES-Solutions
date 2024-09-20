package striver._1_basics._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5_armstrongNumber {
  public static boolean isArmstrong(int n) {
    int sum = 0, idx = n, digit = -1;
    int numOfDigits = Integer.toString(n).toCharArray().length;
    while (n != 0) {
      digit = n % 10;
      sum += Math.pow(digit, numOfDigits);
      n /= 10;
    }

    return sum == idx;
  }

  public static void main(String[] args) throws IOException {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader bf = new BufferedReader(in);
    System.out.println(isArmstrong(Integer.parseInt(bf.readLine().trim())));
  }
}
