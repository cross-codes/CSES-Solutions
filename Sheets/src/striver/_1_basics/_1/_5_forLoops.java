package striver._1_basics._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5_forLoops {
  public static int fibonnaci(int n) {
    if (n == 1 || n == 2) return 1;
    return fibonnaci(n - 1) + fibonnaci(n - 2);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int val = Integer.parseInt(bf.readLine());
    System.out.println(fibonnaci(val));
  }
}
