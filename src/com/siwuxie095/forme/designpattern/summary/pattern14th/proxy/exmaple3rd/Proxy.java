package com.siwuxie095.forme.designpattern.summary.pattern14th.proxy.exmaple3rd;

/**
 * 代理
 *
 * @author Jiajing Li
 * @date 2019-11-09 17:15:25
 */
class Proxy implements Subject {

    /*
     * Proxy 持有对 Subject 的引用，所以必要时它可以将
     * 请求转发给 Subject。
     *
     * 创建 RealSubject 对象，通常由 Proxy 负责。
     */

    private Subject subject;

    Proxy() {
        subject = new RealSubject();
    }

    @Override
    public void request() {
        subject.request();
    }
}
