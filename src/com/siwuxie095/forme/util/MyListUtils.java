package com.siwuxie095.forme.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * List 相关的工具类
 *
 * @author Jiajing Li
 * @date 2019-01-18 10:13:36
 */
public final class MyListUtils implements Serializable {

    private MyListUtils() {
        throw new AssertionError("There is no MyListUtils instance for you!");
    }

    /**
     * 创建一个 ArrayList
     *
     * @param <E> ArrayList 的类型
     * @return 创建的 ArrayList
     */
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * 判断 list 是否为空
     *
     * @param list 传入的 list
     * @return true 为空；false 不为空
     */
    public static boolean isEmpty(final List list) {
        return null == list || list.size() == 0;
    }

    /**
     * 判断 list 是否不为空
     *
     * @param list 传入的 list
     * @return true 不为空；false 为空
     */
    public static boolean nonEmpty(final List list) {
        return null != list && list.size() > 0;
    }

}
