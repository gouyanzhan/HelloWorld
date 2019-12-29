package com.siwuxie095.forme.designpattern.category.chapter9th.example12th;

import java.util.Iterator;

/**
 * 空迭代器
 *
 * @author Jiajing Li
 * @date 2019-11-07 20:21:09
 */
class NullIterator implements Iterator {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
