package com.siwuxie095.forme.util;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Supplier;

/**
 * Object 相关的工具类
 *
 * 参考：java.util.Objects、org.apache.commons.lang3.ObjectUtils
 *
 * @author Jiajing Li
 * @date 2019-01-18 11:15:40
 */
public final class MyObjectUtils implements Serializable {

    private MyObjectUtils() {
        throw new AssertionError("There is no MyObjectUtils instance for you!");
    }

    /**
     * 判断对象是否为空
     *
     * @param obj 对象
     * @return true 为空；false 不为空
     */
    public static boolean isNull(final Object obj) {
        return null == obj;
    }

    /**
     * 判断对象是否不为空
     *
     * @param obj 对象
     * @return true 不为空；false 为空
     */
    public static boolean nonNull(final Object obj) {
        return null != obj;
    }

    /**
     * 判断两个对象是否相等
     *
     * @param obj1 第一个对象
     * @param obj2 第二个对象
     * @return true 相等；false 不相等
     */
    public static boolean equals(final Object obj1, final Object obj2) {
        return (obj1 == obj2) || (null != obj1 && obj1.equals(obj2));
    }

    /**
     * 判断两个对象是否不相等
     *
     * @param obj1 第一个对象
     * @param obj2 第二个对象
     * @return true 不相等；false 相等
     */
    public static boolean nonEquals(final Objects obj1, final Object obj2) {
        return (obj1 != obj2) && (null != obj1 && !obj1.equals(obj2));
    }

    public static int hashCode(Object obj) {
        return null != obj ? obj.hashCode() : 0;
    }

    public static int hash(Object... objs) {
        return Arrays.hashCode(objs);
    }

    public static String toString(Object obj) {
        return String.valueOf(obj);
    }

    public static String toString(Object obj, String nullDefault) {
        return null != obj ? obj.toString() : nullDefault;
    }

    public static <T> int compare(T obj1, T obj2, Comparator<? super T> comp) {
        return (obj1 == obj2) ? 0 : comp.compare(obj1, obj2);
    }

    public static <T> T requireNonNull(T obj) {
        if (null == obj) {
            throw new NullPointerException();
        }
        return obj;
    }

    public static <T> T requireNonNull(T obj, String message) {
        if (null == obj) {
            throw new NullPointerException(message);
        }
        return obj;
    }

    public static <T> T requireNonNull(T obj, Supplier<String> messageSupplier) {
        if (null == obj) {
            throw new NullPointerException(messageSupplier.get());
        }
        return obj;
    }




    public static <T> T defaultIfNull(final T obj, final T defaultValue) {
        return null != obj ? obj : defaultValue;
    }

    public static <T> T firstNonNull(final T... values) {
        if (null != values) {
            for (final T val : values) {
                if (null != val) {
                    return val;
                }
            }
        }
        return null;
    }

    /**
     * @deprecated
     *
     * 被 com.siwuxie095.forme.util.MyObjectUtils#hash(java.lang.Object...) 代替
     */
    public static int hashCodeMulti(final Object... objs) {
        int hash = 1;
        if (null != objs) {
            for (final Object obj : objs) {
                final int tmpHash = hashCode(obj);
                hash = hash * 31 + tmpHash;
            }
        }
        return hash;
    }

    public static String identityToString(final Object obj) {
        if (null == obj) {
            throw new NullPointerException("Cannot get the toString of a null identity");
        }
        StringBuilder builder = new StringBuilder();
        identityToString(builder, obj);
        return builder.toString();
    }

    public static void identityToString(final Appendable appendable, final Object obj) throws IOException {
        if (null == obj) {
            throw new NullPointerException("Cannot get the toString of a null identity");
        }
        appendable.append(obj.getClass().getName())
                .append("@")
                .append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void identityToString(final StringBuilder builder, final Object obj) {
        if (null == obj) {
            throw new NullPointerException("Cannot get the toString of a null identity");
        }
        builder.append(obj.getClass().getName())
                .append("@")
                .append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void identityToString(final StringBuffer buffer, final Object obj) {
        if (null == obj) {
            throw new NullPointerException("Cannot get the toString of a null identity");
        }
        buffer.append(obj.getClass().getName())
                .append("@")
                .append(Integer.toHexString(System.identityHashCode(obj)));
    }

    /**
     * 最小值
     */
    public static <T extends Comparable<? super T>> T min(final T... objs) {
        T result = null;
        if (null != objs) {
            for (final T obj : objs) {
                if (compare(obj, result, true) < 0) {
                    result = obj;
                }
            }
        }
        return result;
    }

    /**
     * 最大值
     */
    public static <T extends Comparable<? super T>> T max(final T... objs) {
        T result = null;
        if (null != objs) {
            for (final T obj : objs) {
                if (compare(obj, result, false) > 0) {
                    result = obj;
                }
            }
        }
        return result;
    }

    public static <T extends Comparable<? super T>> int compare(final T obj1, final T obj2) {
        return compare(obj1, obj2, false);
    }

    public static <T extends Comparable<? super T>> int compare(final T obj1, final T obj2, final boolean nullGreater) {
        if (obj1 == obj2) {
            return 0;
        } else if (null == obj1) {
            return nullGreater ? 1 : -1;
        } else if (null == obj2) {
            return nullGreater ? -1 : 1;
        }
        return obj1.compareTo(obj2);
    }

    /**
     * 中位数
     */
    public static <T extends Comparable<? super T>> T median(final T... objs) {
        if (null == objs) {
            throw new NullPointerException();
        }
        if (objs.length == 0) {
            throw new IllegalArgumentException();
        }
        for (final T obj : objs) {
            if (null == obj) {
                throw new IllegalArgumentException();
            }
        }
        final TreeSet<T> sort = new TreeSet<>();
        Collections.addAll(sort, objs);
        final T result = (T) sort.toArray()[(sort.size() - 1) / 2];
        return result;
    }

    /**
     * 中位数
     */
    public static <T> T median(final Comparator<T> comp, final T... objs) {
        if (null == comp) {
            throw new NullPointerException();
        }
        if (null == objs) {
            throw new NullPointerException();
        }
        if (objs.length == 0) {
            throw new IllegalArgumentException();
        }
        for (final T obj : objs) {
            if (null == obj) {
                throw new IllegalArgumentException();
            }
        }
        final TreeSet<T> sort = new TreeSet<>(comp);
        Collections.addAll(sort, objs);
        final T result = (T) sort.toArray()[(sort.size() - 1) / 2];
        return result;
    }

    /**
     * 唯一的众数
     */
    public static <T> T mode(final T... objs) {
        if (null == objs || objs.length == 0) {
            return null;
        }
        final Map<T, Integer> map = new HashMap<>();
        for (final T obj : objs) {
            Integer count = map.get(obj);
            if (null == count) {
                map.put(obj, 1);
            } else {
                map.put(obj, ++count);
            }
        }
        T result = null;
        int max = 0;
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            int tmp = entry.getValue();
            if (tmp == max) {
                result = null;
            } else if (tmp > max) {
                max = tmp;
                result = entry.getKey();
            }
        }
        return result;
    }

    public static <T> T clone(final T obj) {
        if (!(obj instanceof Cloneable)) {
            return null;
        }

        final Object result;
        if (obj.getClass().isArray()) {
            final Class<?> componentType = obj.getClass().getComponentType();
            if (!componentType.isPrimitive()) {
                result = ((Object[]) obj).clone();
            } else {
                int length = Array.getLength(obj);
                result = Array.newInstance(componentType, length);
                while (length -- > 0) {
                    Array.set(result, length, Array.get(obj, length));
                }
            }
        } else {
            try {
                final Method clone = obj.getClass().getMethod("clone");
                result = clone.invoke(obj);
            } catch (final NoSuchMethodException e) {
                throw new RuntimeException("Cloneable type " + obj.getClass().getName() + " has no clone method", e);
            } catch (final IllegalAccessException e) {
                throw new RuntimeException("Cannot clone Cloneable type " + obj.getClass().getName(), e);
            } catch (final InvocationTargetException e) {
                throw new RuntimeException("Exception cloning Cloneable type " + obj.getClass().getName(), e.getCause());
            }
        }
        final T checked = (T) result;
        return checked;
    }

    public static <T> T cloneIfPossible(final T obj) {
        final T clone = clone(obj);
        return null == clone ? obj : clone;
    }

    public static byte CONST(final byte val) {
        return val;
    }

    public static short CONST(final short val) {
        return val;
    }

    public static int CONST(final int val) {
        return val;
    }

    public static long CONST(final long val) {
        return val;
    }

    public static float CONST(final float val) {
        return val;
    }

    public static double CONST(final double val) {
        return val;
    }

    public static char CONST(final char val) {
        return val;
    }

    public static boolean CONST(final boolean val) {
        return val;
    }

    public static <T> T CONST(final T val) {
        return val;
    }

    public static byte CONST_BYTE(final int val) throws IllegalArgumentException {
        if (val < Byte.MIN_VALUE || val > Byte.MAX_VALUE) {
            throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + val + "]");
        }
        return (byte) val;
    }

    public static short CONST_SHORT(final int val) throws IllegalArgumentException {
        if (val < Short.MIN_VALUE || val > Short.MAX_VALUE) {
            throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + val + "]");
        }
        return (short) val;
    }





}
