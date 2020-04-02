package com.siwuxie095.forme.copy;

import sun.misc.SharedSecrets;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Jiajing Li
 * @date 2019-04-28 15:27:56
 */
public class MyHashMap<K, V> extends MyAbstractMap<K, V> implements MyMap<K, V>, Cloneable, Serializable {

    /**
     * 默认初始容量，aka 16，即 2^4
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 最大容量 2^30
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int TREEIFY_THRESHOLD = 8;

    static final int UNTREEIFY_THRESHOLD = 6;

    static final int MIN_TREEIFY_THRESHOLD = 64;

    static final int hash(Object key) {
        int h;
        return null == key ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c;
            Type[] ts;
            Type[] as;
            Type t;
            ParameterizedType p;
            if ((c = x.getClass()) == String.class) {
                return c;
            }
            if (null != (ts = c.getGenericInterfaces())) {
                for (int i = 0; i < ts.length; i++) {
                    if ((t = ts[i]) instanceof ParameterizedType
                            && (p = (ParameterizedType) t).getRawType() == Comparable.class
                            && null != (as = p.getActualTypeArguments())
                            && as.length == 1
                            && as[0] == c) {
                        return c;
                    }
                }
            }
        }
        return null;
    }

    static int compareComparables(Class<?> kc, Object k, Object x) {
        return null == x || x.getClass() != kc ? 0 : ((Comparable) k).compareTo(x);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n < 0 ? 1 : (n >= MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : n + 1);
    }

    transient Node<K, V>[] table;

    transient Set<MyMap.Entry<K, V>> entrySet;

    transient int size;

    transient int modCount;

    int threshold;

    final float loadFactor;

    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public MyHashMap(MyMap<? extends K, ? extends V> map) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        putMapEntries(map, false);
    }

    final void putMapEntries(MyMap<? extends K, ? extends V> map, boolean evict) {
        int size = map.size();
        if (size > 0) {
            if (null == table) {
                float ft = (float) size / loadFactor + 1.0F;
                int t = (int) ft < MAXIMUM_CAPACITY ? (int) ft : MAXIMUM_CAPACITY;
                if (t < threshold) {
                    threshold = tableSizeFor(t);
                }
            } else if (size > threshold) {
                resize();
            }
            for (MyMap.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                K key = entry.getKey();
                V value = entry.getValue();
                putVal(hash(key), key, value, false, evict);
            }
        }
    }

    final Node<K, V>[] resize() {
        Node<K, V>[] oldTab = table;
        int oldCap = null == oldTab ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap;
        int newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
                newThr = oldThr << 1;
            }
        } else if (oldThr > 0) {
            newCap = oldThr;
        } else {
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float) newCap * loadFactor;
            newThr = newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ? (int) ft : Integer.MAX_VALUE;
        }
        threshold = newThr;
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        table = newTab;
        if (null != oldTab) {
            for (int j = 0; j < oldCap; j++) {
                Node<K, V> e;
                if (null != (e = oldTab[j])) {
                    oldTab[j] = null;
                    if (null == e.next) {
                        newTab[e.hash & (newCap - 1)] = e;
                    } else if (e instanceof TreeNode) {
                        ((TreeNode<K, V>) e).split(this, newTab, j, oldCap);
                    } else {
                        Node<K, V> loHead = null;
                        Node<K, V> loTail = null;
                        Node<K, V> hiHead = null;
                        Node<K, V> hiTail = null;
                        Node<K, V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (null == loTail) {
                                    loHead = e;
                                } else {
                                    loTail.next = e;
                                }
                                loTail = e;
                            } else {
                                if (null == hiTail) {
                                    hiHead = e;
                                } else {
                                    hiTail.next = e;
                                }
                                hiTail = e;
                            }
                        } while (null != (e = next));

                        if (null != loTail) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (null != hiTail) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n;
        int i;
        if (null == (tab = table) || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }
        if (null == (p = tab[i = (n - 1) & hash])) {
            tab[i] = newNode(hash, key, value, null);
        } else {
            Node<K, V> e;
            K k;
            if (p.hash == hash && ((k = p.key) == key || (null != key && key.equals(k)))) {
                e = p;
            } else if (p instanceof TreeNode) {
                e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
            } else {
                for (int binCount = 0; ; binCount++) {
                    if (null == (e = p.next)) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) {
                            treeifyBin(tab, hash);
                        }
                        break;
                    }
                    if (e.hash == hash && ((k = e.key) == key || (null != key && key.equals(k)))) {
                        break;
                    }
                    p = e;
                }
            }
            if (null != e) {
                V oldValue = e.value;
                if (!onlyIfAbsent || null == oldValue) {
                    e.value = value;
                }
                afterNodeAccess(e);
                return oldValue;
            }
        }
        modCount++;
        if (++size > threshold) {
            resize();
        }
        afterNodeInsertion(evict);
        return null;
    }

    final void treeifyBin(Node<K, V>[] tab, int hash) {
        int n;
        int index;
        Node<K, V> e;
        if (null == tab || (n = tab.length) < MIN_TREEIFY_THRESHOLD) {
            resize();
        } else if (null != (e = tab[index = (n - 1) & hash])) {
            TreeNode<K, V> hd = null;
            TreeNode<K, V> tl = null;
            do {
                TreeNode<K, V> p =replacementTreeNode(e, null);
                if (null == tl) {
                    hd = p;
                } else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while (null != (e = e.next));
            if (null != (tab[index] = hd)) {
                hd.treeify(tab);
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(Object key) {
        Node<K, V> e;
        return null == (e = getNode(hash(key), key)) ? null : e.value;
    }

    final Node<K, V> getNode(int hash, Object key) {
        Node<K, V>[] tab;
        Node<K, V> first;
        Node<K, V> e;
        int n;
        K k;
        if (null != (tab = table) && (n = tab.length) > 0 && null != (first = tab[(n - 1) & hash])) {
            if (first.hash == hash && (((k = first.key) == key) || (null != key && key.equals(k)))) {
                return first;
            }
            if (null != (e = first.next)) {
                if (first instanceof TreeNode) {
                    return ((TreeNode<K, V>) first).getTreeNode(hash, key);
                }
                do {
                    if (e.hash == hash && ((k = e.key) == key || (null != key && key.equals(k)))) {
                        return e;
                    }
                } while (null != (e = e.next));
            }
        }
        return null;
    }


    Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }


    Node<K, V> replacementNode(Node<K, V> p, Node<K, V> next) {
        return new Node<>(p.hash, p.key, p.value, next);
    }


    TreeNode<K, V> newTreeNode(int hash, K key, V value, Node<K, V> next) {
        return new TreeNode<>(hash, key, value, next);
    }


    TreeNode<K, V> replacementTreeNode(Node<K, V> p, Node<K, V> next) {
        return new TreeNode<>(p.hash, p.key, p.value, next);
    }

    void reinitialize() {
        table = null;
        entrySet = null;
        keySet = null;
        values = null;
        modCount = 0;
        threshold = 0;
        size = 0;
    }

    void afterNodeAccess(Node<K, V> p) {}

    void afterNodeInsertion(boolean evict) {}

    void afterNodeRemoval(Node<K, V> p) {}

    @Override
    public void putAll(MyMap<? extends K, ? extends V> m) {
        putMapEntries(m, true);
    }

    @Override
    public V remove(Object key) {
        Node<K, V> e;
        return null == (e = removeNode(hash(key), key, null, false, true)) ? null : e.value;
    }

    final Node<K, V> removeNode(int hash, Object key, Object value, boolean matchValue, boolean movable) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n;
        int index;
        if (null != (tab = table) && (n = tab.length) > 0 && null != (p = tab[index = (n - 1) & hash])) {
            Node<K, V> node = null;
            Node<K, V> e;
            K k;
            V v;
            if (p.hash == hash && ((k = p.key) == key || (null != key && key.equals(k)))) {
                node = p;
            } else if (null != (e = p.next)) {
                if (p instanceof TreeNode) {
                    node = ((TreeNode<K, V>) p).getTreeNode(hash, key);
                } else {
                    do {
                        if (e.hash == hash && ((k = e.key) == key || (null != key && key.equals(k)))) {
                            node = e;
                            break;
                        }
                        p = e;
                    } while (null != (e = e.next));
                }
            }
            if (null != node && (!matchValue || (v = node.value) == value || (null != value && value.equals(v)))) {
                if (node instanceof TreeNode) {
                    ((TreeNode<K, V>) node).removeTreeNode(this, tab, movable);
                } else if (node == p) {
                    tab[index] = node.next;
                } else {
                    p.next = node.next;
                }
                modCount++;
                size--;
                afterNodeRemoval(node);
                return node;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        Node<K, V>[] tab;
        modCount++;
        if (null != (tab = table) && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; i++) {
                tab[i] = null;
            }
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return null != getNode(hash(key), key);
    }

    @Override
    public boolean containsValue(Object value) {
        Node<K, V>[] tab;
        V v;
        if (null != (tab = table) && size > 0) {
            for (int i = 0; i < tab.length; i++) {
                for (Node<K, V> e = tab[i]; null != e; e = e.next) {
                    if ((v = e.value) == value || (null != value && value.equals(v))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Set<K> keySet() {
        Set<K> ks = keySet;
        if (null == ks) {
            ks = new KeySet();
            keySet = ks;
        }
        return ks;
    }

    @Override
    public Collection<V> values() {
        Collection<V> vs = values;
        if (null == vs) {
            vs = new Values();
            values =vs;
        }
        return vs;
    }

    @Override
    public Set<MyMap.Entry<K, V>> entrySet() {
        Set<MyMap.Entry<K, V>> es;
        return null == (es = entrySet) ? (entrySet = new EntrySet()) : es;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        Node<K, V> e;
        return null == (e = getNode(hash(key), key)) ? defaultValue : e.value;
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return putVal(hash(key), key, value, true, true);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return null != removeNode(hash(key), key, value, true, true);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        Node<K, V> e;
        V v;
        if (null != (e = getNode(hash(key), key)) && ((v = e.value) == oldValue || (null != v && v.equals(oldValue)))) {
            e.value = newValue;
            afterNodeAccess(e);
            return true;
        }
        return false;
    }

    @Override
    public V replace(K key, V value) {
        Node<K, V> e;
        if (null != (e = getNode(hash(key), key))) {
            V oldValue = e.value;
            e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        if (null == mappingFunction) {
            throw new NullPointerException();
        }
        int hash = hash(key);
        Node<K, V>[] tab;
        Node<K, V> first;
        int n;
        int i;
        int binCount = 0;
        TreeNode<K, V> t = null;
        Node<K, V> old = null;
        if (size > threshold || null == (tab = table) || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }
        if (null != (first = tab[i = (n -1) & hash])) {
            if (first instanceof TreeNode) {
                old = (t = (TreeNode<K, V>) first).getTreeNode(hash, key);
            } else {
                Node<K ,V> e = first;
                K k;
                do {
                    if (e.hash == hash && ((k = e.key) == key || (null != key && key.equals(k)))) {
                        old = e;
                        break;
                    }
                    binCount++;
                } while (null != (e = e.next));
            }
            V oldValue;
            if (null != old && null != (oldValue = old.value)) {
                afterNodeAccess(old);
                return oldValue;
            }
        }
        V v = mappingFunction.apply(key);
        if (null == v) {
            return null;
        } else if (null != old) {
            old.value = v;
            afterNodeAccess(old);
            return v;
        } else if (null != t) {
            t.putTreeVal(this, tab, hash, key, v);
        } else {
            tab[i] = newNode(hash, key, v, first);
            if (binCount > TREEIFY_THRESHOLD - 1) {
                treeifyBin(tab, hash);
            }
        }
        modCount++;
        size++;
        afterNodeInsertion(true);
        return v;
    }

    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        if (null == remappingFunction) {
            throw new NullPointerException();
        }
        Node<K, V> e;
        V oldValue;
        int hash = hash(key);
        if (null != (e = getNode(hash, key)) && null != (oldValue = e.value)) {
            V v = remappingFunction.apply(key, oldValue);
            if (null != v) {
                e.value = v;
                afterNodeAccess(e);
                return v;
            } else {
                removeNode(hash, key, null, false, true);
            }
        }
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        if (null == remappingFunction) {
            throw new NullPointerException();
        }
        int hash = hash(key);
        Node<K, V>[] tab;
        Node<K, V> first;
        int n;
        int i;
        int binCount = 0;
        TreeNode<K, V> t = null;
        Node<K, V> old = null;
        if (size > threshold || null == (tab = table) || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }
        if (null != (first = tab[i = (n - 1) & hash])) {
            if (first instanceof TreeNode) {
                old = (t = (TreeNode<K, V>) first).getTreeNode(hash, key);
            } else {
                Node<K, V> e = first;
                K k;
                do {
                    if (e.hash == hash && ((k = e.key) == key || (null != key && key.equals(k)))) {
                        old = e;
                        break;
                    }
                    binCount++;
                } while (null != (e = e.next));
            }
        }
        V oldValue = null == old ? null : old.value;
        V v = remappingFunction.apply(key, oldValue);
        if (null != old) {
            if (null != v) {
                old.value = v;
                afterNodeAccess(old);
            } else {
                removeNode(hash, key, null, false, true);
            }
        } else if (null != v) {
            if (null != t) {
                t.putTreeVal(this, tab, hash, key, v);
            } else {
                tab[i] = newNode(hash, key, v, first);
                if (binCount >= TREEIFY_THRESHOLD - 1) {
                    treeifyBin(tab, hash);
                }
            }
            modCount++;
            size++;
            afterNodeInsertion(true);
        }
        return v;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        if (null == value) {
            throw new NullPointerException();
        }
        if (null == remappingFunction) {
            throw new NullPointerException();
        }
        int hash = hash(key);
        Node<K, V>[] tab;
        Node<K, V> first;
        int n;
        int i;
        int binCount = 0;
        TreeNode<K, V> t = null;
        Node<K, V> old = null;
        if (size > threshold || null == (tab = table) || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }
        if (null != (first = tab[i = (n - 1) & hash])) {
            if (first instanceof TreeNode) {
                old = (t = (TreeNode<K, V>) first).getTreeNode(hash, key);
            } else {
                Node<K, V> e = first;
                K k;
                do {
                    if (e.hash == hash && ((k = e.key) == key || (null != key && key.equals(k)))) {
                        old = e;
                        break;
                    }
                    binCount++;
                } while (null != (e = e.next));
            }
        }
        if (null != old) {
            V v;
            if (null != old.value) {
                v = remappingFunction.apply(old.value, value);
            } else {
                v = value;
            }
            if (null != v) {
                old.value = v;
                afterNodeAccess(old);
            } else {
                removeNode(hash, key, null, false, true);
            }
            return v;
        }
        if (null != value) {
            if (null != t) {
                t.putTreeVal(this, tab, hash, key, value);
            } else {
                tab[i] = newNode(hash, key, value, first);
                if (binCount >= TREEIFY_THRESHOLD - 1) {
                    treeifyBin(tab, hash);
                }
            }
            modCount++;
            size++;
            afterNodeInsertion(true);
        }
        return value;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        Node<K, V>[] tab;
        if (null == action) {
            throw new NullPointerException();
        }
        if (size > 0 && null != (tab = table)) {
            int mc = modCount;
            for (int i = 0; i < tab.length; i++) {
                for (Node<K, V> e = tab[i]; null != e; e = e.next) {
                    action.accept(e.key, e.value);
                }
            }
            if (modCount != mc) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Node<K, V>[] tab;
        if (null == function) {
            throw new NullPointerException();
        }
        if (size > 0 && null != (tab = table)) {
            int mc = modCount;
            for (int i = 0; i < tab.length; i++) {
                for (Node<K, V> e =tab[i]; null != e; e = e.next) {
                    e.value = function.apply(e.key, e.value);
                }
            }
            if (modCount != mc) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public Object clone() {
        MyHashMap<K, V> result;
        try {
            result = (MyHashMap<K, V>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
        result.reinitialize();
        result.putMapEntries(this, false);
        return result;
    }

    final float loadFactor() {
        return loadFactor;
    }

    final int capacity() {
        return null != table ? table.length : (threshold > 0 ? threshold : DEFAULT_INITIAL_CAPACITY);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        int buckets = capacity();
        stream.defaultWriteObject();
        stream.writeInt(buckets);
        stream.writeInt(size);
        internalWriteEntries(stream);
    }

    void internalWriteEntries(ObjectOutputStream stream) throws IOException {
        Node<K, V>[] tab;
        if (size > 0 && null != (tab = table)) {
            for (int i = 0; i < tab.length; i++) {
                for (Node<K, V> e = tab[i]; null != e; e = e.next) {
                    stream.writeObject(e.key);
                    stream.writeObject(e.value);
                }
            }
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        reinitialize();
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new InvalidObjectException("Illegal load factor: " + loadFactor);
        }
        stream.readInt();
        int mappings = stream.readInt();
        if (mappings < 0) {
            float lf = Math.min(Math.max(0.25f, loadFactor), 4.0f);
            float fc = (float) mappings / lf + 1.0f;
            int cap = fc < DEFAULT_INITIAL_CAPACITY ? DEFAULT_INITIAL_CAPACITY : (fc >= MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : tableSizeFor((int) fc));
            float ft = (float) cap * lf;
            threshold = cap < MAXIMUM_CAPACITY && ft < MAXIMUM_CAPACITY ? (int) ft : Integer.MAX_VALUE;

            // todo 先注释掉
            //SharedSecrets.getJavaOISAccess().checkArray(stream, MyMap.Entry[].class, cap);
            Node<K, V>[] tab = (Node<K, V>[]) new Node[cap];
            table = tab;

            for (int i = 0; i < mappings; i++) {
                K key = (K) stream.readObject();
                V value = (V) stream.readObject();
                putVal(hash(key), key, value, false, false);
            }
        }
    }

    final class KeySet extends AbstractSet<K> {

        @Override
        public final int size() {
            return size;
        }

        @Override
        public final void clear() {
            MyHashMap.this.clear();
        }

        @Override
        public final Iterator<K> iterator() {
            return null;
            // todo
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
            return null;
            // todo
        }

        @Override
        public final void forEach(Consumer<? super K> action) {
            Node<K, V>[] tab;
            if (null == action) {
                throw new NullPointerException();
            }
            if (size > 0 && null != (tab = table)) {
                int mc = modCount;
                for (int i = 0; i < tab.length; i++) {
                    for (Node<K, V> e = tab[i]; null != e; e = e.next) {
                        action.accept(e.key);
                    }
                }
                if (modCount != mc) {
                    throw new ConcurrentModificationException();
                }
            }
        }

    }

    final class Values extends AbstractCollection<V> {

        @Override
        public final int size() {
            return size;
        }

        @Override
        public final void clear() {
            MyHashMap.this.clear();
        }

        @Override
        public final Iterator<V> iterator() {
            return null;
            // todo
        }

        @Override
        public final boolean contains(Object o) {
            return containsValue(o);
        }

        @Override
        public Spliterator<V> spliterator() {
            return null;
            // todo
        }

        @Override
        public final void forEach(Consumer<? super V> action) {
            Node<K, V>[] tab;
            if (null == action) {
                throw new NullPointerException();
            }
            if (size > 0 && null != (tab = table)) {
                int mc = modCount;
                for (int i = 0; i < tab.length; i++) {
                    for (Node<K, V> e =tab[i]; null != e; e = e.next) {
                        action.accept(e.value);
                    }
                }
                if (modCount != mc) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }

    final class EntrySet extends AbstractSet<MyMap.Entry<K, V>> {

        @Override
        public final int size() {
            return size;
        }

        @Override
        public final void clear() {
            MyHashMap.this.clear();
        }

        @Override
        public final Iterator<MyMap.Entry<K, V>> iterator() {
            return null;
            // todo
        }

        @Override
        public final boolean contains(Object o) {
            if (!(o instanceof MyMap.Entry)) {
                return false;
            }
            MyMap.Entry<?, ?> e = (Entry<?, ?>) o;
            Object key = e.getKey();
            Node<K, V> candidate = getNode(hash(key), key);
            return null != candidate && candidate.equals(e);
        }

        @Override
        public final boolean remove(Object o) {
            if (o instanceof MyMap.Entry) {
                MyMap.Entry<?, ?> e = (Entry<?, ?>) o;
                Object key = e.getKey();
                Object value = e.getValue();
                return null != removeNode(hash(key), key, value, true, true);
            }
            return false;
        }

        @Override
        public final Spliterator<MyMap.Entry<K, V>> spliterator() {
            return null;
            // todo
        }

        @Override
        public final void forEach(Consumer<? super MyMap.Entry<K, V>> action) {
            Node<K, V>[] tab;
            if (null == action) {
                throw new NullPointerException();
            }
            if (size > 0 && null != (tab = table)) {
                int mc = modCount;
                for (int i = 0; i < tab.length; i++) {
                    for (Node<K, V> e = tab[i]; null != e; e = e.next) {
                        action.accept(e);
                    }
                }
                if (modCount != mc) {
                    throw new ConcurrentModificationException();
                }
            }
        }

    }

    abstract class HashIterator {
        Node<K, V> next;
        Node<K, V> current;
        int expectedModCount;
        int index;

        HashIterator() {
            expectedModCount = modCount;
            Node<K, V>[] t = table;
            current = next = null;
            index = 0;
            if (null != t && size > 0) {
                do {} while (index < t.length && null == (next = t[index++]));
            }
        }

        public final boolean hasNext() {
            return null != next;
        }

        final Node<K, V> nextNode() {
            Node<K, V>[] t;
            Node<K, V> e = next;
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (null == e) {
                throw new NoSuchElementException();
            }
            if (null == (next = (current = e)) && null != (t = table)) {
                do {} while (index < t.length && null == (next = t[index++]));
            }
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

    final class KeyIterator extends HashIterator implements Iterator<K> {

        @Override
        public final K next() {
            return nextNode().key;
        }

    }

    final class ValueIterator extends HashIterator implements Iterator<V> {

        @Override
        public final V next() {
            return nextNode().value;
        }

    }

    final class EntryIterator extends HashIterator implements Iterator<MyMap.Entry<K, V>> {

        @Override
        public final MyMap.Entry<K, V> next() {
            return nextNode();
        }

    }

    static class HashMapSpliterator<K, V> {
        final MyHashMap<K, V> map;
        Node<K, V> current;
        int index;
        int fence;
        int est;
        int expectedModCount;

        HashMapSpliterator(MyHashMap<K, V> m, int origin, int fence, int est, int expectedModCount) {
            this.map = m;
            this.index = origin;
            this.fence = fence;
            this.est = est;
            this.expectedModCount = expectedModCount;
        }

        final int getFence() {
            int hi;
            if ((hi = fence) < 0) {
                MyHashMap<K, V> m = map;
                est = m.size;
                expectedModCount = m.modCount;
                Node<K, V>[] tab = m.table;
                hi = fence = (null == tab ? 0 : tab.length);
            }
            return hi;
        }

        public final long estimateSize() {
            getFence();
            return (long) est;
        }

    }

    static final class KeySpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<K> {

        KeySpliterator(MyHashMap<K, V> m, int origin, int fence, int est, int expectedModCount) {
            super(m, origin, fence, est, expectedModCount);
        }
        @Override
        public KeySpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = index;
            int mid = (lo + hi) >>> 1;
            return (lo >= mid || null != current) ? null : new KeySpliterator<>(map, lo, index = mid, est >>>= 1, expectedModCount);
        }

        @Override
        public void forEachRemaining(Consumer<? super K> action) {
            int i;
            int hi;
            int mc;
            if (null == action) {
                throw new NullPointerException();
            }
            MyHashMap<K, V> m = map;
            Node<K, V>[] tab = m.table;
            if ((hi = fence) < 0) {
                mc = expectedModCount = m.modCount;
                hi = fence = (null == tab ? 0 : tab.length);
            } else {
                mc = expectedModCount;
            }
            if (null != tab && tab.length >= hi && (i = index) >= 0 && (i < (index = hi) || null != current)) {
                Node<K, V> p = current;
                current = null;
                do {
                    if (null == p) {
                        p = tab[i++];
                    } else {
                        action.accept(p.key);
                        p = p.next;
                    }
                } while (null != p || i < hi);
                if (m.modCount != mc) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        @Override
        public boolean tryAdvance(Consumer<? super K> action) {
            int hi;
            if (null == action) {
                throw new NullPointerException();
            }
            Node<K, V>[] tab = map.table;
            if (null != tab && tab.length >= (hi = getFence()) && index >= 0) {
                while (null != current || index < hi) {
                    if (null == current) {
                        current = tab[index++];
                    } else {
                        K k = current.key;
                        current = current.next;
                        action.accept(k);
                        if (map.modCount != expectedModCount) {
                            throw new ConcurrentModificationException();
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public int characteristics() {
            return (fence < 0 || est == map.size ? Spliterator.SIZED : 0) | Spliterator.DISTINCT;
        }

    }

    static final class ValueSpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<V> {

        ValueSpliterator(MyHashMap<K, V> m, int origin, int fence, int est, int expectedModCount) {
            super(m, origin, fence, est, expectedModCount);
        }

        @Override
        public ValueSpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = index;
            int mid = (lo + hi) >>> 1;
            return (lo >= mid || null != current) ? null : new ValueSpliterator<>(map, lo, index  = mid, est >>>= 1, expectedModCount);
        }

        @Override
        public void forEachRemaining(Consumer<? super V> action) {
            int i;
            int hi;
            int mc;
            if (null == action) {
                throw new NullPointerException();
            }
            MyHashMap<K, V> m = map;
            Node<K, V>[] tab = m.table;
            if ((hi = fence) < 0) {
                mc = expectedModCount = m.modCount;
                hi = fence = (null == tab ? 0 : tab.length);
            } else {
                mc = expectedModCount;
            }
            if (null != tab && tab.length >= hi && (i = index) >= 0 && (i < (index = hi) || null != current)) {
                Node<K ,V> p = current;
                current = null;
                do {
                    if (null == p) {
                        p = tab[i++];
                    } else {
                        action.accept(p.value);
                        p = p.next;
                    }
                } while (null != p || i < hi);
                if (m.modCount != mc) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        @Override
        public boolean tryAdvance(Consumer<? super V> action) {
            int hi;
            if (null == action) {
                throw new NullPointerException();
            }
            Node<K, V>[] tab = map.table;
            if (null != tab && tab.length >= (hi = getFence()) && index >= 0) {
                while (null != current || index < hi) {
                    if (null == current) {
                        current = tab[index++];
                    } else {
                        V v = current.value;
                        current = current.next;
                        action.accept(v);
                        if (map.modCount != expectedModCount) {
                            throw new ConcurrentModificationException();
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public int characteristics() {
            return (fence < 0 || est == map.size ? Spliterator.SIZED : 0);
        }

    }

    static final class EntrySpliterator<K, V> extends HashMapSpliterator<K, V> implements Spliterator<MyMap.Entry<K, V>> {

        EntrySpliterator(MyHashMap<K, V> m, int origin, int fence, int est, int expectedModCount) {
            super(m, origin, fence, est, expectedModCount);
        }

        @Override
        public EntrySpliterator<K, V> trySplit() {
            int hi = getFence();
            int lo = index;
            int mid = (lo + hi) >>> 1;
            return (lo >= mid || null != current) ? null : new EntrySpliterator<>(map, lo, index = mid, est >>>= 1, expectedModCount);
        }

        @Override
        public void forEachRemaining(Consumer<? super MyMap.Entry<K, V>> action) {
            int i;
            int hi;
            int mc;
            if (null == action) {
                throw new NullPointerException();
            }
            MyHashMap<K, V> m = map;
            Node<K, V>[] tab = m.table;
            if ((hi = fence) < 0) {
                mc = expectedModCount = m.modCount;
                hi = fence = (null == tab ? 0 : tab.length);
            } else {
                mc = expectedModCount;
            }
            if (null != tab && tab.length >= hi && (i = index) >= 0 && (i < (index = hi) || null != current)) {
                Node<K, V> p = current;
                current = null;
                do {
                    if (null == p) {
                        p = tab[index++];
                    } else {
                        action.accept(p);
                        p = p.next;
                    }
                } while (null != p || i < hi);
                if (m.modCount != mc) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        @Override
        public boolean tryAdvance(Consumer<? super MyMap.Entry<K, V>> action) {
            int hi;
            if (null == action) {
                throw new NullPointerException();
            }
            Node<K, V>[] tab = map.table;
            if (null != tab && tab.length >= (hi = getFence()) && index >= 0) {
                while (null != current || index < hi) {
                    if (null == current) {
                        current = tab[index++];
                    } else {
                        Node<K, V> e = current;
                        current = current.next;
                        action.accept(e);
                        if (map.modCount != expectedModCount) {
                            throw new ConcurrentModificationException();
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public int characteristics() {
            return (fence < 0 | est == map.size ? Spliterator.SIZED : 0) | Spliterator.DISTINCT;
        }

    }


    static class Node<K, V> implements MyMap.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }

        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final String toString() {
            return key + "=" + value;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof MyMap.Entry) {
                MyMap.Entry<K, V> entry = (MyMap.Entry<K, V>) obj;
                if (Objects.equals(key, entry.getKey()) && Objects.equals(value, entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

    }

    static final class TreeNode<K, V> extends MyLinkedHashMap.Entry<K, V> {

        TreeNode<K, V> parent;
        TreeNode<K, V> left;
        TreeNode<K, V> right;
        TreeNode<K, V> prev;
        boolean red;

        TreeNode(int hash, K key, V val, Node<K, V> next) {
            super(hash, key, val, next);
        }

        final TreeNode<K, V> root() {
            for (TreeNode<K, V> r = this, p;;) {
                if (null == (p = r.parent)) {
                    return r;
                }
                r = p;
            }
        }

        static <K, V> void moveRootToFront(Node<K, V>[] tab, TreeNode<K, V> root) {
            int n;
            if (null != root && null != tab && (n = tab.length) > 0) {
                int index = (n - 1) & root.hash;
                TreeNode<K, V> first = (TreeNode<K, V>) tab[index];
                if (root != first) {
                    Node<K, V> rn;
                    tab[index] = root;
                    TreeNode<K, V> rp = root.prev;
                    if (null != (rn = root.next)) {
                        ((TreeNode<K, V>) rn).prev = rp;
                    }
                    if (null != rp) {
                        rp.next = rn;
                    }
                    if (null != first) {
                        first.prev = root;
                    }
                    root.next = first;
                    root.prev = null;
                }
                assert checkInvariants(root);
            }
        }

        final TreeNode<K, V> find(int h, Object k, Class<?> kc) {
            TreeNode<K, V> p = this;
            do {
                int ph;
                int dir;
                K pk;
                TreeNode<K, V> pl = p.left;
                TreeNode<K, V> pr = p.right;
                TreeNode<K, V> q;
                if ((ph = p.hash) > h) {
                    p = pl;
                } else if (ph < h) {
                    p = pr;
                } else if ((pk = p.key) == k || (null != k && k.equals(pk))) {
                    return p;
                } else if (null == pl) {
                    p = pr;
                } else if (null == pr) {
                    p = pl;
                } else if ((null != kc || null != (kc = comparableClassFor(k))) && (dir = compareComparables(kc, k, pk)) != 0) {
                    p = dir < 0 ? pl : pr;
                } else if (null != (q = pr.find(h, k, kc))) {
                    return q;
                } else {
                    p = pl;
                }
            } while (null != p);
            return null;
        }

        final TreeNode<K, V> getTreeNode(int h, Object k) {
            return (null != parent ? root() : this).find(h, k, null);
        }

        static int tieBreakOrder(Object a, Object b) {
            int d;
            if (null == a || null == b || (d = a.getClass().getName().compareTo(b.getClass().getName())) == 0) {
                d = System.identityHashCode(a) <= System.identityHashCode(b) ? -1 : 1;
            }
            return d;
        }

        final void treeify(Node<K, V>[] tab) {
            TreeNode<K, V> root = null;
            for (TreeNode<K, V> x = this, next; null != x; x = next) {
                next = (TreeNode<K, V>) x.next;
                x.left = x.right = null;
                if (null == root) {
                    x.parent = null;
                    x.red = false;
                    root = x;
                } else {
                    K k = x.key;
                    int h = x.hash;
                    Class<?> kc = null;
                    for (TreeNode<K, V> p = root;;) {
                        int dir;
                        int ph;
                        K pk = p.key;
                        if ((ph = p.hash) > h) {
                            dir = -1;
                        } else if (ph < h) {
                            dir = 1;
                        } else if ((null == kc && null == (kc = comparableClassFor(k))) || (dir = compareComparables(kc, k, pk)) == 0) {
                            dir = tieBreakOrder(k, pk);
                        }
                        TreeNode<K, V> xp = p;
                        if (null == (p = (dir <= 0 ? p.left : p.right))) {
                            x.parent = xp;
                            if (dir <= 0) {
                                xp.left = x;
                            } else {
                                xp.right = x;
                            }
                            root = balanceInsertion(root, x);
                            break;
                        }
                    }
                }
            }
            moveRootToFront(tab, root);
        }

        final Node<K, V> untreeify(MyHashMap<K, V> map) {
            Node<K, V> hd = null;
            Node<K, V> tl = null;
            for (Node<K, V> q = this; null != q; q = q.next) {
                // todo 1
                Node<K, V> p = null;
                if (null == tl) {
                    hd = p;
                } else {
                    tl.next = p;
                }
                tl = p;
            }
            return hd;
        }

        final TreeNode<K, V> putTreeVal(MyHashMap<K, V> map, Node<K, V>[] tab, int h, K k, V v) {
            Class<?> kc = null;
            boolean searched = false;
            TreeNode<K, V> root = null != parent ? root() : this;
            for (TreeNode<K, V> p = root;;) {
                int dir;
                int ph;
                K pk;
                if ((ph = p.hash) > h) {
                    dir = -1;
                } else if (ph < h) {
                    dir = 1;
                } else if ((pk = p.key) == k || (null != k && k.equals(pk))) {
                    return p;
                } else if ((null == kc && null == (kc = comparableClassFor(k))) || (dir = compareComparables(kc, k, pk)) == 0) {
                    if (!searched) {
                        TreeNode<K, V> q;
                        TreeNode<K, V> ch;
                        searched = true;
                        if ((null != (ch = p.left) && null != (q = ch.find(h, k, kc)))  || (null != (ch = p.right) && null != (q = ch.find(h, k, kc)))) {
                            return q;
                        }
                    }
                    dir = tieBreakOrder(k, pk);
                }

                TreeNode<K, V> xp = p;
                if (null == (p = (dir <= 0 ? p.left : p.right))) {
                    Node<K, V> xpn = xp.next;
                    // todo 2
                    TreeNode<K, V> x = null;
                    if (dir <= 0) {
                        xp.left = x;
                    } else {
                        xp.right = x;
                    }
                    xp.next = x;
                    x.parent = x.prev = xp;
                    if (null != xpn) {
                        ((TreeNode<K, V>) xpn).prev = x;
                    }
                    moveRootToFront(tab, balanceInsertion(root, x));
                    return null;
                }
            }
        }

        final void removeTreeNode(MyHashMap<K, V> map, Node<K, V>[] tab, boolean movable) {
            int n;
            if (null == tab || (n = tab.length) == 0) {
                return;
            }
            int index = (n - 1) & hash;
            TreeNode<K, V> first = (TreeNode<K, V>) tab[index];
            TreeNode<K, V> root = first;
            TreeNode<K, V> rl;
            TreeNode<K, V> succ = (TreeNode<K, V>) next;
            TreeNode<K, V> pred = prev;
            if (null == pred) {
                tab[index] = first = succ;
            } else {
                pred.next = succ;
            }
            if (null != succ) {
                succ.prev = pred;
            }
            if (null == first) {
                return;
            }
            if (null != root.parent) {
                root = root.root();
            }
            if (null == root || null == root.right || null == (rl = root.left) || null == rl.left) {
                tab[index] = first.untreeify(map);
                return;
            }

            TreeNode<K, V> p = this;
            TreeNode<K, V> pl = left;
            TreeNode<K, V> pr = right;
            TreeNode<K, V> replacement;
            if (null != pl && null != pr) {
                TreeNode<K, V> s = pr;
                TreeNode<K, V> sl;
                while (null != (sl = s.left)) {
                    s = sl;
                }
                boolean c = s.red;
                s.red = p.red;
                p.red = c;
                TreeNode<K, V> sr = s.right;
                TreeNode<K, V> pp = p.parent;
                if (s == pr) {
                    p.parent = s;
                    s.right = p;
                } else {
                    TreeNode<K, V> sp = s.parent;
                    if (null != (p.parent = sp)) {
                        if (s == sp.left) {
                            sp.left = p;
                        } else {
                            sp.right = p;
                        }
                    }
                    if (null != (s.right = pr)) {
                        pr.parent = s;
                    }
                }
                p.left = null;
                if (null != (p.right = sr)) {
                    sr.parent = p;
                }
                if (null != (s.left = pl)) {
                    pl.parent = s;
                }
                if (null == (s.parent = pp)) {
                    root = s;
                } else if (p == pp.left) {
                    pp.left = s;
                } else {
                    pp.right = s;
                }
                if (null != sr) {
                    replacement = sr;
                } else {
                    replacement = p;
                }
            } else if (null != pl) {
                replacement = pl;
            } else if (null != pr) {
                replacement = pr;
            } else {
                replacement = p;
            }
            if (replacement != p) {
                TreeNode<K, V> pp = replacement.parent = p.parent;
                if (null == pp) {
                    root = replacement;
                } else if (p == pp.left) {
                    pp.left = replacement;
                } else {
                    pp.right = replacement;
                }
                p.left = p.right = p.parent = null;
            }

            TreeNode<K, V> r = p.red ? root : balanceDeletion(root, replacement);
            if (replacement == p) {
                TreeNode<K, V> pp = p.parent;
                p.parent = null;
                if (null != pp) {
                    if (p == pp.left) {
                        pp.left = null;
                    } else if (p == pp.right) {
                        pp.right = null;
                    }
                }
            }
            if (movable) {
                moveRootToFront(tab, r);
            }
        }

        final void split(MyHashMap<K, V> map, Node<K, V>[] tab, int index, int bit) {
            TreeNode<K, V> b = this;
            TreeNode<K, V> loHead = null;
            TreeNode<K, V> loTail = null;
            TreeNode<K, V> hiHead = null;
            TreeNode<K, V> hiTail = null;
            int lc = 0;
            int hc = 0;
            for (TreeNode<K, V> e = b, next; null != e; e = next) {
                next = (TreeNode<K, V>) e.next;
                e.next = null;
                if ((e.hash & bit) == 0) {
                    if (null == (e.prev = loTail)) {
                        loHead = e;
                    } else {
                        loTail.next = e;
                    }
                    loTail = e;
                    lc++;
                } else {
                    if (null == (e.prev = hiTail)) {
                        hiHead = e;
                    } else {
                        hiTail.next = e;
                    }
                    hiTail = e;
                    hc++;
                }
            }

            if (null != loHead) {
                if (lc <= UNTREEIFY_THRESHOLD) {
                    tab[index] = loHead.untreeify(map);
                } else {
                    tab[index] = loHead;
                    if (null != hiHead) {
                        loHead.treeify(tab);
                    }
                }
            }

            if (null != hiHead) {
                if (hc <= UNTREEIFY_THRESHOLD) {
                    tab[index + bit] = hiHead.untreeify(map);
                } else {
                    tab[index + bit] = hiHead;
                    if (null != loHead) {
                        hiHead.treeify(tab);
                    }
                }
            }
        }

        static <K, V> TreeNode<K, V> rotateLeft(TreeNode<K, V> root, TreeNode<K, V> p) {
            TreeNode<K, V> r;
            TreeNode<K, V> pp;
            TreeNode<K, V> rl;
            if (null != p && null != (r = p.right)) {
                if (null != (rl = p.right = r.left)) {
                    rl.parent = p;
                }
                if (null == (pp = r.parent = p.parent)) {
                    (root = r).red = false;
                } else if (pp.left == p) {
                    pp.left = r;
                } else {
                    pp.right = r;
                }
                r.left = p;
                p.parent = r;
            }
            return root;
        }

        static <K, V> TreeNode<K, V> rotateRight(TreeNode<K, V> root, TreeNode<K, V> p) {
            TreeNode<K, V> l;
            TreeNode<K, V> pp;
            TreeNode<K, V> lr;
            if (null != p && null != (l = p.left)) {
                if (null != (lr = p.left = l.right)) {
                    lr.parent = p;
                }
                if (null == (pp = l.parent = p.parent)) {
                    (root = l).red = false;
                } else if (pp.right == p) {
                    pp.right = l;
                } else {
                    pp.left = l;
                }
                l.right = p;
                p.parent = l;
            }
            return root;
        }

        static <K, V> TreeNode<K, V> balanceInsertion(TreeNode<K, V> root, TreeNode<K, V> x) {
            x.red = true;
            for (TreeNode<K, V> xp, xpp, xppl, xppr;;) {
                if (null == (xp = x.parent)) {
                    x.red = false;
                    return x;
                } else if (!xp.red || null == (xpp = xp.parent)) {
                    return root;
                }

                if (xp == (xppl = xpp.left)) {
                    if (null != (xppr = xpp.right) && xppr.red) {
                        xppr.red = false;
                        xp.red = false;
                        xpp.red = true;
                        x = xpp;
                    } else {
                        if (x == xp.right) {
                            root = rotateLeft(root, x = xp);
                            xpp = null == (xp = x.parent) ? null : xp.parent;
                        }
                        if (null != xp) {
                            xp.red = false;
                            if (null != xpp) {
                                xpp.red = true;
                                root = rotateRight(root, xpp);
                            }
                        }
                    }
                } else {
                    if (null != xppl && xppl.red) {
                        xppl.red = false;
                        xp.red = false;
                        xpp.red = true;
                        x = xpp;
                    } else {
                        if (x == xp.left) {
                            root = rotateRight(root, x = xp);
                            xpp = null == (xp = x.parent) ? null : xp.parent;
                        }
                        if (null != xp) {
                            xp.red = false;
                            if (null != xpp) {
                                xpp.red = true;
                                root = rotateLeft(root, xpp);
                            }
                        }
                    }
                }
            }
        }

        static <K, V> TreeNode<K, V> balanceDeletion(TreeNode<K, V> root, TreeNode<K, V> x) {
            for (TreeNode<K, V>  xp, xpl, xpr;;) {
                if (null == x || x == root) {
                    return root;
                } else if (null == (xp = x.parent)) {
                    x.red = false;
                    return x;
                } else if (x.red) {
                    x.red = false;
                    return root;
                } else if ((xpl = xp.left) == x) {
                    if (null != (xpr = xp.right) && xpr.red) {
                        xpr.red = false;
                        xp.red = true;
                        root = rotateLeft(root, xp);
                        xpr = null == (xp = x.parent) ? null : xp.right;
                    }
                    if (null == xpr) {
                        x = xp;
                    } else {
                        TreeNode<K, V> sl = xpr.left;
                        TreeNode<K, V> sr = xpr.right;
                        if ((null == sr || !sr.red) && (null == sl || !sl.red)) {
                            xpr.red = true;
                            x = xp;
                        } else {
                            if (null == sr || !sr.red) {
                                if (null != sl) {
                                    sl.red = false;
                                }
                                xpr.red = true;
                                root = rotateRight(root, xpr);
                                xpr = null == (xp = x.parent) ? null : xp.right;
                            }
                            if (null != xpr) {
                                xpr.red = (null == xp) ? false : xp.red;
                                if (null != (sr = xpr.right)) {
                                    sr.red = false;
                                }
                            }
                            if (null != xp) {
                                xp.red = false;
                                root = rotateLeft(root, xp);
                            }
                            x = root;
                        }
                    }
                } else {
                    if (null != xpl && xpl.red) {
                        xpl.red = false;
                        xp.red = true;
                        root = rotateRight(root, xp);
                        xpl = null == (xp = x.parent) ? null : xp.left;
                    }
                    if (null == xpl) {
                        x = xp;
                    } else {
                        TreeNode<K, V> sl = xpl.left;
                        TreeNode<K, V> sr = xpl.right;
                        if ((null == sl || !sl.red) && (null == sr || !sr.red)) {
                            xpl.red = true;
                            x = xp;
                        } else {
                            if (null == sl || !sl.red) {
                                if (null != sr) {
                                    sr.red = false;
                                }
                                xpl.red = true;
                                root = rotateLeft(root, xpl);
                                xpl = null == (xp = x.parent) ? null : xp.left;
                            }
                            if (null != xpl) {
                                xpl.red = null == xp ? false : xp.red;
                                if (null != (sl = xpl.left)) {
                                    sl.red = false;
                                }
                            }
                            if (null != xp) {
                                xp.red = false;
                                root = rotateRight(root, xp);
                            }
                            x = root;
                        }
                    }
                }
            }
        }

        static <K, V> boolean checkInvariants(TreeNode<K, V> t) {
            TreeNode<K, V> tp = t.parent;
            TreeNode<K, V> tl = t.left;
            TreeNode<K, V> tr = t.right;
            TreeNode<K, V> tb =t.prev;
            TreeNode<K, V> tn = (TreeNode<K, V>) t.next;

            if (null != tb && tb.next != t) {
                return false;
            }
            if (null != tn && tn.prev != t) {
                return false;
            }
            if (null != tp && t != tp.left && t != tp.right) {
                return false;
            }
            if (null != tl && (tl.parent != t || tl.hash != t.hash)) {
                return false;
            }
            if (null != tr && (tr.parent != t || tr.hash != t.hash)) {
                return false;
            }
            if (t.red && null != tl && tl.red && null != tr && tr.red) {
                return false;
            }
            if (null != tl && !checkInvariants(tl)) {
                return false;
            }
            if (null != tr && !checkInvariants(tr)) {
                return false;
            }
            return true;
        }
    }

}
