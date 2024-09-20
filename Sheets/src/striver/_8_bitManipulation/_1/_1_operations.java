package striver._8_bitManipulation._1;

public class _1_operations {
  public static void bitManipulation(int num, int i) {
    // Obtain the i'th bit using a mask
    int mask = 1 << (i - 1);

    int currentBit = -1;

    if ((num & mask) != 0) currentBit = 1;
    else currentBit = 0;

    System.out.print(currentBit + " ");

    if (currentBit == 0) {
      // Setting will increase the number by 2^(i - 1)
      System.out.print((num | mask) + " ");
    } else System.out.print(num + " ");

    if (currentBit == 1) {
      // Clearing will decrease the number by 2^(i - 1)
      System.out.println((num & ~mask));
    } else System.out.println(num);
  }

  public static void main(String[] args) {
    bitManipulation(678883006, 16);
  }
}
