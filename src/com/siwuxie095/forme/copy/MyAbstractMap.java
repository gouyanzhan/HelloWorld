package com.siwuxie095.forme.copy;

import java.io.Serializable;
import java.util.*;

/**
 * @author Jiajing Li
 * @date 2019-04-28 16:38:24
 */
public abstract class MyAbstractMap<K, V> implements MyMap<K, V> {

    protected MyAbstractMap() {}

    @Override
    public int size() {
        return entrySet().size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Iterator<MyMap.Entry<K, V>> itr = entrySet().iterator();
        if (null == key) {
            while (itr.hasNext()) {
                Entry<K, V> entry = itr.next();
                if (null == entry.getKey()) {
                    return true;
                }
            }
        } else {
            while (itr.hasNext()) {
                Entry<K, V> entry = itr.next();
                if (key.equals(entry.getKey())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Iterator<MyMap.Entry<K, V>> itr = entrySet().iterator();
        if (null == value) {
            while (itr.hasNext()) {
                Entry<K, V> entry = itr.next();
                if (null == entry.getValue()) {
                    return true;
                }
            }
        } else {
            while (itr.hasNext()) {
                Entry<K, V> entry = itr.next();
                if (value.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Iterator<MyMap.Entry<K, V>> itr = entrySet().iterator();
        if (null == key) {
            while (itr.hasNext()) {
                Entry<K, V> entry = itr.next();
                if (null == entry.getKey()) {
                    return entry.getValue();
                }
            }
        } else {
            while (itr.hasNext()) {
                Entry<K, V> entry = itr.next();
                if (key.equals(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(MyMap<? extends K, ? extends V> map) {
        for (MyMap.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V remove(Object key) {
        Iterator<MyMap.Entry<K, V>> itr = entrySet().iterator();
        MyMap.Entry<K, V> correctEntry = null;
        if (null == key) {
            while (null == correctEntry && itr.hasNext()) {
                Entry<K, V> entry = itr.next();
                if (null == entry.getKey()) {
                    correctEntry = entry;
                }
            }
        } else {
            while (null == correctEntry && itr.hasNext()) {
                Entry<K, V> entry = itr.next();
                if (key.equals(entry.getKey())) {
                    correctEntry = entry;
                }
            }
        }

        V oldValue = null;
        if (null != correctEntry) {
            oldValue = correctEntry.getValue();
            itr.remove();
        }

        return oldValue;
    }

    @Override
    public void clear() {
        entrySet().clear();;
    }

    transient Set<K> keySet;
    transient Collection<V> values;

    @Override
    public Set<K> keySet() {
        Set<K> ks = keySet;
        if (null == ks) {
            ks = new AbstractSet<K>() {

                @Override
                public Iterator<K> iterator() {
                    return new Iterator<K>() {
                        private Iterator<Entry<K, V>> itr = entrySet().iterator();

                        @Override
                        public boolean hasNext() {
                            return itr.hasNext();
                        }

                        @Override
                        public K next() {
                            return itr.next().getKey();
                        }

                        @Override
                        public void remove() {
                            itr.remove();
                        }
                    };
                }

                @Override
                public int size() {
                    return MyAbstractMap.this.size();
                }

                @Override
                public boolean isEmpty() {
                    return MyAbstractMap.this.isEmpty();
                }

                @Override
                public void clear() {
                    MyAbstractMap.this.clear();
                }

                @Override
                public boolean contains(Object k) {
                    return MyAbstractMap.this.containsKey(k);
                }
            };
            keySet = ks;
        }
        return ks;
    }

    @Override
    public Collection<V> values() {
        Collection<V> vals = values;
        if (null == vals) {
            vals = new AbstractCollection<V>() {
                @Override
                public Iterator<V> iterator() {
                    return new Iterator<V>() {
                        private Iterator<Entry<K, V>> itr = entrySet().iterator();

                        @Override
                        public boolean hasNext() {
                            return itr.hasNext();
                        }

                        @Override
                        public V next() {
                            return itr.next().getValue();
                        }

                        @Override
                        public void remove() {
                            itr.remove();
                        }
                    };
                }

                @Override
                public int size() {
                    return MyAbstractMap.this.size();
                }

                @Override
                public boolean isEmpty() {
                    return MyAbstractMap.this.isEmpty();
                }

                @Override
                public void clear() {
                    MyAbstractMap.this.clear();
                }

                @Override
                public boolean contains(Object v) {
                    return MyAbstractMap.this.containsValue(v);
                }
            };
            values = vals;
        }
        return vals;
    }

    @Override
    public abstract Set<Entry<K, V>> entrySet();

    @Override
    public int hashCode() {
        int h = 0;
        Iterator<Entry<K, V>> itr = entrySet().iterator();
        while (itr.hasNext()) {
            h += itr.next().hashCode();
        }
        return h;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof MyMap)) {
            return false;
        }
        MyMap<?, ?> m = (MyMap<?, ?>) o;
        if (m.size() != size()) {
            return false;
        }

        try {
            Iterator<Entry<K, V>> itr = entrySet().iterator();
            while (itr.hasNext()) {
                Entry<K, V> entry = itr.next();
                K key = entry.getKey();
                V value = entry.getValue();
                if (null == value) {
                    if (!(null == m.get(key) && m.containsKey(key))) {
                        return false;
                    }
                } else {
                    if (!value.equals(m.get(key))) {
                        return false;
                    }
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Iterator<Entry<K, V>> itr = entrySet().iterator();
        if (!itr.hasNext()) {
            return "{}";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (;;) {
            Entry<K, V> entry = itr.next();
            K key = entry.getKey();
            V value = entry.getValue();
            builder.append(key == this ? "(this Map)" : key);
            builder.append("=");
            builder.append(value == this ? "(this Map)" : value);
            if (!itr.hasNext()) {
                return builder.append("}").toString();
            }
            builder.append(",").append(" ");
        }
    }

    private static boolean eq(Object o1, Object o2) {
        return null == o1 ? null == o2 : o1.equals(o2);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        MyAbstractMap<?, ?> result = (MyAbstractMap<?, ?>) super.clone();
        result.keySet = null;
        result.values = null;
        return result;
    }

    public static class SimpleEntry<K, V> implements Entry<K, V>, Serializable {
        private final K key;
        private V value;

        public SimpleEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public SimpleEntry(Entry<? extends K, ? extends V> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public int hashCode() {
            return (null == key ? 0 : key.hashCode()) ^ (null == value ? 0 : value.hashCode());
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MyMap.Entry)) {
                return false;
            }
            MyMap.Entry<?, ?> entry = (Entry<?, ?>) o;
            return eq(key, entry.getKey()) && eq(value, entry.getValue());
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

    }


    public static class SimpleImmutableEntry<K, V> implements Entry<K, V>, Serializable {

        private final K key;
        private final V value;

        public SimpleImmutableEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public SimpleImmutableEntry(Entry<? extends K, ? extends V> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return (null == key ? 0 : key.hashCode()) ^ (null == value ? 0 : value.hashCode());
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MyMap.Entry)) {
                return false;
            }
            MyMap.Entry<?, ?> entry = (Entry<?, ?>) o;
            return eq(key, entry.getKey()) && eq(value, entry.getValue());

        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }









}
