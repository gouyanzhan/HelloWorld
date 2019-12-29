package com.siwuxie095.forme.designpattern.category.chapter7th.example4th;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 适配器：将枚举器 Enumeration 适配成迭代器 Iterator
 *
 * 因为要将枚举器适配成迭代器，适配器需要实现迭代器接口。适配器必须
 * 看起来就像是一个迭代器。
 *
 * @author Jiajing Li
 * @date 2019-11-04 18:06:52
 */
class EnumerationIterator implements Iterator {

    /**
     * 利用组合的方式，将枚举器结合进入适配器中，
     * 所以用一个实例变量记录枚举器
     */
    private Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    /**
     * 迭代器的 hasNext() 方法其实是委托给
     * 枚举器的 hasMoreElements() 方法
     */
    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    /**
     * 迭代器的 next() 方法其实是委托给
     * 枚举器的 nextElement() 方法
     */
    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    /**
     * 很不幸，不能支持迭代器的 remove() 方法，
     * 所以必须放弃。这里的做法是抛出一个异常
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
