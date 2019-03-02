package com.siwuxie095.forme.util;

/**
 * Array 相关的工具类
 *
 * @author Jiajing Li
 * @date 2019-01-18 11:39:55
 */
public final class ArrayX {

    private ArrayX() {
        throw new AssertionError("There is no ArrayX instance for you!");
    }

    //public static <T> Boolean isEmpty(final T[] arr) {
    //    return null == arr || arr.length == 0;
    //}

    public static Boolean isEmpty(final Object[] arr) {
        return null == arr || arr.length == 0;
    }

    public static Boolean isEmpty(final byte[] arr) {
        return null == arr || arr.length == 0;
    }

    public static Boolean isEmpty(final short[] arr) {
        return null == arr || arr.length == 0;
    }

    public static Boolean isEmpty(final int[] arr) {
        return null == arr || arr.length == 0;
    }

    public static Boolean isEmpty(final long[] arr) {
        return null == arr || arr.length == 0;
    }

    public static Boolean isEmpty(final float[] arr) {
        return null == arr || arr.length == 0;
    }

    public static Boolean isEmpty(final double[] arr) {
        return null == arr || arr.length == 0;
    }

    public static Boolean isEmpty(final boolean[] arr) {
        return null == arr || arr.length == 0;
    }

    public static Boolean isEmpty(final char[] arr) {
        return null == arr || arr.length == 0;
    }

    /**
     * T 和 Object 都可以
     */
    //public static <T> Boolean nonEmpty(final T[] arr) {
    //    return null != arr && arr.length != 0;
    //}

    public static Boolean nonEmpty(final Object[] arr) {
        return null != arr && arr.length != 0;
    }

    public static Boolean nonEmpty(final byte[] arr) {
        return null != arr && arr.length != 0;
    }

    public static Boolean nonEmpty(final short[] arr) {
        return null != arr && arr.length != 0;
    }

    public static Boolean nonEmpty(final int[] arr) {
        return null != arr && arr.length != 0;
    }

    public static Boolean nonEmpty(final long[] arr) {
        return null != arr && arr.length != 0;
    }

    public static Boolean nonEmpty(final float[] arr) {
        return null != arr && arr.length != 0;
    }

    public static Boolean nonEmpty(final double[] arr) {
        return null != arr && arr.length != 0;
    }

    public static Boolean nonEmpty(final boolean[] arr) {
        return null != arr && arr.length != 0;
    }

    public static Boolean nonEmpty(final char[] arr) {
        return null != arr && arr.length != 0;
    }

}
