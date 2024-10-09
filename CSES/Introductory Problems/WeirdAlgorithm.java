import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class WeirdAlgorithm implements Runnable {

  InputReader in;
  OutputWriter out;

  public static void main(String[] args) {
    new Thread(null, new WeirdAlgorithm(), "", 256 * (1L << 20)).start();
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

  void solve() {
    long n = in.nextLong();
    out.print(n + " ");
    while (n != 1) {
      if ((n & 1) != 0) n = 3 * n + 1;
      else n = n / 2;
      out.print(n + " ");
    }
  }

  @FunctionalInterface
  static interface Procedure {
    void run();
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
    private static final int BUFFER_SIZE = 1 << 16;
    private final byte[] buf;
    private final OutputStream out;
    private int ptr;

    public OutputWriter(OutputStream os) {
      this.out = os;
      this.buf = new byte[BUFFER_SIZE];
      this.ptr = 0;
    }

    public OutputWriter write(byte b) {
      this.buf[this.ptr++] = b;
      if (this.ptr == BUFFER_SIZE) this.innerflush();
      return this;
    }

    public OutputWriter write(char c) {
      return this.write((byte) c);
    }

    public OutputWriter write(char[] s) {
      for (char c : s) {
        this.buf[this.ptr++] = (byte) c;
        if (this.ptr == BUFFER_SIZE) this.innerflush();
      }
      return this;
    }

    public OutputWriter write(String s) {
      s.chars()
          .forEach(
              c -> {
                this.buf[this.ptr++] = (byte) c;
                if (this.ptr == BUFFER_SIZE) this.innerflush();
              });
      return this;
    }

    private static int countDigits(int l) {
      if (l >= 1000000000) return 10;
      if (l >= 100000000) return 9;
      if (l >= 10000000) return 8;
      if (l >= 1000000) return 7;
      if (l >= 100000) return 6;
      if (l >= 10000) return 5;
      if (l >= 1000) return 4;
      if (l >= 100) return 3;
      if (l >= 10) return 2;
      return 1;
    }

    public OutputWriter write(int x) {
      if (x == Integer.MIN_VALUE) {
        return this.write((long) x);
      }
      if (this.ptr + 12 >= BUFFER_SIZE) this.innerflush();
      if (x < 0) {
        this.write((byte) '-');
        x = -x;
      }
      int d = countDigits(x);
      for (int i = this.ptr + d - 1; i >= this.ptr; i--) {
        this.buf[i] = (byte) ('0' + x % 10);
        x /= 10;
      }
      this.ptr += d;
      return this;
    }

    private static int countDigits(long l) {
      if (l >= 1000000000000000000L) return 19;
      if (l >= 100000000000000000L) return 18;
      if (l >= 10000000000000000L) return 17;
      if (l >= 1000000000000000L) return 16;
      if (l >= 100000000000000L) return 15;
      if (l >= 10000000000000L) return 14;
      if (l >= 1000000000000L) return 13;
      if (l >= 100000000000L) return 12;
      if (l >= 10000000000L) return 11;
      if (l >= 1000000000L) return 10;
      if (l >= 100000000L) return 9;
      if (l >= 10000000L) return 8;
      if (l >= 1000000L) return 7;
      if (l >= 100000L) return 6;
      if (l >= 10000L) return 5;
      if (l >= 1000L) return 4;
      if (l >= 100L) return 3;
      if (l >= 10L) return 2;
      return 1;
    }

    public OutputWriter write(long x) {
      if (x == Long.MIN_VALUE) {
        return this.write("" + x);
      }
      if (this.ptr + 21 >= BUFFER_SIZE) this.innerflush();
      if (x < 0) {
        this.write((byte) '-');
        x = -x;
      }
      int d = countDigits(x);
      for (int i = this.ptr + d - 1; i >= this.ptr; i--) {
        this.buf[i] = (byte) ('0' + x % 10);
        x /= 10;
      }
      this.ptr += d;
      return this;
    }

    public OutputWriter write(double x, int precision) {
      if (x < 0) {
        this.write('-');
        x = -x;
      }
      x += Math.pow(10, -precision) / 2;
      this.write((long) x).write(".");
      x -= (long) x;
      for (int i = 0; i < precision; i++) {
        x *= 10;
        this.write((char) ('0' + (int) x));
        x -= (int) x;
      }
      return this;
    }

    public OutputWriter writeln(char c) {
      return this.write(c).writeln();
    }

    public OutputWriter writeln(int x) {
      return this.write(x).writeln();
    }

    public OutputWriter writeln(long x) {
      return this.write(x).writeln();
    }

    public OutputWriter writeln(double x, int precision) {
      return this.write(x, precision).writeln();
    }

    public OutputWriter write(int... xs) {
      boolean first = true;
      for (int x : xs) {
        if (!first) write(' ');
        first = false;
        this.write(x);
      }
      return this;
    }

    public OutputWriter write(long... xs) {
      boolean first = true;
      for (long x : xs) {
        if (!first) this.write(' ');
        first = false;
        this.write(x);
      }
      return this;
    }

    public OutputWriter writeln() {
      return this.write((byte) '\n');
    }

    public OutputWriter writeln(int... xs) {
      return this.write(xs).writeln();
    }

    public OutputWriter writeln(long... xs) {
      return this.write(xs).writeln();
    }

    public OutputWriter writeln(char[] line) {
      return this.write(line).writeln();
    }

    public OutputWriter writeln(char[]... map) {
      for (char[] line : map) this.write(line).writeln();
      return this;
    }

    public OutputWriter writeln(String s) {
      return this.write(s).writeln();
    }

    private void innerflush() {
      try {
        this.out.write(this.buf, 0, this.ptr);
        this.ptr = 0;
      } catch (IOException e) {
        throw new RuntimeException("innerflush");
      }
    }

    public void flush() {
      this.innerflush();
      try {
        this.out.flush();
      } catch (IOException e) {
        throw new RuntimeException("flush");
      }
    }

    public OutputWriter print(byte b) {
      return this.write(b);
    }

    public OutputWriter print(char c) {
      return this.write(c);
    }

    public OutputWriter print(char[] s) {
      return this.write(s);
    }

    public OutputWriter print(String s) {
      return this.write(s);
    }

    public OutputWriter print(int x) {
      return this.write(x);
    }

    public OutputWriter print(long x) {
      return this.write(x);
    }

    public OutputWriter print(double x, int precision) {
      return this.write(x, precision);
    }

    public OutputWriter println(char c) {
      return this.writeln(c);
    }

    public OutputWriter println(int x) {
      return this.writeln(x);
    }

    public OutputWriter println(long x) {
      return this.writeln(x);
    }

    public OutputWriter println(double x, int precision) {
      return this.writeln(x, precision);
    }

    public OutputWriter print(int... xs) {
      return this.write(xs);
    }

    public OutputWriter print(long... xs) {
      return this.write(xs);
    }

    public OutputWriter println(int... xs) {
      return this.writeln(xs);
    }

    public OutputWriter println(long... xs) {
      return this.writeln(xs);
    }

    public OutputWriter println(char[] line) {
      return this.writeln(line);
    }

    public OutputWriter println(char[]... map) {
      return this.writeln(map);
    }

    public OutputWriter println(String s) {
      return this.writeln(s);
    }

    public OutputWriter println() {
      return this.writeln();
    }
  }
}