package striver._8_bitManipulation._2;

public class _1_minBitFlips {
  static int bitAtPos(int num, int pos) {
    int mask = 1 << pos;
    if ((num & mask) == 0) return 0;
    else return 1;
  }

  public static int minBitFlips(int start, int goal) {
    int ans = 0;
    for (int idx = 0; idx < 32; idx++) {
      if (bitAtPos(start, idx) != bitAtPos(goal, idx)) ans++;
    }

    return ans;
  }
}
