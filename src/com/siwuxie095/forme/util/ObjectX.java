package com.siwuxie095.forme.util;

import java.io.Serializable;
import java.util.Objects;

/**
 * Object 相关的工具类
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

}
