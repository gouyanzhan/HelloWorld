package com.siwuxie095.forme.designpattern.summary.pattern17th.chainofresponsibility.example1st;

/**
 * 垃圾邮件处理器
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:28:31
 */
class SpamHandler extends Handler {

    @Override
    void handleRequest(String request) {
        if ("spam".equals(request)) {
            System.out.println("垃圾邮件处理器正在处理该邮件");
        } else {
            if (null != getSuccessor()) {
                getSuccessor().handleRequest(request);
            } else {
                System.out.println("没有处理器可以处理该邮件");
            }
        }
    }
}
