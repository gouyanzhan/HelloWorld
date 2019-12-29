package com.siwuxie095.forme.designpattern.category.chapter11th.example8th;

/**
 * @author Jiajing Li
 * @date 2019-11-09 17:05:20
 */
public class Main {

    /**
     * Java 动态代理
     *
     * Java 在 java.lang.reflect 包中有自己的代理支持，利用这个包可以在运行时
     * 动态的创建一个代理类，实现一个或多个接口，并将方法的调用转发到你所指定的类。
     * 因为实际的代理类是在类运行时创建的，称这个 Java 技术为：动态代理。
     *
     * Proxy 由 Java 动态代理生成，而且完整实现了 Subject。实际自己需要做的就是
     * 提供一个 InvocationHandler。Proxy 上的任何调用都会传入此类。InvocationHandler
     * 控制对 RealSubject 的访问。
     *
     * 因为 Proxy 类是 Java 创建的，所以你需要有办法告诉 Proxy 类你要做什么。显
     * 然，你要做的事情放在 Proxy 中，因为 Proxy 不是你直接实现的。所以要把要做的
     * 事情放到 InvocationHandler 中。InvocationHandler 的工作是响应代理的任何
     * 调用。可以把 InvocationHandler 想像成是代理收到方法调用后，做实际工作的对
     * 象。
     */
    public static void main(String[] args) {
        Client client = new Client();
        client.request();
    }

}
