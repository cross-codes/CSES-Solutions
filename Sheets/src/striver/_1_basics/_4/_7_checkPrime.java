package striver._1_basics._4;

public class _7_checkPrime {
  public static String isPrime(int num) {
    if (num == 1) return "NO";
    else if (num == 2) return "YES";
    for (int i = 2; i <= Math.sqrt(num); i++) if (num % i == 0) return "NO";
    return "YES";
  }
}
