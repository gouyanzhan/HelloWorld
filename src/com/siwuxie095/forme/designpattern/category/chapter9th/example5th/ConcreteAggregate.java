package com.siwuxie095.forme.designpattern.category.chapter9th.example5th;

/**
 * 具体聚合
 *
 * @author Jiajing Li
 * @date 2019-11-06 16:42:30
 */
class ConcreteAggregate implements Aggregate {

    /*
     * 这个具体聚合持有一个对象的集合，并实现一个方法，利用
     * 此方法返回集合的迭代器。
     *
     * 所持有的对象集合可以是数组、列表、散列表等等，这里以
     * 一个数组为例。
     *
     * 每一个具体聚合都要负责实例化一个具体迭代器，此迭代器
     * 能够遍历对象集合。
     */

    private String[] collection;

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(collection);
    }
}
