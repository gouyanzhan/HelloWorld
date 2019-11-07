package com.siwuxie095.forme.designpattern.category.chapter9th.example5th;

/**
 * 具体迭代器
 *
 * @author Jiajing Li
 * @date 2019-11-06 16:43:26
 */
class ConcreteIterator implements Iterator {

    /*
     * 这个具体迭代器负责管理目前遍历的位置。
     */

    /**
     * 具体聚合所持有的对象集合
     */
    private String[] collection;

    /**
     * 当前遍历的位置
     */
    private int position;

    ConcreteIterator(String[] collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        if (position >= collection.length ||  null == collection[position]) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        String element = collection[position];
        position = position + 1;
        return element;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove an element until you've done at least one next()");
        }
        if (null != collection[position - 1]) {
            for (int i = position - 1; i < collection.length - 1; i++) {
                collection[i] = collection[i + 1];
            }
        }
        collection[collection.length - 1] = null;
    }
}
