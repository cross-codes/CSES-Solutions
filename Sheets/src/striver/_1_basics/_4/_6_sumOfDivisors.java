package striver._1_basics._4;

public class _6_sumOfDivisors {

  public static int sgn(double x) {
    if (x > 0) return 1;
    else if (x == 0) return 0;
    else return -1;
  }

  public static int sumOfDivisors(int n) {
    int sum = 0;
    double quantifier = -1;
    for (int i = 1; i <= n; i++) {
      quantifier = n / (double) i - Math.floor(n / (double) i);
      sum += i * ((sgn(quantifier) + 1) % 2);
    }
    return sum;
  }

  public static int sumOfAllDivisors(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) sum += sumOfDivisors(i);
    return sum;
  }
}
