package com.siwuxie095.forme.designpattern.summary.pattern11th.iterator.example3rd;

/**
 * 迭代器
 *
 * @author Jiajing Li
 * @date 2019-11-06 16:42:55
 */
interface Iterator {

    /*
     * 这是所有迭代器都必须实现的接口，它包含一些方法，利用这些
     * 方法可以在集合元素之间游走。
     */

    /**
     * 是否还有下一个元素
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     */
    Object next();

    /**
     * 删除当前位置的元素
     */
    void remove();

}
