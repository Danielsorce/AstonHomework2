package part_1.MyArrayList;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<V> {
    public Object[] values;
    private final int DEFAULT_CAPACITY = 5;
    private int size = 0;
    private int capacity;

    public MyArrayList() {
        values = new Object[DEFAULT_CAPACITY];
    }

    public void add(V element) {
        ensureCapacity(size + 1);
        values[size++] = element;
    }

    public V get(int index) {
        checkIndex(index);
        @SuppressWarnings("не выбрано")
        V element = (V)values[index];
        return element;
    }

    public V remove (int index) {
        checkIndex(index);
        @SuppressWarnings("не выбрано")
        V removed = (V)values[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(values, index + 1, values, index, numMoved);
        }
        values[--size] = null;
        return removed;
    }

    public void set(int index, V element) {
        checkIndex(index);
        values[index] = element;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(values, null);
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Введен индекс меньше 0 либо больше заданного массива");
        }
    }

    public void addAll(Collection<? extends V> collection) {
        collection.forEach(a -> add((V)a));
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > values.length) {
            int newCapacity = Math.max(values.length * 2, minCapacity);
            values = Arrays.copyOf(values, newCapacity);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int index = 0; index < size; index++) {
            if (index != 0) {
                sb.append(", ");
            }
            sb.append(values[index]);
        }
        sb.append("]");
        return sb.toString();
    }
}
