import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SalaryQueries implements Runnable {

  InputReader in;
  OutputWriter out;

  public static void main(String[] args) {
    new Thread(null, new SalaryQueries(), "", 256 * (1L << 20)).start();
  }

  @Override
  public void run() {
    try {
      in = new InputReader(System.in);
      out = new OutputWriter(System.out);
      solve();
      out.flush();
    } catch (Throwable t) {
      t.printStackTrace(System.err);
      System.exit(-1);
    }
  }

  private static void qsort(int[][] nums, int i, int j) {
    int pivot = i + Random.nextInt(j - i + 1), small = i - 1;
    swap(nums, pivot, j);
    for (int p = i; p < j; ++p) {
      if (nums[p][0] <= nums[j][0]) swap(nums, ++small, p);
    }
    swap(nums, ++small, j);
    if (i < small - 1) qsort(nums, i, small - 1);
    if (small + 1 < j) qsort(nums, small + 1, j);
  }

  private static void swap(int[][] nums, int i, int j) {
    int a = nums[i][0], b = nums[i][1];
    nums[i][0] = nums[j][0];
    nums[i][1] = nums[j][1];
    nums[j][0] = a;
    nums[j][1] = b;
  }

  private static int get(int[] bit, int i) {
    int res = 0;
    while (0 < i) {
      res += bit[i];
      i -= i & -i;
    }
    return res;
  }

  private static void add(int[] bit, int i, int val) {
    while (i < bit.length) {
      bit[i] += val;
      i += i & -i;
    }
  }

  void solve() throws IOException {
    int n = in.nextInt(), q = in.nextInt(), cnt = 0;
    int[] salary = new int[n];

    int[][] query = new int[q][3], compress = new int[n + (q << 1)][2];

    for (int i = 0; i < n; i++) {
      compress[i][0] = salary[i] = in.nextInt();
      compress[i][1] = i;
    }

    for (int i = 0, j = n; i < q; ++i, j += 2) {
      query[i][0] = '!' == in.nextCharacter() ? 1 : 2;
      query[i][1] = in.nextInt();
      query[i][2] = in.nextInt();
      compress[j][0] = query[i][1];
      compress[j][1] = j;
      compress[j + 1][0] = query[i][2];
      compress[j + 1][1] = j + 1;
    }

    qsort(compress, 0, compress.length - 1);

    for (int i = 0, j = Integer.MIN_VALUE; i < compress.length; ++i) {
      if (compress[i][0] != j) cnt++;
      if (compress[i][1] < n) salary[compress[i][1]] = cnt;
      else {
        int p = (compress[i][1] - n) >> 1, r = 1 == ((compress[i][1] - n) & 1) ? 2 : 1;
        if (1 == query[p][0] && 2 == r) query[p][2] = cnt;
        else if (2 == query[p][0]) query[p][1 == ((compress[i][1] - n) & 1) ? 2 : 1] = cnt;
      }
      j = compress[i][0];
    }

    int[] bit = new int[cnt + 1];
    for (int i : salary) add(bit, i, 1);
    for (int[] cmd : query) {
      if (1 == cmd[0]) {
        add(bit, salary[cmd[1] - 1], -1);
        add(bit, cmd[2], 1);
        salary[cmd[1] - 1] = cmd[2];
      } else {
        out.append(get(bit, cmd[2]) - get(bit, cmd[1] - 1)).appendNewLine();
      }
    }
  }

  static class Random {
    private static long seed = System.nanoTime() ^ 8682522807148012L;

    private Random() {}

    public static void nextBytes(byte[] bytes) {
      for (int i = 0, len = bytes.length; i < len; ) {
        for (int rnd = nextInt(), n = Math.min(len - i, Integer.SIZE / Byte.SIZE);
            n-- > 0;
            rnd >>= Byte.SIZE) bytes[i++] = (byte) rnd;
      }
    }

    public static int nextInt() {
      return next(32);
    }

    public static int nextInt(int bound) {
      int r = next(31);
      int m = bound - 1;
      if ((bound & m) == 0) r = (int) (bound * (long) r >> 31);
      else
        for (int u = r; u - (r = u % bound) + m < 0; u = next(31))
          ;
      return r;
    }

    public static long nextLong() {
      return (long) next(32) << 32 | next(32);
    }

    public static boolean nextBoolean() {
      return next(1) != 0;
    }

    public static float nextFloat() {
      return next(24) / (float) (1 << 24);
    }

    public static double nextDouble() {
      return ((long) next(26) << 27 | next(27)) * 0x1.0p-53;
    }

    private static int next(int bits) {
      seed = seed * 0x5DEECE66DL + 0xBL & 0xFFFFFFFFFFFFL;
      return (int) (seed >>> 48 - bits);
    }
  }

  @FunctionalInterface
  static interface Procedure {
    void run();
  }

  static class InputReader {
    private final byte[] buffer;
    private int pos;
    private final InputStream in;

    public InputReader(InputStream is) {
      this.in = is;
      try {
        this.buffer = new byte[this.in.available() + 1];
        this.buffer[this.buffer.length - 1] = '\n';
        this.in.read(this.buffer);
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    }

    public byte[] next(int n) {
      while (true) {
        byte b = this.buffer[this.pos++];
        if (b != '\n') {
          this.pos--;
          break;
        }
      }
      byte[] bytes = new byte[n];
      System.arraycopy(buffer, this.pos, bytes, 0, n);
      this.pos += n;
      return bytes;
    }

    public byte[] next() {
      int from;
      while (true) {
        byte b = this.buffer[this.pos++];
        if (b != ' ' && b != '\n') {
          from = this.pos;
          break;
        }
      }
      while (true) {
        byte b = this.buffer[this.pos++];
        if (b == ' ' || b == '\n') break;
      }
      byte[] bytes = new byte[pos - from];
      System.arraycopy(this.buffer, from - 1, bytes, 0, bytes.length);
      return bytes;
    }

    public byte[] nextLine() {
      int from = pos;
      while (true) {
        byte b = this.buffer[pos++];
        if (b == '\n') break;
      }
      byte[] bytes = new byte[pos - from - 1];
      System.arraycopy(this.buffer, from, bytes, 0, bytes.length);
      return bytes;
    }

    public byte nextCharacter() {
      while (true) {
        byte b = this.buffer[this.pos++];
        if (b != ' ' && b != '\n') return b;
      }
    }

    public int nextInt() {
      int n;
      boolean positive;
      while (true) {
        byte b = this.buffer[this.pos++];
        if (b == '-') {
          positive = false;
          n = this.buffer[this.pos++] - '0';
          break;
        } else if (b >= '0' && b <= '9') {
          positive = true;
          n = b - '0';
          break;
        }
      }
      while (true) {
        byte b = this.buffer[this.pos++];
        if (b >= '0' && b <= '9') n = n * 10 + b - '0';
        else return positive ? n : -n;
      }
    }

    public long nextLong() {
      long n;
      boolean positive;
      while (true) {
        byte b = this.buffer[this.pos++];
        if (b == '-') {
          positive = false;
          n = this.buffer[this.pos++] - '0';
          break;
        } else if (b >= '0' && b <= '9') {
          positive = true;
          n = b - '0';
          break;
        }
      }
      while (true) {
        byte b = this.buffer[pos++];
        if (b >= '0' && b <= '9') n = n * 10 + b - '0';
        else return positive ? n : -n;
      }
    }

    public double nextDouble() {
      long n;
      boolean positive;
      while (true) {
        byte b = this.buffer[this.pos++];
        if (b == '-') {
          positive = false;
          n = this.buffer[this.pos++] - '0';
          break;
        } else if (b >= '0' && b <= '9') {
          positive = true;
          n = b - '0';
          break;
        }
      }
      while (true) {
        byte b = this.buffer[this.pos++];
        if (b >= '0' && b <= '9') n = n * 10 + b - '0';
        else if (b == '.') break;
        else return positive ? n : -n;
      }
      long m = 0;
      long o = 1;
      while (true) {
        byte b = this.buffer[this.pos++];
        if (b >= '0' && b <= '9') {
          m = m * 10 + b - '0';
          o *= 10;
        } else {
          double d = n + (double) m / o;
          return positive ? d : -d;
        }
      }
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