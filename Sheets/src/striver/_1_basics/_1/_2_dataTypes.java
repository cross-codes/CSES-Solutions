package striver._1_basics._1;

public class _2_dataTypes {
  public static int sizeof(String datatype) {
    switch (datatype) {
      case "Integer":
        return (Integer.SIZE / 8);

      case "Long":
        return (Long.SIZE / 8);

      case "Float":
        return (Float.SIZE / 8);

      case "Double":
        return (Double.SIZE / 8);

      case "Character":
        return (Character.SIZE / 16);

      default:
        return -1;
    }
  }

  public static int dataTypes(String type) {
    return sizeof(type);
  }
}
