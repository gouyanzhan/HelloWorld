package com.siwuxie095.forme.designpattern.summary.pattern23th.visitor.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-11 23:32:20
 */
class ConcreteVisitor extends Visitor {

    @Override
    void visit(MenuItem menuItem) {
        System.out.println(menuItem.getIngredient());
    }

    @Override
    void visit(Material material) {
        System.out.println(material.getIngredient());
    }
}
