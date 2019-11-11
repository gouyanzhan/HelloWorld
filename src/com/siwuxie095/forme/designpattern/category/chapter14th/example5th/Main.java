package com.siwuxie095.forme.designpattern.category.chapter14th.example5th;

/**
 * @author Jiajing Li
 * @date 2019-11-11 16:21:16
 */
public class Main {

    /**
     * 责任链模式
     *
     * 让一个以上的对象有机会能够处理某个请求。
     *
     *
     * 现在某公司开发出了一款热销产品，经常会收到各种反馈邮件，其中有
     * 垃圾邮件、粉丝邮件、也有抱怨邮件。现在需要写一个程序将这些邮件
     * 区分开，分别进行处理。
     *
     * 可以使用责任链模式。通过责任链模式，可以为某个请求创建一个对象
     * 链。每个对象依序检查此请求，并对其进行处理，或者将它传给链中的
     * 下一个对象。
     *
     * 链中的每个对象扮演处理器，并且有一个后继对象。如果它可以处理请
     * 求，就进行处理，否则把请求转发给后继者。
     * 如果邮件掉落到链尾端之后，就表示它没有经过任何处理，不过可以实
     * 现一个终极处理来应付这种情况。
     *
     *
     * 责任链的优点：
     * （1）将请求的发送者和接受者解耦。
     * （2）可以简化你的对象，因为它不需要知道链的结构。
     * （3）通过改变链内的成员或调动它们的次序，允许你动态地新增或删
     * 除责任。
     *
     * 责任链的用途和缺点：
     * （1）经常被用在窗口系统中，处理鼠标和键盘之类的事件。
     * （2）并不保证请求一定会被处理。如果没有任何对象处理它的话，它
     * 可能会掉落到链尾端之外（这可能是优点也可以是缺点）。
     * （3）可能不容易观察运行时的特征，有碍于 Debug。
     *
     * PS：责任链模式也被称为职责链模式。
     */
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
