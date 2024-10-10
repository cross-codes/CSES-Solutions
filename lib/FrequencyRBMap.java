import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FrequencyRBMap extends TreeMap<Integer, Integer> {
  public FrequencyRBMap() {
    super();
  }

  public FrequencyRBMap(Comparator<? super Integer> comparator) {
    super(comparator);
  }

  public boolean increaseOrAdd(Integer key) {
    if (key == null) return false;
    this.merge(key, 1, Integer::sum);
    return true;
  }

  public boolean decreaseOrRemove(Integer key) {
    if (key == null) return false;
    return this.computeIfPresent(key, (k, v) -> v == 1 ? null : v - 1) != null;
  }

  public Integer getMostFrequentKey() {
    return this.entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse(null);
  }

  public Integer getLeastFrequentKey() {
    return this.entrySet().stream()
        .min(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse(null);
  }

  public Set<Integer> higherKeys(int threshold) {
    return this.entrySet().stream()
        .filter(entry -> entry.getValue() > threshold)
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());
  }

  @Override
  public int size() {
    return this.values().stream().mapToInt(Integer::intValue).sum();
  }
}