package neetcode.practice.Sliding_Window;

public class _1_buyAndSellCrypto {
  public static int maxProfit(int[] prices) {
    if (prices.length == 1) return 0;

    int l = 0, r = 1, profit = 0, n = prices.length;

    while (r < n) {
      if (prices[r] <= prices[l]) {
        l = r;
        r++;
      } else {
        profit = Math.max(profit, prices[r] - prices[l]);
        r++;
      }
    }

    return (profit > 0) ? profit : 0;
  }
}
