import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class _1777A implements Runnable {

  InputStream in;
  StandardOutputWriter out;
  private byte[] inbuf = new byte[1024];
  public int lenbuf = 0, ptrbuf = 0;

  public static void main(String[] args) {
    new Thread(null, new _1777A(), "", 256 * (1L << 20)).start();
  }

  public void run() {
    try {
      in = System.in;
      out = new StandardOutputWriter(System.out);
      solve();
      in.close();
      out.flush();
    } catch (Throwable t) {
      t.printStackTrace(System.err);
      System.exit(-1);
    }
  }

  int readByte() {
    if (lenbuf == -1) throw new InputMismatchException();
    if (ptrbuf >= lenbuf) {
      ptrbuf = 0;
      try {
        lenbuf = in.read(inbuf);
      } catch (IOException e) {
        throw new InputMismatchException();
      }
      if (lenbuf <= 0) return -1;
    }
    return inbuf[ptrbuf++];
  }

  boolean isSpaceChar(int c) {
    return !(c >= 33 && c <= 126);
  }

  int skip() {
    int b;
    while ((b = readByte()) != -1 && isSpaceChar(b))
      ;
    return b;
  }

  char rc() {
    return (char) skip();
  }

  String rs() {
    int b = skip();
    StringBuilder sb = new StringBuilder();
    while (!(isSpaceChar(b))) {
      sb.appendCodePoint(b);
      b = readByte();
    }
    return sb.toString();
  }

  char[] rs(int n) {
    char[] buf = new char[n];
    int b = skip(), p = 0;
    while (p < n && !(isSpaceChar(b))) {
      buf[p++] = (char) b;
      b = readByte();
    }
    return n == p ? buf : Arrays.copyOf(buf, p);
  }

  int ri() {
    return (int) rl();
  }

  long rl() {
    long num = 0;
    int b;
    boolean minus = false;
    while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
      ;
    if (b == '-') {
      minus = true;
      b = readByte();
    }

    while (true) {
      if (b >= '0' && b <= '9') {
        num = num * 10 + (b - '0');
      } else {
        return minus ? -num : num;
      }
      b = readByte();
    }
  }

  double rd() {
    return Double.parseDouble(rs());
  }

  int[] ra(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = ri();
    return a;
  }

  long[] ral(int n) {
    long[] a = new long[n];
    for (int i = 0; i < n; i++) a[i] = rl();
    return a;
  }

  boolean arrayIsBad(ArrayList<Integer> arr) {
    int n = arr.size();
    if (n == 1) return false;

    boolean res = false;
    for (int i = 0; i < n - 1; i++) {
      if (arr.get(i) % 2 == arr.get(i + 1) % 2) {
        res = true;
        break;
      }
    }

    return res;
  }

  void solve() throws IOException {
    int t = ri();
    final StringBuilder sb = new StringBuilder(t);
    while (t-- > 0) {
      int n = ri();
      ArrayList<Integer> arr = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        if ((ri() & 1) == 0) arr.add(0);
        else arr.add(1);
      }
      int cnt = 0;
      while (arrayIsBad(arr)) {
        int len = arr.size();
        for (int i = 0; i < len - 1; i++) {
          if (arr.get(i) % 2 == arr.get(i + 1) % 2) {
            arr.set(i, arr.get(i) * arr.get(i + 1));
            arr.remove(i + 1);
            cnt++;
            break;
          }
        }
      }
      sb.append(cnt).append("\n");
    }
    out.print(sb.toString());
  }

  static class StandardOutputWriter {
    private static final int BUFFER_SIZE = 1 << 16;
    private final byte[] buf = new byte[BUFFER_SIZE];
    private final OutputStream out;
    private int ptr = 0;

    public StandardOutputWriter(OutputStream os) {
      this.out = os;
    }

    public StandardOutputWriter(String path) {
      try {
        this.out = new FileOutputStream(path);
      } catch (FileNotFoundException e) {
        throw new RuntimeException("StandardOutputWriter");
      }
    }

    public StandardOutputWriter write(byte b) {
      buf[ptr++] = b;
      if (ptr == BUFFER_SIZE) innerflush();
      return this;
    }

    public StandardOutputWriter write(char c) {
      return write((byte) c);
    }

    public StandardOutputWriter write(char[] s) {
      for (char c : s) {
        buf[ptr++] = (byte) c;
        if (ptr == BUFFER_SIZE) innerflush();
      }
      return this;
    }

    public StandardOutputWriter write(String s) {
      s.chars()
          .forEach(
              c -> {
                buf[ptr++] = (byte) c;
                if (ptr == BUFFER_SIZE) innerflush();
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

    public StandardOutputWriter write(int x) {
      if (x == Integer.MIN_VALUE) {
        return write((long) x);
      }
      if (ptr + 12 >= BUFFER_SIZE) innerflush();
      if (x < 0) {
        write((byte) '-');
        x = -x;
      }
      int d = countDigits(x);
      for (int i = ptr + d - 1; i >= ptr; i--) {
        buf[i] = (byte) ('0' + x % 10);
        x /= 10;
      }
      ptr += d;
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

    public StandardOutputWriter write(long x) {
      if (x == Long.MIN_VALUE) {
        return write("" + x);
      }
      if (ptr + 21 >= BUFFER_SIZE) innerflush();
      if (x < 0) {
        write((byte) '-');
        x = -x;
      }
      int d = countDigits(x);
      for (int i = ptr + d - 1; i >= ptr; i--) {
        buf[i] = (byte) ('0' + x % 10);
        x /= 10;
      }
      ptr += d;
      return this;
    }

    public StandardOutputWriter write(double x, int precision) {
      if (x < 0) {
        write('-');
        x = -x;
      }
      x += Math.pow(10, -precision) / 2;
      write((long) x).write(".");
      x -= (long) x;
      for (int i = 0; i < precision; i++) {
        x *= 10;
        write((char) ('0' + (int) x));
        x -= (int) x;
      }
      return this;
    }

    public StandardOutputWriter writeln(char c) {
      return write(c).writeln();
    }

    public StandardOutputWriter writeln(int x) {
      return write(x).writeln();
    }

    public StandardOutputWriter writeln(long x) {
      return write(x).writeln();
    }

    public StandardOutputWriter writeln(double x, int precision) {
      return write(x, precision).writeln();
    }

    public StandardOutputWriter write(int... xs) {
      boolean first = true;
      for (int x : xs) {
        if (!first) write(' ');
        first = false;
        write(x);
      }
      return this;
    }

    public StandardOutputWriter write(long... xs) {
      boolean first = true;
      for (long x : xs) {
        if (!first) write(' ');
        first = false;
        write(x);
      }
      return this;
    }

    public StandardOutputWriter writeln() {
      return write((byte) '\n');
    }

    public StandardOutputWriter writeln(int... xs) {
      return write(xs).writeln();
    }

    public StandardOutputWriter writeln(long... xs) {
      return write(xs).writeln();
    }

    public StandardOutputWriter writeln(char[] line) {
      return write(line).writeln();
    }

    public StandardOutputWriter writeln(char[]... map) {
      for (char[] line : map) write(line).writeln();
      return this;
    }

    public StandardOutputWriter writeln(String s) {
      return write(s).writeln();
    }

    private void innerflush() {
      try {
        out.write(buf, 0, ptr);
        ptr = 0;
      } catch (IOException e) {
        throw new RuntimeException("innerflush");
      }
    }

    public void flush() {
      innerflush();
      try {
        out.flush();
      } catch (IOException e) {
        throw new RuntimeException("flush");
      }
    }

    public StandardOutputWriter print(byte b) {
      return write(b);
    }

    public StandardOutputWriter print(char c) {
      return write(c);
    }

    public StandardOutputWriter print(char[] s) {
      return write(s);
    }

    public StandardOutputWriter print(String s) {
      return write(s);
    }

    public StandardOutputWriter print(int x) {
      return write(x);
    }

    public StandardOutputWriter print(long x) {
      return write(x);
    }

    public StandardOutputWriter print(double x, int precision) {
      return write(x, precision);
    }

    public StandardOutputWriter println(char c) {
      return writeln(c);
    }

    public StandardOutputWriter println(int x) {
      return writeln(x);
    }

    public StandardOutputWriter println(long x) {
      return writeln(x);
    }

    public StandardOutputWriter println(double x, int precision) {
      return writeln(x, precision);
    }

    public StandardOutputWriter print(int... xs) {
      return write(xs);
    }

    public StandardOutputWriter print(long... xs) {
      return write(xs);
    }

    public StandardOutputWriter println(int... xs) {
      return writeln(xs);
    }

    public StandardOutputWriter println(long... xs) {
      return writeln(xs);
    }

    public StandardOutputWriter println(char[] line) {
      return writeln(line);
    }

    public StandardOutputWriter println(char[]... map) {
      return writeln(map);
    }

    public StandardOutputWriter println(String s) {
      return writeln(s);
    }

    public StandardOutputWriter println() {
      return writeln();
    }
  }
}
