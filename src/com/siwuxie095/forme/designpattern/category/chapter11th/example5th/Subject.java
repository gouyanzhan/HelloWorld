package com.siwuxie095.forme.designpattern.category.chapter11th.example5th;

/**
 * 主题
 *
 * @author Jiajing Li
 * @date 2019-11-09 17:14:11
 */
interface Subject {

    /*
     * Proxy 和 RealSubject 都实现了 Subject 接口，这允许任何客户
     * 都可以像处理 RealSubject 对象一样处理 Proxy 对象。
     */

    void request();

}
