package com.siwuxie095.forme.util;

import java.io.Serializable;

/**
 * String 相关的工具类（参考 String、StringUtils）
 *
 * @author Jiajing Li
 * @date 2019-01-18 10:13:23
 */
public final class StringX implements Serializable {

    /**
     * 1、String 继承自 CharSequence，所以 String is a CharSequence，所以可以将 CharSequence 作为方法参数
     *
     * 实际上，String 字符串就是一个 char[] 字符数组，或者说是用字符数组实现的
     *
     * 2、CharSequence... 这三个点表示可变数组参数，在传参时：
     * （1）可不传
     * （2）可传一个 null，可传多个 null 以逗号隔开
     * （3）可传一个 CharSequence，可传多个 CharSequence 以逗号隔开
     * （4）可传一个 CharSequence[] 数组
     *
     * （5）不可传 CharSequence 和 CharSequence[]
     * （6）不可传 CharSequence[] 和 CharSequence[]
     */

    private StringX() {
        throw new AssertionError("There is no StringX instance for you!");
    }

    public static Boolean isEmpty(final CharSequence cs) {
        return null == cs || cs.length() == 0;
    }

    public static Boolean nonEmpty(final CharSequence cs) {
        return null != cs && cs.length() != 0;
    }

    public static Boolean isAllEmpty(final CharSequence... css) {
        if (null == css || css.length == 0) {
            return true;
        }
        for (final CharSequence cs : css) {
            if (nonEmpty(cs)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isAnyEmpty(final CharSequence... css) {
        if (null == css || css.length == 0) {
            return true;
        }
        for (final CharSequence cs : css) {
            if (isEmpty(cs)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isNoneEmpty(final CharSequence... css) {
        if (null == css || css.length == 0) {
            return false;
        }
        for (final CharSequence cs : css) {
            if (isEmpty(cs)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isBlank(final CharSequence cs) {
        int strLen;
        if (null == cs || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static Boolean nonBlank(final CharSequence cs) {
        int strLen;
        if (null == cs || (strLen = cs.length()) == 0) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                flag = true;
            }
        }
        return flag;
    }

    public static Boolean equals(final String str1, final String str2) {
        if (str1 == str2) {
            return true;
        }
        return null != str1 && str1.equals(str2);
    }

    public static Boolean nonEquals(final String str1, final String str2) {
        if (str1 == str2) {
            return false;
        }
        return null != str1 && !str1.equals(str2);
    }

    public static Boolean equals(final CharSequence cs1, final CharSequence cs2) {
        // todo ...
        return true;
    }

    public static Boolean nonEquals(final CharSequence cs1, final CharSequence cs2) {
        // todo ...
        return true;
    }

}
