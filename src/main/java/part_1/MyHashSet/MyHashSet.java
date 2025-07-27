package part_1.MyHashSet;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashSet<K> implements Iterable<K> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<K>[] buckets;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = (Node<K>[]) new Node[DEFAULT_CAPACITY];
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public boolean add(K value) {
        int index = getIndex(value);
        Node<K> curr = buckets[index];
        while (curr != null) {
            if (value == null ? curr.value == null : value.equals(curr.value)) {
                return false;
            }
            curr = curr.next;
        }
        buckets[index] = new Node<>(value, buckets[index]);
        size++;

        if ((float) size / buckets.length > LOAD_FACTOR) {
            resize();
        }
        return true;
    }
//
    public boolean contains(K value) {
        int index = getIndex(value);
        Node<K> curr = buckets[index];
        while (curr != null) {
            if (value == null ? curr.value == null : value.equals(curr.value)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean remove(K value) {
        int index = getIndex(value);
        Node<K> prev = null;
        Node<K> curr = buckets[index];
        while (curr != null) {
            if (value == null ? curr.value == null : value.equals(curr.value)) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }

    private int getIndex(K value) {
        return (value == null ? 0 : Math.abs(value.hashCode())) % buckets.length;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K>[] oldBuckets = buckets;
        buckets = (Node<K>[]) new Node[oldBuckets.length * 2];
        size = 0;
        for (Node<K> nodeList : oldBuckets) {
            while (nodeList != null) {
                add(nodeList.value);
                nodeList = nodeList.next;
            }
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int bucketIndex = 0;
            Node<K> currentNode = getNextNonEmptyBucket();

            private Node<K> getNextNonEmptyBucket() {
                while (bucketIndex < buckets.length && buckets[bucketIndex] == null) {
                    bucketIndex++;
                }
                return (bucketIndex < buckets.length) ? buckets[bucketIndex] : null;
            }

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public K next() {
                if (currentNode == null) throw new NoSuchElementException();
                K value = currentNode.value;
                currentNode = currentNode.next;
                if (currentNode == null) {
                    bucketIndex++;
                    currentNode = getNextNonEmptyBucket();
                }
                return value;
            }
        };
    }
}
