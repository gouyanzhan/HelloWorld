package com.siwuxie095.forme.util;


/**
 * Array 相关的工具类
 *
 * @author Jiajing Li
 * @date 2019-01-18 11:39:55
 */
public final class ArrayX {


    //region 常量
    /**
     * 找不到索引
     */
    public static final int INDEX_NOT_FOUND = -1;
    /**
     * 空对象数组
     */
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    /**
     * 空类数组
     */
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    /**
     * 空字符串数组
     */
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    /**
     * 空字节型数组
     */
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    /**
     * 空字节型对象数组
     */
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    /**
     * 空短整型数组
     */
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    /**
     * 空短整型对象数组
     */
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    /**
     * 空整型数组
     */
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    /**
     * 空整型对象数组
     */
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    /**
     * 空长整型数组
     */
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    /**
     * 空长整型对象数组
     */
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    /**
     * 空单精度浮点型数组
     */
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    /**
     * 空单精度浮点型对象数组
     */
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    /**
     * 空双精度浮点型数组
     */
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    /**
     * 空双精度浮点型对象数组
     */
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    /**
     * 空字符型数组
     */
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    /**
     * 空字符型对象数组
     */
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
    /**
     * 空布尔型数组
     */
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    /**
     * 空布尔型对象数组
     */
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    //endregion

    //region ArrayX() 方法
    private ArrayX() {
        throw new AssertionError("There is no ArrayX instance for you!");
    }
    //endregion

    //region isEmpty() 方法
    /**
     * T 和 Object 都可以
     */
    //public static <T> Boolean isEmpty(final T[] arr) {
    //    return null == arr || arr.length == 0;
    //}

    public static boolean isEmpty(final Object[] arr) {
        return null == arr || arr.length == 0;
    }

    public static boolean isEmpty(final byte[] arr) {
        return null == arr || arr.length == 0;
    }

    public static boolean isEmpty(final short[] arr) {
        return null == arr || arr.length == 0;
    }

    public static boolean isEmpty(final int[] arr) {
        return null == arr || arr.length == 0;
    }

    public static boolean isEmpty(final long[] arr) {
        return null == arr || arr.length == 0;
    }

    public static boolean isEmpty(final float[] arr) {
        return null == arr || arr.length == 0;
    }

    public static boolean isEmpty(final double[] arr) {
        return null == arr || arr.length == 0;
    }

    public static boolean isEmpty(final char[] arr) {
        return null == arr || arr.length == 0;
    }

    public static boolean isEmpty(final boolean[] arr) {
        return null == arr || arr.length == 0;
    }
    //endregion

    //region nonEmpty() 方法
    /**
     * T 和 Object 都可以
     */
    //public static <T> boolean nonEmpty(final T[] arr) {
    //    return null != arr && arr.length != 0;
    //}

    public static boolean nonEmpty(final Object[] arr) {
        return null != arr && arr.length != 0;
    }

    public static boolean nonEmpty(final byte[] arr) {
        return null != arr && arr.length != 0;
    }

    public static boolean nonEmpty(final short[] arr) {
        return null != arr && arr.length != 0;
    }

    public static boolean nonEmpty(final int[] arr) {
        return null != arr && arr.length != 0;
    }

    public static boolean nonEmpty(final long[] arr) {
        return null != arr && arr.length != 0;
    }

    public static boolean nonEmpty(final float[] arr) {
        return null != arr && arr.length != 0;
    }

    public static boolean nonEmpty(final double[] arr) {
        return null != arr && arr.length != 0;
    }

    public static boolean nonEmpty(final char[] arr) {
        return null != arr && arr.length != 0;
    }

    public static boolean nonEmpty(final boolean[] arr) {
        return null != arr && arr.length != 0;
    }
    //endregion

    //region nullToEmpty() 方法
    public static Object[] nullToEmpty(final Object[] arr) {
        return isEmpty(arr) ? EMPTY_OBJECT_ARRAY : arr;
    }

    public static Class<?>[] nullToEmpty(final Class<?>[] arr) {
        return isEmpty(arr) ? EMPTY_CLASS_ARRAY : arr;
    }

    public static String[] nullToEmpty(final String[] arr) {
        return isEmpty(arr) ? EMPTY_STRING_ARRAY : arr;
    }

    public static byte[] nullToEmpty(final byte[] arr) {
        return isEmpty(arr) ? EMPTY_BYTE_ARRAY : arr;
    }

    public static Byte[] nullToEmpty(final Byte[] arr) {
        return isEmpty(arr) ? EMPTY_BYTE_OBJECT_ARRAY : arr;
    }

    public static short[] nullToEmpty(final short[] arr) {
        return isEmpty(arr) ? EMPTY_SHORT_ARRAY : arr;
    }

    public static Short[] nullToEmpty(final Short[] arr) {
        return isEmpty(arr) ? EMPTY_SHORT_OBJECT_ARRAY : arr;
    }

    public static int[] nullToEmpty(final int[] arr) {
        return isEmpty(arr) ? EMPTY_INT_ARRAY : arr;
    }

    public static Integer[] nullToEmpty(final Integer[] arr) {
        return isEmpty(arr) ? EMPTY_INTEGER_OBJECT_ARRAY : arr;
    }

    public static long[] nullToEmpty(final long[] arr) {
        return isEmpty(arr) ? EMPTY_LONG_ARRAY : arr;
    }

    public static Long[] nullToEmpty(final Long[] arr) {
        return isEmpty(arr) ? EMPTY_LONG_OBJECT_ARRAY : arr;
    }

    public static float[] nullToEmpty(final float[] arr) {
        return isEmpty(arr) ? EMPTY_FLOAT_ARRAY : arr;
    }

    public static Float[] nullToEmpty(final Float[] arr) {
        return isEmpty(arr) ? EMPTY_FLOAT_OBJECT_ARRAY : arr;
    }

    public static double[] nullToEmpty(final double[] arr) {
        return isEmpty(arr) ? EMPTY_DOUBLE_ARRAY : arr;
    }

    public static Double[] nullToEmpty(final Double[] arr) {
        return isEmpty(arr) ? EMPTY_DOUBLE_OBJECT_ARRAY : arr;
    }

    public static char[] nullToEmpty(final char[] arr) {
        return isEmpty(arr) ? EMPTY_CHAR_ARRAY : arr;
    }

    public static Character[] nullToEmpty(final Character[] arr) {
        return isEmpty(arr) ? EMPTY_CHARACTER_OBJECT_ARRAY : arr;
    }

    public static boolean[] nullToEmpty(final boolean[] arr) {
        return isEmpty(arr) ? EMPTY_BOOLEAN_ARRAY : arr;
    }

    public static Boolean[] nullToEmpty(final Boolean[] arr) {
        return isEmpty(arr) ? EMPTY_BOOLEAN_OBJECT_ARRAY : arr;
    }
    //endregion

    //region toPrimitive() 方法
    public static byte[] toPrimitive(final Byte[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        final byte[] result = new byte[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static byte[] toPrimitive(final Byte[] arr, final byte valueForNull) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        final byte[] result = new byte[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = (null == arr[i]) ? valueForNull : arr[i];
        }
        return result;
    }

    public static short[] toPrimitive(final Short[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        final short[] result = new short[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static short[] toPrimitive(final Short[] arr, final short valueForNull) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        final short[] result = new short[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = (null == arr[i]) ? valueForNull : arr[i];
        }
        return result;
    }

    public static int[] toPrimitive(final Integer[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        final int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static int[] toPrimitive(final Integer[] arr, final int valueForNull) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        final int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = (null == arr[i]) ? valueForNull : arr[i];
        }
        return result;
    }

    public static long[] toPrimitive(final Long[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        final long[] result = new long[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static long[] toPrimitive(final Long[] arr, final long valueForNull) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        final long[] result = new long[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = (null == arr[i]) ? valueForNull : arr[i];
        }
        return result;
    }

    public static float[] toPrimitive(final Float[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        final float[] result = new float[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static float[] toPrimitive(final Float[] arr, final float valueForNull) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        final float[] result = new float[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = (null == arr[i]) ? valueForNull : arr[i];
        }
        return result;
    }

    public static double[] toPrimitive(final Double[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        final double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static double[] toPrimitive(final Double[] arr, final double valueForNull) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        final double[] result = new double[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = (null == arr[i]) ? valueForNull : arr[i];
        }
        return result;
    }

    public static char[] toPrimitive(final Character[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        final char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static char[] toPrimitive(final Character[] arr, final char valueForNull) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        final char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = (null == arr[i]) ? valueForNull : arr[i];
        }
        return result;
    }

    public static boolean[] toPrimitive(final Boolean[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        final boolean[] result = new boolean[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static boolean[] toPrimitive(final Boolean[] arr, final boolean valueForNull) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        final boolean[] result = new boolean[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = (null == arr[i]) ? valueForNull : arr[i];
        }
        return result;
    }
    //endregion

    //region toObject() 方法
    public static Byte[] toObject(final byte[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        final Byte[] result = new Byte[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static Short[] toObject(final short[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        final Short[] result = new Short[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static Integer[] toObject(final int[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        final Integer[] result = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static Long[] toObject(final long[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        final Long[] result = new Long[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static Float[] toObject(final float[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        final Float[] result = new Float[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static Double[] toObject(final double[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        final Double[] result = new Double[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static Character[] toObject(final char[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        final Character[] result = new Character[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }

    public static Boolean[] toObject(final boolean[] arr) {
        if (null == arr) {
            return null;
        } else if (arr.length == 0) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        final Boolean[] result = new Boolean[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }
    //endregion

    //region indexOf() 方法
    public static int indexOf(final Object[] arr, final Object objectToFind) {
        int startIndex = 0;
        return indexOf(arr, objectToFind, startIndex);
    }

    public static int indexOf(final Object[] arr, final Object objectToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (null == objectToFind) {
            for (int i = startIndex; i < arr.length; ++i) {
                if (null == arr[i]) {
                    return i;
                }
            }
            /*
             * 1、arr.getClass() 获取的是数组的类型 Object[]；
             * 2、arr.getClass().getComponentType() 获取的是数组的组件类型 Object；
             * 3、arr.getClass().getComponentType().isInstance(valueToFind) 判断类型是否一致，相当于 instanceOf；
             */
        } else if (arr.getClass().getComponentType().isInstance(objectToFind)) {
            for (int i = startIndex; i < arr.length; ++i) {
                if (objectToFind.equals(arr[i])) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(final byte[] arr, final byte valueToFind) {
        int startIndex = 0;
        return indexOf(arr, valueToFind, startIndex);
    }

    public static int indexOf(final byte[] arr, final byte valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < arr.length; ++i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(final short[] arr, final short valueToFind) {
        int startIndex = 0;
        return indexOf(arr, valueToFind, startIndex);
    }

    public static int indexOf(final short[] arr, final short valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < arr.length; ++i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(final int[] arr, final int valueToFind) {
        int startIndex = 0;
        return indexOf(arr, valueToFind, startIndex);
    }

    public static int indexOf(final int[] arr, final int valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < arr.length; ++i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(final long[] arr, final long valueToFind) {
        int startIndex = 0;
        return indexOf(arr, valueToFind, startIndex);
    }

    public static int indexOf(final long[] arr, final long valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < arr.length; ++i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(final float[] arr, final float valueToFind) {
        int startIndex = 0;
        return indexOf(arr, valueToFind, startIndex);
    }

    public static int indexOf(final float[] arr, final float valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < arr.length; ++i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(final double[] arr, final double valueToFind) {
        int startIndex = 0;
        return indexOf(arr, valueToFind, startIndex);
    }

    public static int indexOf(final double[] arr, final double valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < arr.length; ++i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回第一个出现在误差范围内的索引
     */
    public static int indexOf(final double[] arr, final double valueToFind, final double tolerance) {
        int startIndex = 0;
        return indexOf(arr, valueToFind, tolerance, startIndex);
    }

    public static int indexOf(final double[] arr, final double valueToFind, final double tolerance, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        final double min = valueToFind - tolerance;
        final double max = valueToFind + tolerance;
        for (int i = startIndex; i < arr.length; ++i) {
            if (arr[i] >= min && arr[i] <= max) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(final char[] arr, final char valueToFind) {
        int startIndex = 0;
        return indexOf(arr, valueToFind, startIndex);
    }

    public static int indexOf(final char[] arr, final char valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < arr.length; ++i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(final boolean[] arr, final boolean valueToFind) {
        int startIndex = 0;
        return indexOf(arr, valueToFind, startIndex);
    }

    public static int indexOf(final boolean[] arr, final boolean valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < arr.length; ++i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }
    //endregion

    //region lastIndexOf() 方法
    public static int lastIndexOf(final Object[] arr, final Object objectToFind) {
        int startIndex = Integer.MAX_VALUE;
        return lastIndexOf(arr, objectToFind, startIndex);
    }

    public static int lastIndexOf(final Object[] arr, final Object objectToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= arr.length) {
            startIndex = arr.length - 1;
        }
        if (null == objectToFind) {
            for (int i = startIndex; i >= 0; --i) {
                if (null == arr[i]) {
                    return i;
                }
            }
            /*
             * 1、arr.getClass() 获取的是数组的类型 Object[]；
             * 2、arr.getClass().getComponentType() 获取的是数组的组件类型 Object；
             * 3、arr.getClass().getComponentType().isInstance(valueToFind) 判断类型是否一致，相当于 instanceOf；
             */
        } else if (arr.getClass().getComponentType().isInstance(objectToFind)) {
            for (int i = startIndex; i >= 0; --i) {
                if (objectToFind.equals(arr[i])) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final byte[] arr, final byte valueToFind) {
        int startIndex = Integer.MAX_VALUE;
        return lastIndexOf(arr, valueToFind, startIndex);
    }

    public static int lastIndexOf(final byte[] arr, final byte valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= arr.length) {
            startIndex = arr.length - 1;
        }
        for (int i = startIndex; i >= 0; --i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final short[] arr, final short valueToFind) {
        int startIndex = Integer.MAX_VALUE;
        return lastIndexOf(arr, valueToFind, startIndex);
    }

    public static int lastIndexOf(final short[] arr, final short valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= arr.length) {
            startIndex = arr.length - 1;
        }
        for (int i = startIndex; i >= 0; --i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final int[] arr, final int valueToFind) {
        int startIndex = Integer.MAX_VALUE;
        return lastIndexOf(arr, valueToFind, startIndex);
    }

    public static int lastIndexOf(final int[] arr, final int valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= arr.length) {
            startIndex = arr.length - 1;
        }
        for (int i = startIndex; i >= 0; --i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final long[] arr, final long valueToFind) {
        int startIndex = Integer.MAX_VALUE;
        return lastIndexOf(arr, valueToFind, startIndex);
    }

    public static int lastIndexOf(final long[] arr, final long valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= arr.length) {
            startIndex = arr.length - 1;
        }
        for (int i = startIndex; i >= 0; --i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final float[] arr, final float valueToFind) {
        int startIndex = Integer.MAX_VALUE;
        return lastIndexOf(arr, valueToFind, startIndex);
    }

    public static int lastIndexOf(final float[] arr, final float valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= arr.length) {
            startIndex = arr.length - 1;
        }
        for (int i = startIndex; i >= 0; --i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final double[] arr, final double valueToFind) {
        int startIndex = Integer.MAX_VALUE;
        return lastIndexOf(arr, valueToFind, startIndex);
    }

    public static int lastIndexOf(final double[] arr, final double valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= arr.length) {
            startIndex = arr.length - 1;
        }
        for (int i = startIndex; i >= 0; --i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 返回倒数第一个出现在误差范围内的索引
     */
    public static int lastIndexOf(final double[] arr, final double valueToFind, final double tolerance) {
        int startIndex = Integer.MAX_VALUE;
        return lastIndexOf(arr, valueToFind, tolerance, startIndex);
    }

    public static int lastIndexOf(final double[] arr, final double valueToFind, final double tolerance, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= arr.length) {
            startIndex = arr.length - 1;
        }
        final double min = valueToFind - tolerance;
        final double max = valueToFind + tolerance;
        for (int i = startIndex; i >= 0; --i) {
            if (arr[i] >= min && arr[i] <= max) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final char[] arr, final char valueToFind) {
        int startIndex = Integer.MAX_VALUE;
        return lastIndexOf(arr, valueToFind, startIndex);
    }

    public static int lastIndexOf(final char[] arr, final char valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= arr.length) {
            startIndex = arr.length - 1;
        }
        for (int i = startIndex; i >= 0; --i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final boolean[] arr, final boolean valueToFind) {
        int startIndex = Integer.MAX_VALUE;
        return lastIndexOf(arr, valueToFind, startIndex);
    }

    public static int lastIndexOf(final boolean[] arr, final boolean valueToFind, int startIndex) {
        if (null == arr) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= arr.length) {
            startIndex = arr.length - 1;
        }
        for (int i = startIndex; i >= 0; --i) {
            if (valueToFind == arr[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }
    //endregion

    //region contains() 方法
    public static boolean contains(final Object[] arr, final Object objectToFind) {
        return indexOf(arr, objectToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(final byte[] arr, final byte valueToFind) {
        return indexOf(arr, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(final short[] arr, final short valueToFind) {
        return indexOf(arr, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(final int[] arr, final int valueToFind) {
        return indexOf(arr, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(final long[] arr, final long valueToFind) {
        return indexOf(arr, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(final float[] arr, final float valueToFind) {
        return indexOf(arr, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(final double[] arr, final double valueToFind) {
        return indexOf(arr, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(final char[] arr, final char valueToFind) {
        return indexOf(arr, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(final boolean[] arr, final boolean valueToFind) {
        return indexOf(arr, valueToFind) != INDEX_NOT_FOUND;
    }
    //endregion

    //region nonContains() 方法
    public static boolean nonContains(final Object[] arr, final Object objectToFind) {
        return indexOf(arr, objectToFind) == INDEX_NOT_FOUND;
    }

    public static boolean nonContains(final byte[] arr, final byte valueToFind) {
        return indexOf(arr, valueToFind) == INDEX_NOT_FOUND;
    }

    public static boolean nonContains(final short[] arr, final short valueToFind) {
        return indexOf(arr, valueToFind) == INDEX_NOT_FOUND;
    }

    public static boolean nonContains(final int[] arr, final int valueToFind) {
        return indexOf(arr, valueToFind) == INDEX_NOT_FOUND;
    }

    public static boolean nonContains(final long[] arr, final long valueToFind) {
        return indexOf(arr, valueToFind) == INDEX_NOT_FOUND;
    }

    public static boolean nonContains(final float[] arr, final float valueToFind) {
        return indexOf(arr, valueToFind) == INDEX_NOT_FOUND;
    }

    public static boolean nonContains(final double[] arr, final double valueToFind) {
        return indexOf(arr, valueToFind) == INDEX_NOT_FOUND;
    }

    public static boolean nonContains(final char[] arr, final char valueToFind) {
        return indexOf(arr, valueToFind) == INDEX_NOT_FOUND;
    }

    public static boolean nonContains(final boolean[] arr, final boolean valueToFind) {
        return indexOf(arr, valueToFind) == INDEX_NOT_FOUND;
    }
    //endregion



}
