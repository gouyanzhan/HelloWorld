package com.siwuxie095.forme.designpattern.category.chapter14th.example17th;

/**
 * 访问者
 *
 * @author Jiajing Li
 * @date 2019-11-11 23:31:20
 */
abstract class Visitor {

    abstract void visit(MenuItem menuItem);

    abstract void visit(Material material);
}
