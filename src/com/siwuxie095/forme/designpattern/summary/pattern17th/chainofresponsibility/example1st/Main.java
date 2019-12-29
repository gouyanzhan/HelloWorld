package com.siwuxie095.forme.designpattern.summary.pattern17th.chainofresponsibility.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-11 16:21:16
 */
public class Main {

    public static void main(String[] args) {
        Handler spamHandler = new SpamHandler();
        Handler fanHandler = new FanHandler();
        Handler complainHandler = new ComplainHandler();

        spamHandler.setSuccessor(fanHandler);
        fanHandler.setSuccessor(complainHandler);

        spamHandler.handleRequest("complain");
        spamHandler.handleRequest("other");
    }

}
