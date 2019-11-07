package com.siwuxie095.forme.designpattern.category.chapter9th.example8th;

import java.util.Iterator;

/**
 * 菜单
 *
 * @author Jiajing Li
 * @date 2019-11-06 10:43:12
 */
interface Menu {

    /**
     * 创建一个菜单迭代器
     */
    Iterator createIterator();

}
