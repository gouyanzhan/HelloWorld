package com.siwuxie095.forme.util;

import java.io.Serializable;

/**
 * String 相关的工具类
 *
 * 参考：java.lang.String、org.apache.commons.lang3.StringUtils
 *
 * @author Jiajing Li
 * @date 2019-01-18 10:13:23
 */
public final class MyStringUtils implements Serializable {

    /*
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

    /**
     * 空格 space
     */
    public static final String SPACE = " ";

    /**
     * 空字符串 empty
     */
    public static final String EMPTY = "";

    /**
     * 找不到索引
     */
    public static final int INDEX_NOT_FOUND = -1;

    private MyStringUtils() {
        throw new AssertionError("There is no MyStringUtils instance for you!");
    }

    public static boolean isEmpty(final CharSequence cs) {
        return null == cs || cs.length() == 0;
    }

    public static boolean nonEmpty(final CharSequence cs) {
        return null != cs && cs.length() != 0;
    }

    public static boolean isAllEmpty(final CharSequence... css) {
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

    public static boolean isAnyEmpty(final CharSequence... css) {
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

    public static boolean isNoneEmpty(final CharSequence... css) {
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

    public static boolean isBlank(final CharSequence cs) {
        int len;
        if (null == cs || (len = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < len; ++i) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean nonBlank(final CharSequence cs) {
        int len;
        if (null == cs || (len = cs.length()) == 0) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < len; ++i) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                flag = true;
            }
        }
        return flag;
    }

    public static boolean isAllBlank(final CharSequence... css) {
        if (null == css || css.length == 0) {
            return true;
        }
        for (final CharSequence cs : css) {
            if (nonBlank(cs)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnyBlank(final CharSequence... css) {
        if (null == css || css.length == 0) {
            return true;
        }
        for (final CharSequence cs : css) {
            if (isBlank(cs)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNoneBlank(final CharSequence... css) {
        if (null == css || css.length == 0) {
            return false;
        }
        for (final CharSequence cs : css) {
            if (isBlank(cs)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(final String str1, final String str2) {
        if (str1 == str2) {
            return true;
        }
        return null != str1 && str1.equals(str2);
    }

    public static boolean nonEquals(final String str1, final String str2) {
        if (str1 == str2) {
            return false;
        }
        return null != str1 && !str1.equals(str2);
    }

    public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
        // todo ...
        return true;
    }

    public static boolean nonEquals(final CharSequence cs1, final CharSequence cs2) {
        // todo ...
        return true;
    }

    /**
     * 字符串转字符数组
     */
    public static char[] toCharArray(final String str) {
        if (null == str) {
            throw new NullPointerException("param cannot be null!");
        }
        return str.toCharArray();
    }

    /**
     * 去除字符串头尾的空格
     */
    public static String trim(final String str) {
        String trimStr = trimStart(str);
        return trimEnd(trimStr);
    }

    /**
     * 去除字符串头部的空格
     */
    public static String trimStart(final String str) {
        if (null == str) {
            return null;
        }

        int len = str.length();
        int start = 0;

        char[] charArr = toCharArray(str);
        char space = ' ';

        while (start < len && charArr[start] <= space) {
            start++;
        }
        return start > 0 ? str.substring(start) : str;
    }

    /**
     * 去除字符串尾部的空格
     */
    public static String trimEnd(final String str) {
        if (null == str) {
            return null;
        }

        int len = str.length();
        int start = 0;
        int end = len;

        char[] charArr = toCharArray(str);
        char space = ' ';

        while (end >= 0 && charArr[end - 1] <= space) {
            end--;
        }
        // 注意：substring() 截取时是前闭后开，即 [start, end)，即 [start, end-1]
        return end < len ? str.substring(start, end) : str;
    }

    /**
     * 去除字符串头尾的空格。去除后，如果为 null 或 空字符串，则返回 null
     */
    public static String trimToNull(final String str) {
        String trimStr = trim(str);
        return isEmpty(trimStr) ? null : trimStr;
    }

    /**
     * 去除字符串头尾的空格。去除后，如果为 null 或 空字符串，则返回空字符串
     */
    public static String trimToEmpty(final String str) {
        String trimStr = trim(str);
        return isEmpty(trimStr) ? EMPTY : trimStr;
    }

    /**
     * 去除字符串头尾的指定字符（从头尾分别开始遍历，如果当前字符是指定字符 stripChars 中的任一字符，就去除）
     *
     * 1、如果 stripChars 为 null，则去除头尾的空格；
     * 2、如果 stripChars 为 空字符串{@link EMPTY}，则什么也不做，即 不去除；
     * 3、如果 stripChars 为 指定字符，按照规则去除，直到遇到第一个不符合规则的；
     */
    public static String strip(final String str, final String stripChars) {
        String stripStr = stripStart(str, stripChars);
        return stripEnd(stripStr, stripChars);
    }

    /**
     * 去除字符串头部的指定字符（从头部开始遍历，如果当前字符是指定字符 stripChars 中的任一字符，就去除）
     *
     * 1、如果 stripChars 为 null，则去除头部的空格；
     * 2、如果 stripChars 为 空字符串{@link EMPTY}，则什么也不做，即 不去除；
     * 3、如果 stripChars 为 指定字符，按照规则去除，直到遇到第一个不符合规则的；
     */
    public static String stripStart(final String str, final String stripChars) {
        int len;
        if (null == str || (len = str.length()) == 0) {
            return str;
        }
        int start = 0;
        if (null == stripChars) {
            while (start != len && Character.isWhitespace(str.charAt(start))) {
                start++;
            }
        } else if (isEmpty(stripChars)) {
            return str;
        } else {
            while (start != len && stripChars.indexOf(str.charAt(start)) != INDEX_NOT_FOUND) {
                start++;
            }
        }
        return str.substring(start);
    }

    /**
     * 去除字符串尾部的指定字符（从尾部开始遍历，如果当前字符是指定字符 stripChars 中的任一字符，就去除）
     *
     * 1、如果 stripChars 为 null，则去除尾部的空格；
     * 2、如果 stripChars 为 空字符串{@link EMPTY}，则什么也不做，即 不去除；
     * 3、如果 stripChars 为 指定字符，按照规则去除，直到遇到第一个不符合规则的；
     */
    public static String stripEnd(final String str, final String stripChars) {
        int len;
        if (null == str || (len = str.length()) == 0) {
            return str;
        }
        int start = 0;
        int end = len;
        if (null == stripChars) {
            while (end != 0 && Character.isWhitespace(str.charAt(end - 1))) {
                end--;
            }
        } else if (isEmpty(stripChars)) {
            return str;
        } else {
            while (end != 0 && stripChars.indexOf(str.charAt(end - 1)) != INDEX_NOT_FOUND) {
                end--;
            }
        }
        // 注意：substring() 截取时是前闭后开，即 [start, end)，即 [start, end-1]
        return str.substring(start, end);
    }

    /**
     * 去除字符串头尾的空格
     */
    public static String strip(final String str) {
        return strip(str, null);
    }

    /**
     * 去除字符串头尾的空格。去除后，如果为 null 或 空字符串，则返回 null
     */
    public static String stripToNull(final String str) {
        String stripStr = strip(str);
        return isEmpty(stripStr) ? null : stripStr;
    }

    /**
     * 去除字符串头尾的空格。去除后，如果为 null 或 空字符串，则返回空字符串
     */
    public static String stripToEmpty(final String str) {
        String stripStr = strip(str);
        return isEmpty(stripStr) ? EMPTY : stripStr;
    }

    /**
     * 去除字符串数组中每一个字符串头尾的指定字符
     */
    public static String[] stripAll(final String[] strArr, final String stripChars) {
        int len;
        if (null == strArr || (len = strArr.length) == 0) {
            return strArr;
        }
        String[] stripStrArr = new String[len];
        for (int i = 0; i < len; ++i) {
            stripStrArr[i] = strip(strArr[i], stripChars);
        }
        return stripStrArr;
    }

    /**
     * 去除字符串数组中每一个字符串头尾的空格
     */
    public static String[] stripAll(final String... strs) {
        return stripAll(strs, null);
    }

    /**
     * todo 待定
     */
    public static String substring(final String str, int start, int end) {
        if (null == str) {
            return null;
        }
        int len = str.length();
        if (start < 0) {
            start = len + start;
        }
        if (end < 0) {
            end = len + end;
        }

        if (end > len) {
            end = len;
        }

        if (start > end) {
            return EMPTY;
        }

        if (start < 0) {
            start = 0;
        }

        if (end < 0) {
            end = 0;
        }


        return str.substring(start, end);

    }


}
