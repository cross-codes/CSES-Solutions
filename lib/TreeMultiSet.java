import java.util.Comparator;
import java.util.TreeMap;

public class TreeMultiSet<E> {
  public TreeMap<E, Integer> mult;

  public TreeMultiSet() {
    this.mult = new TreeMap<E, Integer>();
  }

  public TreeMultiSet(Comparator<? super E> comparator) {
    this.mult = new TreeMap<E, Integer>(comparator);
  }

  public boolean add(E e) {
    try {
      this.mult.put(e, this.mult.getOrDefault(e, 0) + 1);
      return true;
    } catch (Throwable t) {
      t.printStackTrace(System.err);
      return false;
    }
  }

  public E ceiling(E e) {
    return this.mult.ceilingKey(e);
  }

  public void clear() {
    this.mult.clear();
  }

  @Override
  public Object clone() {
    return this.mult.clone();
  }

  public Comparator<? super E> comparator() {
    return this.mult.comparator();
  }

  public boolean contains(Object o) {
    Integer cnt = this.mult.get(o);
    if (cnt != null && cnt > 0) return true;
    else return false;
  }

  public E first() {
    return this.mult.firstKey();
  }

  public E floor(E e) {
    return this.mult.floorKey(e);
  }

  public E higher(E e) {
    return this.mult.higherKey(e);
  }

  public boolean isEmpty() {
    return this.mult.size() == 0;
  }

  public E last() {
    return this.mult.lastKey();
  }

  public E lower(E e) {
    return this.mult.lowerKey(e);
  }

  public boolean remove(E e) {
    if (!this.mult.containsKey(e)) return false;

    Integer cnt = this.mult.get(e);
    if (cnt == 1) this.mult.remove(e);
    else this.mult.put(e, --cnt);
    return true;
  }
}