@FunctionalInterface
interface IntegerBiConsumer {
  void accept(int t, int u);
}

@FunctionalInterface
interface IntegerBiFunction {
  int apply(int a, int b);
}

@FunctionalInterface
interface IntegerXBiConsumer<U> {
  void accept(int t, U u);
}

class OptionalInteger {
  private int value;
  private boolean present;

  public OptionalInteger() {}

  public OptionalInteger(int value) {
    set(value);
  }

  public int get() {
    return value;
  }

  public boolean isPresent() {
    return present;
  }

  public void set(int value) {
    this.value = value;
    present = true;
  }

  public void clear() {
    present = false;
  }
}

public class IntegerAVLTreeMap {
  private Entry root;
  private int size;
  private final OptionalInteger optionalValue = new OptionalInteger();

  public int size() {
    return size;
  }

  public void forEach(IntegerBiConsumer biConsumer) {
    forEach(root, biConsumer);
  }

  private void forEach(Entry entry, IntegerBiConsumer biConsumer) {
    if (entry != null) {
      forEach(entry.left, biConsumer);
      biConsumer.accept(entry.key, entry.value);
      forEach(entry.right, biConsumer);
    }
  }

  public void put(int k, int v) {
    merge(k, v, (v1, v2) -> v2);
  }

  public void merge(int k, int v, IntegerBiFunction remappingFunction) {
    if (size == 0) {
      root = new Entry(k, v, null);
      size = 1;
    } else {
      Entry entry = root;
      Entry child;
      while (true) {
        if (k < entry.key) {
          if (entry.left == null) {
            entry.left = new Entry(k, v, entry);
            child = entry.left;
            break;
          } else entry = entry.left;
        } else if (k > entry.key) {
          if (entry.right == null) {
            entry.right = new Entry(k, v, entry);
            child = entry.right;
            break;
          } else entry = entry.right;
        } else {
          entry.value = remappingFunction.apply(entry.value, v);
          return;
        }
      }
      for (; entry != null; child = entry, entry = entry.parent) {
        if (entry.left == child) {
          if (entry.balanceFactor == 1) {
            if (child.balanceFactor == 1) rotateLL(entry, child);
            else rotateLR(entry, child, child.right);
            break;
          } else if (++entry.balanceFactor == 0) break;
        } else {
          if (entry.balanceFactor == -1) {
            if (child.balanceFactor == -1) rotateRR(entry, child);
            else rotateRL(entry, child, child.left);
            break;
          } else if (--entry.balanceFactor == 0) break;
        }
      }
      size++;
    }
  }

  public int get(int k) {
    return getOrDefault(k, 0);
  }

  public int getOrDefault(int k, int defaultValue) {
    for (Entry entry = root; entry != null; ) {
      if (k < entry.key) entry = entry.left;
      else if (k > entry.key) entry = entry.right;
      else return entry.value;
    }
    return defaultValue;
  }

  public void computeForFloor(int k, IntegerXBiConsumer<OptionalInteger> remappingConsumer) {
    Entry floor;
    for (Entry entry = root; ; entry = entry.left) {
      if (entry == null) {
        optionalValue.clear();
        remappingConsumer.accept(0, optionalValue);
        return;
      }
      if (k >= entry.key) {
        if (k == entry.key) {
          compute(entry, remappingConsumer);
          return;
        } else {
          floor = entry;
          break;
        }
      }
    }
    for (Entry entry = floor.right; entry != null; ) {
      if (k < entry.key) entry = entry.left;
      else if (k > entry.key) {
        floor = entry;
        entry = entry.right;
      } else {
        floor = entry;
        break;
      }
    }
    compute(floor, remappingConsumer);
  }

  private void compute(Entry entry, IntegerXBiConsumer<OptionalInteger> remappingConsumer) {
    optionalValue.set(entry.value);
    remappingConsumer.accept(entry.key, optionalValue);
    if (optionalValue.isPresent()) entry.value = optionalValue.get();
    else remove(entry);
  }

  private void remove(Entry entry) {
    size--;
    if (entry.left != null && entry.right != null) {
      Entry next = entry.right;
      while (next.left != null) next = next.left;
      entry.key = next.key;
      entry.value = next.value;
      entry = next;
    } else if (entry == root) {
      root = entry.left == null ? entry.right : entry.left;
      return;
    }
    Entry removed = entry;
    Entry child = entry;
    for (entry = entry.parent; entry != null; child = entry, entry = entry.parent) {
      if (entry.left == child) {
        if (entry.balanceFactor == -1) {
          child = entry.right;
          if (child.balanceFactor == -1) {
            rotateRR(entry, child);
            entry = child;
          } else if (child.balanceFactor == 0) {
            rotateRO(entry, child);
            break;
          } else {
            Entry grandchild = child.left;
            rotateRL(entry, child, grandchild);
            entry = grandchild;
          }
        } else if (entry.balanceFactor-- == 0) break;
      } else {
        if (entry.balanceFactor == 1) {
          child = entry.left;
          if (child.balanceFactor == 1) {
            rotateLL(entry, child);
            entry = child;
          } else if (child.balanceFactor == 0) {
            rotateLO(entry, child);
            break;
          } else {
            Entry grandchild = child.right;
            rotateLR(entry, child, grandchild);
            entry = grandchild;
          }
        } else if (entry.balanceFactor++ == 0) break;
      }
    }
    child = removed.left == null ? removed.right : removed.left;
    if (removed.parent.left == removed) removed.parent.left = child;
    else removed.parent.right = child;
    if (child != null) child.parent = removed.parent;
  }

  private void rotateLL(Entry entry, Entry child) {
    entry.balanceFactor = 0;
    child.balanceFactor = 0;
    replaceAsChild(entry, child);
    setNullableLeftChild(entry, child.right);
    setNonNullRightChild(child, entry);
  }

  private void rotateLO(Entry entry, Entry child) {
    entry.balanceFactor = 1;
    child.balanceFactor = -1;
    replaceAsChild(entry, child);
    setNonNullLeftChild(entry, child.right);
    setNonNullRightChild(child, entry);
  }

  private void rotateLR(Entry entry, Entry child, Entry grandchild) {
    if (grandchild.balanceFactor == -1) {
      entry.balanceFactor = 0;
      child.balanceFactor = 1;
      setNonNullLeftChild(entry, grandchild.right);
      setNullableRightChild(child, grandchild.left);
    } else if (grandchild.balanceFactor == 0) {
      entry.balanceFactor = 0;
      child.balanceFactor = 0;
      setNullableLeftChild(entry, grandchild.right);
      setNullableRightChild(child, grandchild.left);
    } else {
      entry.balanceFactor = -1;
      child.balanceFactor = 0;
      setNullableLeftChild(entry, grandchild.right);
      setNonNullRightChild(child, grandchild.left);
    }
    grandchild.balanceFactor = 0;
    replaceAsChild(entry, grandchild);
    setNonNullRightChild(grandchild, entry);
    setNonNullLeftChild(grandchild, child);
  }

  private void rotateRR(Entry entry, Entry child) {
    entry.balanceFactor = 0;
    child.balanceFactor = 0;
    replaceAsChild(entry, child);
    setNullableRightChild(entry, child.left);
    setNonNullLeftChild(child, entry);
  }

  private void rotateRO(Entry entry, Entry child) {
    entry.balanceFactor = -1;
    child.balanceFactor = 1;
    replaceAsChild(entry, child);
    setNonNullRightChild(entry, child.left);
    setNonNullLeftChild(child, entry);
  }

  private void rotateRL(Entry entry, Entry child, Entry grandchild) {
    if (grandchild.balanceFactor == -1) {
      entry.balanceFactor = 1;
      child.balanceFactor = 0;
      setNullableRightChild(entry, grandchild.left);
      setNonNullLeftChild(child, grandchild.right);
    } else if (grandchild.balanceFactor == 0) {
      entry.balanceFactor = 0;
      child.balanceFactor = 0;
      setNullableRightChild(entry, grandchild.left);
      setNullableLeftChild(child, grandchild.right);
    } else {
      entry.balanceFactor = 0;
      child.balanceFactor = -1;
      setNonNullRightChild(entry, grandchild.left);
      setNullableLeftChild(child, grandchild.right);
    }
    grandchild.balanceFactor = 0;
    replaceAsChild(entry, grandchild);
    setNonNullLeftChild(grandchild, entry);
    setNonNullRightChild(grandchild, child);
  }

  private void setNonNullLeftChild(Entry entry, Entry child) {
    entry.left = child;
    child.parent = entry;
  }

  private void setNonNullRightChild(Entry entry, Entry child) {
    entry.right = child;
    child.parent = entry;
  }

  private void setNullableLeftChild(Entry entry, Entry child) {
    entry.left = child;
    if (child != null) child.parent = entry;
  }

  private void setNullableRightChild(Entry entry, Entry child) {
    entry.right = child;
    if (child != null) child.parent = entry;
  }

  private void replaceAsChild(Entry oldEntry, Entry newEntry) {
    Entry parent = oldEntry.parent;
    if (parent == null) root = newEntry;
    else if (parent.left == oldEntry) parent.left = newEntry;
    else parent.right = newEntry;
    newEntry.parent = parent;
  }

  private static class Entry {
    private int key;
    private int value;
    private Entry parent;
    private Entry left;
    private Entry right;
    private int balanceFactor;

    private Entry(int key, int value, Entry parent) {
      this.key = key;
      this.value = value;
      this.parent = parent;
    }
  }
}