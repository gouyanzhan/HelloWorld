package com.siwuxie095.forme.designpattern.summary.pattern17th.chainofresponsibility.example1st;

/**
 * 粉丝邮件处理器
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:34:14
 */
class FanHandler extends Handler {

    @Override
    void handleRequest(String request) {
        if ("fan".equals(request)) {
            System.out.println("粉丝邮件处理器正在处理该邮件");
        } else {
            if (null != getSuccessor()) {
                getSuccessor().handleRequest(request);
            } else {
                System.out.println("没有处理器可以处理该邮件");
            }
        }
    }
}
