package com.siwuxie095.forme.designpattern.summary.pattern11th.iterator.example3rd;

/**
 * 聚合
 *
 * @author Jiajing Li
 * @date 2019-11-06 16:42:12
 */
interface Aggregate {

    /*
     * 有了一个共同的接口供所有的聚合使用，这对客户代码
     * 是很方便的，将客户代码从聚合对象的实现解耦。
     */

    /**
     * 创建迭代器
     */
    Iterator createIterator();
}
