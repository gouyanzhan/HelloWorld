package com.siwuxie095.forme.copy;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @author Jiajing Li
 * @date 2019-04-28 16:37:59
 */
public class MyLinkedHashMap<K, V> extends MyHashMap<K, V> implements MyMap<K, V> {

    transient MyLinkedHashMap.Entry<K, V> head;

    transient MyLinkedHashMap.Entry<K, V> tail;

    final boolean accessOrder;

    public MyLinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        accessOrder = false;
    }

    public MyLinkedHashMap(int initialCapacity) {
        super(initialCapacity);
        accessOrder = false;
    }

    public MyLinkedHashMap() {
        super();
        accessOrder = false;
    }

    public MyLinkedHashMap(MyMap<? extends K, ? extends V> m) {
        super();
        accessOrder = false;
        putMapEntries(m, false);
    }

    public MyLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor);
        this.accessOrder = accessOrder;
    }

    private void linkNodeLast(MyLinkedHashMap.Entry<K, V> p) {
        MyLinkedHashMap.Entry<K, V> last = tail;
        tail = p;
        if (null == last) {
            head = p;
        } else {
         p.before = last;
         last.after = p;
        }
    }

    private void transferLinks(MyLinkedHashMap.Entry<K, V> src, MyLinkedHashMap.Entry<K, V> dst) {
        MyLinkedHashMap.Entry<K, V> b = dst.before = src.before;
        MyLinkedHashMap.Entry<K, V> a = dst.after = src.after;
        if (null == b) {
            head = dst;
        } else {
            b.after = dst;
        }
        if (null == a) {
            tail = dst;
        } else {
            a.before = dst;
        }
    }

    @Override
    void reinitialize() {
        super.reinitialize();
        head = tail = null;
    }

    @Override
    Node<K, V> newNode(int hash, K key, V value, Node<K, V> e) {
        MyLinkedHashMap.Entry<K, V> p = new MyLinkedHashMap.Entry<>(hash, key, value, e);
        linkNodeLast(p);
        return p;
    }

    @Override
    Node<K, V> replacementNode(Node<K, V> p, Node<K, V> next) {
        MyLinkedHashMap.Entry<K, V> q = (MyLinkedHashMap.Entry<K, V>) p;
        MyLinkedHashMap.Entry<K, V> t = new MyLinkedHashMap.Entry<>(q.hash, q.key, q.value, next);
        transferLinks(q, t);
        return t;
    }

    @Override
    TreeNode<K, V> newTreeNode(int hash, K key, V value, Node<K, V> next) {
        TreeNode<K, V> p = new TreeNode<>(hash, key, value, next);
        linkNodeLast(p);
        return p;
    }

    @Override
    TreeNode<K, V> replacementTreeNode(Node<K, V> p, Node<K, V> next) {
        MyLinkedHashMap.Entry<K, V> q = (MyLinkedHashMap.Entry<K, V>) p;
        TreeNode<K, V> t = new TreeNode<>(q.hash, q.key, q.value, next);
        transferLinks(q, t);
        return t;
    }

    @Override
    void afterNodeRemoval(Node<K, V> e) {
        MyLinkedHashMap.Entry<K, V> p = (MyLinkedHashMap.Entry<K, V>) e;
        MyLinkedHashMap.Entry<K, V> b = p.before;
        MyLinkedHashMap.Entry<K, V> a = p.after;
        p.before = p.after = null;
        if (null == b) {
            head = a;
        } else {
            b.after = a;
        }
        if (null == a) {
            tail = b;
        } else {
            a.before = b;
        }
    }

    @Override
    void afterNodeInsertion(boolean evict) {
        MyLinkedHashMap.Entry<K, V> first;
        if (evict && null != (first = head) && removeEldestEntry(first)) {
            K key = first.key;
            removeNode(hash(key), key, null, false, true);
        }
    }

    protected boolean removeEldestEntry(MyMap.Entry<K, V> eldest) {
        return false;
    }

    @Override
    void afterNodeAccess(Node<K, V> e) {
        MyLinkedHashMap.Entry<K, V> last;
        if (accessOrder && (last = tail) != e) {
            MyLinkedHashMap.Entry<K, V> p = (MyLinkedHashMap.Entry<K, V>) e;
            MyLinkedHashMap.Entry<K, V> b = p.before;
            MyLinkedHashMap.Entry<K, V> a = p.after;
            p.after = null;
            if (null == b) {
                head = a;
            } else {
                b.after = a;
            }
            if (null != a) {
                a.before = b;
            } else {
                last = b;
            }
            if (null == last) {
                head = p;
            } else {
                p.before = last;
                last.after = p;
            }
            tail = p;
            modCount++;
        }
    }

    @Override
    void internalWriteEntries(ObjectOutputStream stream) throws IOException {
        for (MyLinkedHashMap.Entry<K, V> e = head; null != e; e = e.after) {
            stream.writeObject(e.key);
            stream.writeObject(e.value);
        }
    }

    @Override
    public boolean containsValue(Object value) {
        for (MyLinkedHashMap.Entry<K, V> e = head; null != e; e = e.after) {
            V v = e.value;
            if (v == value || (null != value && value.equals(e))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Node<K, V> e;
        if (null == (e = getNode(hash(key), key))) {
            return null;
        }
        if (accessOrder) {
            afterNodeAccess(e);
        }
        return e.value;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        Node<K, V> e;
        if (null == (e = getNode(hash(key), key))) {
            return defaultValue;
        }
        if (accessOrder) {
            afterNodeAccess(e);
        }
        return e.value;
    }

    @Override
    public void clear() {
        super.clear();
        head = tail = null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> ks = keySet;
        if (null == ks) {
            ks = new LinkedKeySet();
            keySet = ks;
        }
        return ks;
    }

    @Override
    public Collection<V> values() {
        Collection<V> vs = values;
        if (null == vs) {
            vs = new LinkedValues();
            values = vs;
        }
        return vs;
    }

    @Override
    public Set<MyMap.Entry<K, V>> entrySet() {
        Set<MyMap.Entry<K, V>> es;
        return null == (es = entrySet) ? entrySet = new LinkedEntrySet() : es;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        if (null == action) {
            throw new NullPointerException();
        }
        int mc = modCount;
        for (MyLinkedHashMap.Entry<K, V> e = head; null != e; e = e.after) {
            action.accept(e.key, e.value);
        }
        if (modCount != mc) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        if (null == function) {
            throw new NullPointerException();
        }
        int mc = modCount;
        for (MyLinkedHashMap.Entry<K, V> e = head; null != e; e = e.after) {
            e.value = function.apply(e.key, e.value);
        }
        if (modCount != mc) {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * 第一个内部类 Entry
     */
    static class Entry<K, V> extends MyHashMap.Node<K, V> {
        Entry<K, V> before;
        Entry<K, V> after;
        Entry(int hash, K key, V value, Node<K, V> next) {
            super(hash, key, value, next);
        }
    }

    /**
     * 第二个内部类
     */
    final class LinkedKeySet extends AbstractSet<K> {

        @Override
        public final int size() {
            return size;
        }

        @Override
        public final void clear() {
            MyLinkedHashMap.this.clear();
        }

        @Override
        public final Iterator<K> iterator() {
            return new LinkedKeyIterator();
        }

        @Override
        public final boolean contains(Object o) {
            return containsKey(o);
        }

        @Override
        public final boolean remove(Object key) {
            return null != removeNode(hash(key), key, null, false, true);
        }

        @Override
        public final Spliterator<K> spliterator() {
            return Spliterators.spliterator(this, Spliterator.SIZED | Spliterator.ORDERED | Spliterator.DISTINCT);
        }

        @Override
        public final void forEach(Consumer<? super K> action) {
            if (null == action) {
                throw new NullPointerException();
            }
            int mc = modCount;
            for (MyLinkedHashMap.Entry<K, V> e = head; null != e; e = e.after) {
                action.accept(e.key);
            }
            if (modCount != mc) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * 第三个内部类
     */
    final class LinkedValues extends AbstractCollection<V> {

        @Override
        public final int size() {
            return size;
        }

        @Override
        public final void clear() {
            MyLinkedHashMap.this.clear();
        }

        @Override
        public final Iterator<V> iterator() {
            return new LinkedValueIterator();
        }

        @Override
        public final boolean contains(Object o) {
            return containsValue(o);
        }

        @Override
        public final Spliterator<V> spliterator() {
            return Spliterators.spliterator(this, Spliterator.SIZED | Spliterator.ORDERED);
        }

        @Override
        public final void forEach(Consumer<? super V> action) {
            if (null == action) {
                throw new NullPointerException();
            }
            int mc = modCount;
            for (MyLinkedHashMap.Entry<K, V> e = head; null != e; e = e.after) {
                action.accept(e.value);
            }
            if (modCount != mc) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * 第四个内部类
     */
    final class LinkedEntrySet extends AbstractSet<MyMap.Entry<K, V>> {

        @Override
        public final int size() {
            return size;
        }

        @Override
        public final void clear() {
            MyLinkedHashMap.this.clear();
        }

        @Override
        public final Iterator<MyMap.Entry<K, V>> iterator() {
            return new LinkedEntryIterator();
        }

        @Override
        public final boolean contains(Object o) {
            if (!(o instanceof MyMap.Entry)) {
                return false;
            }
            MyMap.Entry<?, ?> e = (MyMap.Entry<?, ?>) o;
            Object key = e.getKey();
            Node<K, V> candidate = getNode(hash(key), key);
            return null != candidate && candidate.equals(e);
        }

        @Override
        public final boolean remove(Object o) {
            if (o instanceof MyMap.Entry) {
                MyMap.Entry<?, ?> e = (MyMap.Entry<?, ?>) o;
                Object key = e.getKey();
                Object value = e.getValue();
                return null != removeNode(hash(key), key, value, true, true);
            }
            return false;
        }

        @Override
        public final Spliterator<MyMap.Entry<K, V>> spliterator() {
            return Spliterators.spliterator(this, Spliterator.SIZED | Spliterator.ORDERED | Spliterator.DISTINCT);
        }

        @Override
        public final void forEach(Consumer<? super MyMap.Entry<K, V>> action) {
            if (null == action) {
                throw new NullPointerException();
            }
            int mc = modCount;
            for (MyLinkedHashMap.Entry<K, V> e = head; null != e; e = e.after) {
                action.accept(e);
            }
            if (modCount != mc) {
                throw new ConcurrentModificationException();
            }
        }

    }

    /**
     * 第五个内部类 LinkedHashIterator
     */
    abstract class LinkedHashIterator {
        MyLinkedHashMap.Entry<K, V> next;
        MyLinkedHashMap.Entry<K, V> current;
        int expectedModCount;

        LinkedHashIterator() {
            next = head;
            expectedModCount = modCount;
            current = null;
        }

        public final boolean hasNext() {
            return null != next;
        }

        final MyLinkedHashMap.Entry<K, V> nextNode() {
            MyLinkedHashMap.Entry<K, V> e = next;
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (null == e) {
                throw new NoSuchElementException();
            }
            current = e;
            next = e.after;
            return e;
        }

        public final void remove() {
            Node<K, V> p = current;
            if (null == p) {
                throw new IllegalStateException();
            }
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            current = null;
            K key = p.key;
            removeNode(hash(key), key, null, false, false);
            expectedModCount = modCount;
        }

    }

    /**
     * 第六个内部类 LinkedKeyIterator
     */
    final class LinkedKeyIterator extends LinkedHashIterator implements Iterator<K> {

        @Override
        public final K next() {
            return nextNode().getKey();
        }

    }

    /**
     * 第七个内部类 LinkedValueIterator
     */
    final class LinkedValueIterator extends LinkedHashIterator implements Iterator<V> {

        @Override
        public final V next() {
            return nextNode().value;
        }

    }

    /**
     * 第八个内部类 LinkedEntryIterator
     */
    final class LinkedEntryIterator extends LinkedHashIterator implements Iterator<MyMap.Entry<K, V>> {

        @Override
        public final MyMap.Entry<K, V> next() {
            return nextNode();
        }
    }

}
