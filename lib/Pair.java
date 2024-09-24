import java.util.Objects;

public class Pair<K extends Comparable<K>, V extends Comparable<V>>
    implements Comparable<Pair<K, V>> {
  public K key;
  public V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public int compareTo(Pair<K, V> other) {
    int cmp = this.key.compareTo(other.key);
    if (cmp == 0) return this.value.compareTo(other.value);
    else return cmp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pair)) return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return Objects.equals(this.key, pair.key) && Objects.equals(this.value, pair.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.key, this.value);
  }
}