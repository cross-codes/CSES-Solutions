package striver._1_basics._5;

public class _8_fibonnaciNumber {
  public static int fib(int n) {
    switch (n) {
      case 0:
        return 0;
      case 1:
        return 1;
      default:
        return fib(n - 1) + fib(n - 2);
    }
  }
}
