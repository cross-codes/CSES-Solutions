import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class InputReader {
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