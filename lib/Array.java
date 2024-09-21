public class Array {
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