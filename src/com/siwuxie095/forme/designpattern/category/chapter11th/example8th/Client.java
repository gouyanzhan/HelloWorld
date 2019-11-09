package com.siwuxie095.forme.designpattern.category.chapter11th.example8th;

import java.lang.reflect.Proxy;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-11-09 17:24:42
 */
class Client {

    void request() {
        Subject subject = new RealSubject();
        Subject proxy = getSubjectProxy(subject);
    }

    /**
     * 获取主题的代理（创建动态代理）
     */
    private Subject getSubjectProxy(Subject subject) {
        // 利用 Proxy 的静态方法 newProxyInstance() 创建代理
        return (Subject) Proxy.newProxyInstance(
                subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(),
                new ConcreteInvocationHandler(subject));
    }

}
