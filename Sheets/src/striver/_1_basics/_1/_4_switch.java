package striver._1_basics._1;

public class _4_switch {
  public static double areaOfCirlce(double r) {
    return Math.PI * r * r;
  }

  public static double areaOfRectange(double l, double w) {
    return l * w;
  }

  public static double areaSwitchCase(int ch, double[] a) {
    switch (ch) {
      case 1:
        return areaOfCirlce(a[0]);

      case 2:
        return areaOfRectange(a[0], a[1]);

      default:
        return -1.0;
    }
  }
}
