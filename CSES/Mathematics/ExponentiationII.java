import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class ExponentiationII implements Runnable {

  InputReader in;
  OutputWriter out;

  public static void main(String[] args) {
    new Thread(null, new ExponentiationII(), "", 256 * (1L << 20)).start();
  }

  @Override
  public void run() {
    try {
      in = new InputReader(System.in);
      out = new OutputWriter(System.out);
      solve();
      in.close();
      out.flush();
    } catch (Throwable t) {
      t.printStackTrace(System.err);
      System.exit(-1);
    }
  }

  void solve() throws IOException {
    int t = in.nextInt();
    int MOD = (int) 1e9 + 7;
    while (t-- > 0)
      out.append(
              Algebra.modPow(
                  in.nextLong(), Algebra.modPow(in.nextLong(), in.nextLong(), MOD - 1), MOD))
          .appendNewLine();
  }

  @FunctionalInterface
  static interface Procedure {
    void run();
  }

  static class Algebra {
    private static final double EPSILON = 1E-6;

    private Algebra() {}

    public static int modPow(long n, long exponent, int m) {
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

  static class InputReader {
    private static final int BUFFER_SIZE = 1 << 13;
    private final InputStream in;
    private byte[] inbuf;
    private int lenbuf;
    private int ptrbuf;

    public InputReader(InputStream is) {
      this.in = is;
      this.inbuf = new byte[BUFFER_SIZE];
      this.lenbuf = 0;
      this.ptrbuf = 0;
    }

    public void close() throws IOException {
      this.in.close();
    }

    private int readByte() {
      if (this.lenbuf == -1) throw new InputMismatchException();
      if (this.ptrbuf >= this.lenbuf) {
        this.ptrbuf = 0;
        try {
          this.lenbuf = this.in.read(this.inbuf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (this.lenbuf <= 0) return -1;
      }
      return this.inbuf[this.ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
      return !(c >= 33 && c <= 126);
    }

    private int skip() {
      int b;
      while ((b = this.readByte()) != -1 && this.isSpaceChar(b))
        ;
      return b;
    }

    public char nextCharacter() {
      return (char) this.skip();
    }

    public String nextLine() {
      int b = this.skip();
      StringBuilder sb = new StringBuilder();
      while (!(this.isSpaceChar(b))) {
        sb.appendCodePoint(b);
        b = this.readByte();
      }
      return sb.toString();
    }

    public long nextLong() {
      long num = 0;
      int b;
      boolean minus = false;
      while ((b = this.readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
        ;
      if (b == '-') {
        minus = true;
        b = this.readByte();
      }

      while (true) {
        if (b >= '0' && b <= '9') {
          num = num * 10 + (b - '0');
        } else {
          return minus ? -num : num;
        }
        b = this.readByte();
      }
    }

    public int nextInt() {
      return (int) this.nextLong();
    }

    public double nextDouble() {
      return Double.parseDouble(this.nextLine());
    }

    public int[] readIntegerArray(int n) {
      int[] a = new int[n];
      for (int i = 0; i < n; i++) a[i] = nextInt();
      return a;
    }

    public long[] readLongArray(int n) {
      long[] a = new long[n];
      for (int i = 0; i < n; i++) a[i] = nextLong();
      return a;
    }

    public char[] readCharacterArray(int n) {
      char[] buf = new char[n];
      int b = this.skip(), p = 0;
      while (p < n && !(this.isSpaceChar(b))) {
        buf[p++] = (char) b;
        b = this.readByte();
      }
      return n == p ? buf : Arrays.copyOf(buf, p);
    }
  }

  static class OutputWriter {

    private static final int BUFFER_SIZE = 1048576;
    private final byte[] buffer;
    private final OutputStream out;
    private int pos;

    public OutputWriter(OutputStream os) {
      this.out = os;
      this.buffer = new byte[BUFFER_SIZE];
    }

    public OutputWriter append(String s) throws IOException {
      int length = s.length();
      this.ensureCapacity(length);
      for (int i = 0; i < length; i++) this.buffer[this.pos++] = (byte) s.charAt(i);
      return this;
    }

    public OutputWriter append(byte[] bytes) throws IOException {
      if (BUFFER_SIZE - this.pos < bytes.length) {
        this.flush();
        if (bytes.length > BUFFER_SIZE) {
          this.out.write(bytes, 0, bytes.length);
          return this;
        }
      }
      for (byte b : bytes) this.buffer[this.pos++] = b;
      return this;
    }

    public OutputWriter append(byte[] bytes, int from, int to) throws IOException {
      int length = to - from;
      if (BUFFER_SIZE - this.pos < length) {
        this.flush();
        if (length > BUFFER_SIZE) {
          this.out.write(bytes, from, length);
          return this;
        }
      }
      for (int i = from; i < to; i++) this.buffer[this.pos++] = bytes[i];
      return this;
    }

    public OutputWriter append(char c) throws IOException {
      this.ensureCapacity(1);
      this.buffer[this.pos++] = (byte) c;
      return this;
    }

    public OutputWriter append(int i) throws IOException {
      return this.append(Integer.toString(i));
    }

    public OutputWriter append(long l) throws IOException {
      return this.append(Long.toString(l));
    }

    public OutputWriter append(double d) throws IOException {
      return this.append(Double.toString(d));
    }

    public void appendNewLine() throws IOException {
      this.ensureCapacity(1);
      this.buffer[this.pos++] = '\n';
    }

    public void flush() throws IOException {
      this.out.write(this.buffer, 0, this.pos);
      this.pos = 0;
    }

    private void ensureCapacity(int n) throws IOException {
      if (BUFFER_SIZE - this.pos < n) this.flush();
    }
  }
}