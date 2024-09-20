package neetcode.practice.Stack;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Deque;

public class _5_dailyTemperatures {
  public record Pair<K, V>(K key, V value) {}

  public static int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] ans = new int[n];

    Deque<Pair<Integer, Integer>> stack = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      int t = temperatures[i];

      while (!stack.isEmpty() && t > stack.peek().key()) {
        Pair<Integer, Integer> pair = stack.pop();
        ans[pair.value()] = i - pair.value();
      }

      stack.push(new Pair<>(t, i));
    }

    return ans;
  }

  public static int[] dailyTemperaturesAlternate(int[] temperatures) {
    int n = temperatures.length;
    int[] ans = new int[n];

    Deque<AbstractMap.SimpleEntry<Integer, Integer>> stack = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      int t = temperatures[i];

      while (!stack.isEmpty() && t > stack.peek().getKey()) {
        AbstractMap.SimpleEntry<Integer, Integer> pair = stack.pop();
        ans[pair.getValue()] = i - pair.getValue();
      }

      stack.push(new AbstractMap.SimpleEntry<>(t, i));
    }

    return ans;
  }
}
