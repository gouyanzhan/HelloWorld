package com.siwuxie095.forme.designpattern.category.chapter14th.example9th;

/**
 * 向右转的表达式
 *
 * @author Jiajing Li
 * @date 2019-11-11 19:16:24
 */
class RightExpression extends Expression {


    @Override
    boolean interpret(String context) {
        if ("right".equals(context.toLowerCase())) {
            return true;
        }
        return false;
    }
}
