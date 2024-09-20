package neetcode.practice.Greedy;

public class _4_gasStation {
  public static int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int[] minFuelsToShowUpWith = new int[n];

    for (int i = 0; i < n; i++) {
      int diff = cost[i] - gas[i];
      if (diff < 0) minFuelsToShowUpWith[i] = 0;
      else minFuelsToShowUpWith[i] = diff;
    }

    for (int i = 0; i < n; i++) {
      if (minFuelsToShowUpWith[i] != 0) continue;
      else {
        int currFuel = gas[i], pos = i;
        currFuel -= cost[i];
        if (pos == n - 1) pos = 0;
        else pos++;

        while (pos != i) {
          currFuel = currFuel + gas[pos] - cost[pos];
          if (currFuel < 0) break;
          if (pos == n - 1) pos = 0;
          else pos++;
        }

        if (pos == i) return i;
      }
    }

    return -1;
  }
}
