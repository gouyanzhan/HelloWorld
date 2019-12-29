package com.siwuxie095.forme.designpattern.category.chapter14th.example5th;

/**
 * 抱怨邮件处理器
 *
 * @author Jiajing Li
 * @date 2019-11-11 16:35:27
 */
class ComplainHandler extends Handler {

    @Override
    void handleRequest(String request) {
        if ("complain".equals(request)) {
            System.out.println("抱怨邮件处理器正在处理该邮件");
        } else {
            if (null != getSuccessor()) {
                getSuccessor().handleRequest(request);
            } else {
                System.out.println("没有处理器可以处理该邮件");
            }
        }
    }
}
