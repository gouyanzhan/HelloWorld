package com.siwuxie095.forme.designpattern.category.chapter11th.example5th;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-11-09 17:24:42
 */
class Client {

    /*
     * Client 和 RealSubject 的交互都必须通过 Proxy。因为 Proxy
     * 和 RealSubject 实现相同的接口，所以任何用到 RealSubject 的
     * 地方，都可以用 Proxy 取代。Proxy 也控制了对 RealSubject 的
     * 访问，在某些情况下，可能需要这样的控制。这些情况包括 RealSubject
     * 是远程的对象、RealSubject 是创建开销大的对象 或 RealSubject
     * 是需要被保护的对象。
     */

    void request() {
        Proxy proxy = new Proxy();
        proxy.request();
    }

}
