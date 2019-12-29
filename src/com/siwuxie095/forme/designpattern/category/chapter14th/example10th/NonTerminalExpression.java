package com.siwuxie095.forme.designpattern.category.chapter14th.example10th;

/**
 * 终结符表达式类
 *
 * @author Jiajing Li
 * @date 2019-11-11 19:32:55
 */
class NonTerminalExpression extends Expression {

    private Expression expression1;

    private Expression expression2;

    NonTerminalExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    Object interpret(String info) {
        return null;
    }
}
