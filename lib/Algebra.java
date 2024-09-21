public class Algebra {
  private static final double EPSILON = 1E-6;

  private Algebra() {}

  public static int modPow(int n, int exponent, int m) {
    long result = 1;
    for (long i = 1, j = n; i <= exponent; i <<= 1, j = j * j % m) {
      if ((i & exponent) != 0) result = result * j % m;
    }
    return (int) result;
  }

  public static int modInverse(int n, int p) {
    return modPow(n, p - 2, p);
  }

  public static int[] modInverses(int n, int p) {
    int[] inverses = new int[n + 1];
    inverses[1] = 1;
    for (int i = 2; i <= n; i++) inverses[i] = (int) ((long) (p - p / i) * inverses[p % i] % p);
    return inverses;
  }

  public static int gcd(int a, int b) {
    if (a < b) {
      int temp = a;
      a = b;
      b = temp;
    }
    while (true) {
      a %= b;
      if (a == 0) return b;
      else {
        int temp = a;
        a = b;
        b = temp;
      }
    }
  }

  public static long gcd(long a, long b) {
    if (a < b) {
      long temp = a;
      a = b;
      b = temp;
    }
    while (true) {
      a %= b;
      if (a == 0) return b;
      else {
        long temp = a;
        a = b;
        b = temp;
      }
    }
  }

  public static int log2(int n) {
    return 31 - Integer.numberOfLeadingZeros(n);
  }

  public static int ceilLog2(int n) {
    return 32 - Integer.numberOfLeadingZeros(n - 1);
  }

  public static boolean equal(double a, double b) {
    return Math.abs(a - b) < EPSILON;
  }

  public static boolean equal0(double a) {
    return Math.abs(a) < EPSILON;
  }

  public static double[] solveLinear(double a, double b, double c, double d, double e, double f) {
    double D = a * e - b * d;
    double Dx = c * e - b * f;
    double Dy = a * f - c * d;
    if (D == 0) return new double[Dx == 0 && Dy == 0 ? 1 : 0];
    else return new double[] {Dx / D, Dy / D};
  }

  public static double[] solveQuadratic(double a, double b, double c) {
    double delta = b * b - a * c * 4;
    if (Algebra.equal0(delta)) return new double[] {-b / (a * 2)};
    else if (delta < 0) return new double[0];
    else {
      double a2 = a * 2;
      double x = -b / a2;
      double y = Math.sqrt(delta) / a2;
      return new double[] {x + y, x - y};
    }
  }

  public static void permute(byte[] array, Procedure procedure) {
    permute(array, array.length, procedure);
  }

  private static void permute(byte[] array, int length, Procedure procedure) {
    if (length == 1) procedure.run();
    else {
      permute(array, --length, procedure);
      for (int i = 0; i < length; i++) {
        int index = (length & 1) == 0 ? 0 : i;
        byte temp = array[index];
        array[index] = array[length];
        array[length] = temp;
        permute(array, length, procedure);
      }
    }
  }

  public static void permute(int[] array, Procedure procedure) {
    permute(array, array.length, procedure);
  }

  private static void permute(int[] array, int length, Procedure procedure) {
    if (length == 1) procedure.run();
    else {
      permute(array, --length, procedure);
      for (int i = 0; i < length; i++) {
        int index = (length & 1) == 0 ? 0 : i;
        int temp = array[index];
        array[index] = array[length];
        array[length] = temp;
        permute(array, length, procedure);
      }
    }
  }
}