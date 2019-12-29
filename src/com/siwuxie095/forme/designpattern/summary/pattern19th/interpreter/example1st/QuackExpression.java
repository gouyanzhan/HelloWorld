package com.siwuxie095.forme.designpattern.summary.pattern19th.interpreter.example1st;

/**
 * 呱呱叫的表达式
 *
 * @author Jiajing Li
 * @date 2019-11-11 19:16:24
 */
class QuackExpression extends Expression {


    @Override
    boolean interpret(String context) {
        if ("quack".equals(context.toLowerCase())) {
            return true;
        }
        return false;
    }
}
