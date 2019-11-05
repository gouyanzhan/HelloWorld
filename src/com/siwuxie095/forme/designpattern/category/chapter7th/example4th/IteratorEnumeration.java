package com.siwuxie095.forme.designpattern.category.chapter7th.example4th;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 适配器：将迭代器 Iterator 适配成枚举器 Enumeration
 *
 * @author Jiajing Li
 * @date 2019-11-04 18:30:38
 */
class IteratorEnumeration implements Enumeration {

    private Iterator iterator;

    public IteratorEnumeration(Iterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
}
