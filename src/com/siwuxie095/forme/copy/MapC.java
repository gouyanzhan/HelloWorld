package com.siwuxie095.forme.copy;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Jiajing Li
 * @date 2019-04-26 17:20:41
 */
public interface MapC<K, V> {

    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);

    void putAll(MapC<? extends K, ? extends V> m);

    void clear();

    Set<K> keySet();

    Collection<V> values();

    Set<MapC.Entry<K, V>> entrySet();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    default V getOrDefault(Object key, V defaultValue) {
        V v;
        return (null != (v = get(key)) || containsKey(key)) ? v : defaultValue;
    }

    default void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        for (MapC.Entry<K, V> entry : entrySet()) {
            K k;
            V v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch (IllegalStateException ise) {
                throw new ConcurrentModificationException(ise);
            }
            action.accept(k, v);
        }
    }

    default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Objects.requireNonNull(function);
        for (MapC.Entry<K, V> entry : entrySet()) {
            K k;
            V v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch (IllegalStateException ise) {
                throw new ConcurrentModificationException(ise);
            }

            v = function.apply(k, v);

            try {
                entry.setValue(v);
            } catch (IllegalStateException ise) {
                throw new ConcurrentModificationException(ise);
            }
        }
    }

    default V putIfAbsent(K key, V value) {
        V v = get(key);
        if (null == v) {
            v = put(key, value);
        }
        return v;
    }

    default boolean remove(Object key, Object value) {
        Object curValue = get(key);
        if (!Objects.equals(curValue, value) || (null == curValue && !containsKey(key))) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(K key, V oldValue, V newValue) {
        Object curValue = get(key);
        if (!Objects.equals(curValue, oldValue) || (null == curValue && !containsKey(key))) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default V replace(K key, V value) {
        V curValue;
        if ((null != (curValue = get(key))) || containsKey(key)) {
            curValue = put(key, value);
        }
        return curValue;
    }

    default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        V v;
        if (null == (v = get(key))) {
            V newValue;
            if (null != (newValue = mappingFunction.apply(key))) {
                put(key, newValue);
                return newValue;
            }
        }
        return v;
    }

    default V computeIfAbsent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue;
        if (null != (oldValue = get(key))) {
            V newValue = remappingFunction.apply(key, oldValue);
            if (null != newValue) {
                put(key, newValue);
                return newValue;
            } else {
                remove(key);
                return null;
            }
        } else {
            return null;
        }
    }

    default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue = get(key);
        V newValue = remappingFunction.apply(key, oldValue);
        if (null == newValue) {
            if (null != oldValue || containsKey(key)) {
                remove(key);
                return null;
            } else {
                return null;
            }
        } else {
            put(key, newValue);
            return newValue;
        }
    }

    default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        Objects.requireNonNull(value);
        V oldValue = get(key);
        V newValue = null == oldValue ? value : remappingFunction.apply(oldValue, value);
        if (null == newValue) {
            remove(key);
        } else {
            put(key, newValue);
        }
        return newValue;
    }


    interface Entry<K, V> {

        K getKey();

        V getValue();

        V setValue(V value);

        @Override
        boolean equals(Object o);

        @Override
        int hashCode();

        public static <K extends Comparable<? super K>, V> Comparator<MapC.Entry<K, V>> comparingByKey() {
            return (Comparator<MapC.Entry<K, V>> & Serializable) (c1, c2) -> c1.getKey().compareTo(c2.getKey());
        }

        public static <K, V extends Comparable<? super V>> Comparator<MapC.Entry<K, V>> comparingByValue() {
            return (Comparator<MapC.Entry<K, V>> & Serializable) (c1, c2) -> c1.getValue().compareTo(c2.getValue());
        }

        public static <K, V> Comparator<MapC.Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
            Objects.requireNonNull(cmp);
            return (Comparator<MapC.Entry<K, V>> & Serializable) (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
        }

        public static <K, V> Comparator<MapC.Entry<K, V>> comparingByValue(Comparator<? super V> cmp) {
            return (Comparator<MapC.Entry<K, V>> & Serializable) (c1, c2) -> cmp.compare(c1.getValue(), c2.getValue());
        }


    }

}
