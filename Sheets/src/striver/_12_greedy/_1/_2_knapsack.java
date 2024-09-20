package striver._12_greedy._1;

import java.util.Arrays;
import java.util.Comparator;

class Item {
  int value, weight;

  Item(int x, int y) {
    this.value = x;
    this.weight = y;
  }
}

public class _2_knapsack {
  public static double fractionalKnapsack(int w, Item arr[], int n) {
    // Sort the items by value/weight ratio (decreasing)
    Arrays.sort(
        arr,
        new Comparator<Item>() {
          @Override
          public int compare(Item item1, Item item2) {
            double toCompare1 = (double) item1.value / item1.weight;
            double toCompare2 = (double) item2.value / item2.weight;
            if (toCompare1 < toCompare2) return 1;
            else return -1;
          }
        });
    double totalVal = 0;
    long currWeight = 0;
    for (int i = 0; i < n; i++) {
      Item currItem = arr[i];
      if (currWeight >= w) break;
      else if (w - currWeight >= currItem.weight) {
        totalVal += currItem.value;
        currWeight += currItem.weight;
      } else {
        double fraction = (double) currItem.value * (w - currWeight) / currItem.weight;
        totalVal += fraction;
        currWeight = w;
      }
    }

    return totalVal;
  }
}
