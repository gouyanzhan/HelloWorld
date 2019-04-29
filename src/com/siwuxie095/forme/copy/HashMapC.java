//package com.siwuxie095.forme.copy;
//
//import java.io.Serializable;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.AbstractMap;
//import java.util.LinkedHashMap;
//import java.util.Objects;
//import java.util.Set;
//
///**
// * @author Jiajing Li
// * @date 2019-04-28 15:27:56
// */
//public class HashMapC<K, V> extends AbstractMap<K, V> implements MapC<K, V>, Cloneable, Serializable {
//
//    /**
//     * 默认初始容量，aka 16，即 2^4
//     */
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
//
//    /**
//     * 最大容量 2^30
//     */
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;
//
//    static final int TREEIFY_THRESHOLD = 8;
//
//    static final int UNTREEIFY_THRESHOLD = 6;
//
//    static final int MIN_TREEIFY_THRESHOLD = 64;
//
//    static final int hash(Object key) {
//        int h;
//        return null == key ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//    static Class<?> comparableClassFor(Object x) {
//        if (x instanceof Comparable) {
//            Class<?> c;
//            Type[] ts;
//            Type[] as;
//            Type t;
//            ParameterizedType p;
//            if ((c = x.getClass()) == String.class) {
//                return c;
//            }
//            if (null != (ts = c.getGenericInterfaces())) {
//                for (int i = 0; i < ts.length; i++) {
//                    if ((t = ts[i]) instanceof ParameterizedType
//                            && (p = (ParameterizedType) t).getRawType() == Comparable.class
//                            && null != (as = p.getActualTypeArguments())
//                            && as.length == 1
//                            && as[0] == c) {
//                        return c;
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    static int compareComparables(Class<?> kc, Object k, Object x) {
//        return null == x || x.getClass() != kc ? 0 : ((Comparable) k).compareTo(x);
//    }
//
//    static final int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return n < 0 ? 1 : (n >= MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : n + 1);
//    }
//
//    transient Node<K, V>[] table;
//
//    transient Set<MapC.Entry<K, V>> entrySet;
//
//    transient int size;
//
//    transient int modCount;
//
//    int threshold;
//
//    final float loadFactor;
//
//    public HashMapC(int initialCapacity, float loadFactor) {
//        if (initialCapacity < 0) {
//            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
//        }
//        if (initialCapacity > MAXIMUM_CAPACITY) {
//            initialCapacity = MAXIMUM_CAPACITY;
//        }
//        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
//            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
//        }
//        this.loadFactor = loadFactor;
//        this.threshold = tableSizeFor(initialCapacity);
//    }
//
//    public HashMapC(int initialCapacity) {
//        this(initialCapacity, DEFAULT_LOAD_FACTOR);
//    }
//
//    public HashMapC() {
//        this.loadFactor = DEFAULT_LOAD_FACTOR;
//    }
//
//    public HashMapC(MapC<? extends K, ? extends V> map) {
//        this.loadFactor = DEFAULT_LOAD_FACTOR;
//        putMapEntries(map, false);
//    }
//
//    final void putMapEntries(MapC<? extends K, ? extends V> map, boolean evict) {
//        int size = map.size();
//        if (size > 0) {
//            if (null == table) {
//                float ft = (float) size / loadFactor + 1.0F;
//                int t = (int) ft < MAXIMUM_CAPACITY ? (int) ft : MAXIMUM_CAPACITY;
//                if (t < threshold) {
//                    threshold = tableSizeFor(t);
//                }
//            } else if (size > threshold) {
//                threshold = resize();
//            }
//            for (MapC.Entry<? extends K, ? extends V> entry : map.entrySet()) {
//                K key = entry.getKey();
//                V value = entry.getValue();
//                putVal(hash(key), key, value, false, evict);
//            }
//        }
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public V get(Object key) {
//        Node<K, V> e;
//
//    }
//
//    final Node<K, V> getNode(int hash, Object key) {
//        Node<K, V>[] tab;
//        Node<K, V> first;
//        Node<K, V> e;
//        int n;
//        K k;
//        if (null != (tab = table) && (n = tab.length) > 0 && null != (first = tab[(n - 1) & hash])) {
//            if (first.hash == hash && (((k = first.key) == key) || (null != key && key.equals(k)))) {
//                return first;
//            }
//            if (null != (e = first.next)) {
//                if (first instanceof )
//            }
//        }
//    }
//
//    static class Node<K, V> implements MapC.Entry<K, V> {
//        final int hash;
//        final K key;
//        V value;
//        Node<K, V> next;
//
//        Node(int hash, K key, V value, Node<K, V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        @Override
//        public final K getKey() {
//            return key;
//        }
//
//        @Override
//        public final V getValue() {
//            return value;
//        }
//
//        @Override
//        public final V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        @Override
//        public final String toString() {
//            return key + "=" + value;
//        }
//
//        @Override
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//
//        @Override
//        public final boolean equals(Object obj) {
//            if (obj == this) {
//                return true;
//            }
//            if (obj instanceof MapC.Entry) {
//                MapC.Entry<K, V> entry = (MapC.Entry<K, V>) obj;
//                if (Objects.equals(key, entry.getKey()) && Objects.equals(value, entry.getValue())) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//    }
//
//    static final class TreeNode<K, V> extends LinkedHashMap.Entry<K, V> {
//
//    }
//
//}
