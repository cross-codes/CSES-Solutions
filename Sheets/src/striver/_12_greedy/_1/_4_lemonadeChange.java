package striver._12_greedy._1;

public class _4_lemonadeChange {
  public static boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;
    for (int bill : bills) {
      if (five < 0 || ten < 0) return false;
      if (bill == 5) five++;
      else if (bill == 10) {
        five--;
        ten++;
      } else {
        if (ten >= 1 && five >= 1) {
          ten--;
          five--;
        } else {
          five -= 3;
        }
      }
    }

    if (five < 0 || ten < 0) return false;
    return true;
  }
}
