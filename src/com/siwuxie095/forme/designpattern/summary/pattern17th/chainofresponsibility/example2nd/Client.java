package com.siwuxie095.forme.designpattern.summary.pattern17th.chainofresponsibility.example2nd;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:56:35
 */
class Client {

    Handler createHandler() {
        Handler concreteHandler1st = new ConcreteHandler1st();
        Handler concreteHandler2nd = new ConcreteHandler2nd();

        concreteHandler1st.setSuccessor(concreteHandler2nd);

        return concreteHandler1st;
    }

}
