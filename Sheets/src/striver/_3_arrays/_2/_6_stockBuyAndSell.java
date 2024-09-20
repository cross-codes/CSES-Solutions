package striver._3_arrays._2;

public class _6_stockBuyAndSell {
  static int minOf(int a, int b) {
    return (a > b) ? b : a;
  }

  static int maxOf(int a, int b) {
    return (a > b) ? a : b;
  }

  public static int maxProfit(int[] arr) {
    int maximumProfit = 0, minPrice = Integer.MAX_VALUE, len = arr.length;
    for (int idx = 0; idx < len; idx++) {
      minPrice = minOf(minPrice, arr[idx]);
      maximumProfit = maxOf(maximumProfit, arr[idx] - minPrice);
    }
    return (maximumProfit < 0) ? 0 : maximumProfit;
  }
}
