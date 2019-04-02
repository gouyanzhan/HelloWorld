package com.siwuxie095.forme.util;

import java.io.IOException;
import java.io.Serializable;
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
public final class ObjectX implements Serializable {

    private ObjectX() {
        throw new AssertionError("There is no ObjectX instance for you!");
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
     * 被 com.siwuxie095.forme.util.ObjectX#hash(java.lang.Object...) 代替
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







}
