import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class StickLengths implements Runnable {

  InputReader in;
  OutputWriter out;

  public static void main(String[] args) {
    new Thread(null, new StickLengths(), "", 256 * (1L << 20)).start();
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
    int[] arr = in.readIntegerArray(in.nextInt());
    Arrays.sort(arr);

    long median = arr[(arr.length - 1) / 2], res = 0;

    for (int i = 0; i < arr.length; i++) res += Math.abs(arr[i] - median);

    out.append(res).appendNewLine();
  }

  @FunctionalInterface
  static interface Procedure {
    void run();
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

  static class Array {
    private Array() {}

    public static void sort(int[] array) {
      int bits = 4;
      int radix = 1 << bits;
      int[][] buckets = new int[radix][array.length];
      int[] size = new int[radix];
      for (int e : array) {
        int index = e & radix - 1;
        buckets[index][size[index]++] = e;
      }
      int[][] newBuckets = new int[radix][array.length];
      for (int i = bits; i < Integer.SIZE; i += bits) {
        int[] newSize = new int[radix];
        for (int j = 0; j < radix; j++) {
          for (int k = 0; k < size[j]; k++) {
            int index = buckets[j][k] >>> i & radix - 1;
            newBuckets[index][newSize[index]++] = buckets[j][k];
          }
        }
        int[][] temp = buckets;
        buckets = newBuckets;
        newBuckets = temp;
        size = newSize;
      }
      {
        int i = 0;
        for (int j = radix >> 1; j < radix; j++) {
          for (int k = 0; k < size[j]; k++) array[i++] = buckets[j][k];
        }
        for (int j = 0; j < radix >> 1; j++) {
          for (int k = 0; k < size[j]; k++) array[i++] = buckets[j][k];
        }
      }
    }

    public static <T> void shuffle(int[] array) {
      for (int i = array.length; i > 1; i--) swap(array, Random.nextInt(i), i - 1);
    }

    public static <T> void shuffle(T[] array) {
      for (int i = array.length; i > 1; i--) swap(array, Random.nextInt(i), i - 1);
    }

    public static void swap(byte[] array, int i, int j) {
      byte temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }

    public static void swap(int[] array, int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }

    public static <T> void swap(T[] array, int i, int j) {
      T temp = array[i];
      array[i] = array[j];
      array[j] = temp;
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
          swap(array, index, length);
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
          swap(array, index, length);
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