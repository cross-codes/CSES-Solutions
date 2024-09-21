public class Random {
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