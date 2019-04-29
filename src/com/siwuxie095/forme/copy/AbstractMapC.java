package com.siwuxie095.forme.copy;

import java.util.*;

/**
 * @author Jiajing Li
 * @date 2019-04-28 16:38:24
 */
public abstract class AbstractMapC<K, V> implements MapC<K, V> {

    protected AbstractMapC() {}

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
        Iterator<MapC.Entry<K, V>> itr = entrySet().iterator();
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
        Iterator<MapC.Entry<K, V>> itr = entrySet().iterator();
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
        Iterator<MapC.Entry<K, V>> itr = entrySet().iterator();
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
    public void putAll(MapC<? extends K, ? extends V> map) {
        for (MapC.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V remove(Object key) {
        Iterator<MapC.Entry<K, V>> itr = entrySet().iterator();
        MapC.Entry<K, V> correctEntry = null;
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
                    return AbstractMapC.this.size();
                }

                @Override
                public boolean isEmpty() {
                    return AbstractMapC.this.isEmpty();
                }

                @Override
                public void clear() {
                    AbstractMapC.this.clear();
                }

                @Override
                public boolean contains(Object k) {
                    return AbstractMapC.this.containsKey(k);
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
                    return AbstractMapC.this.size();
                }

                @Override
                public boolean isEmpty() {
                    return AbstractMapC.this.isEmpty();
                }

                @Override
                public void clear() {
                    AbstractMapC.this.clear();
                }

                @Override
                public boolean contains(Object v) {
                    return AbstractMapC.this.containsValue(v);
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

        if (!(o instanceof MapC)) {
            return false;
        }
        MapC<?, ?> m = (MapC<?, ?>) o;
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





}
