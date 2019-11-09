package com.siwuxie095.forme.designpattern.category.chapter11th.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-08 21:20:11
 */
public class Main {

    /**
     * 代理模式：控制对象访问
     *
     * 现在糖果公司已经将糖果机放到了各个地点去进行售卖，但是老板要求在公司
     * 就能监控所有糖果机的地点以及糖果数量，来查看售卖情况。
     *
     * 但是公司电脑中的 JVM （本地）和 糖果机里的 JVM（远程），不是同一个
     * JVM，所以需要通过远程代理（remote proxy）来进行控制糖果机对象的访
     * 问。
     *
     * 即：糖果监视器是本地对象，糖果机是远程对象，要把远程对象的代理（简称
     * 远程代理）交给本地对象，本地对象通过代理的方式访问远程对象。
     *
     * 当然，这一切需要确保网络畅通。
     *
     *
     * 远程代理的角色
     *
     * 远程代理就好比 "远程对象的本地代表"。何谓 "远程对象"？这是一种对象，
     * 活在不同的 JVM 堆中（更一般的说法是：在不同的地址空间运行的远程对象）。
     * 何谓 "本地代表"？这是一种可以由本地方法调用的对象，其行为会转发到远程
     * 对象中。
     *
     * 所以，糖果监视器是本地对象（客户对象），它以为沟通的对象是真正的糖果机，
     * 但真正与它沟通的是代理，再由代理通过网络和真正的糖果机沟通。而代理则假
     * 装自己是远程对象，但其实只是一个中间角色。糖果机是远程对象（服务对象），
     * 它才是真东西，拥有真正做事的一些方法。
     *
     * 本地对象所做的就像是在做远程方法调用，但其实只是调用本地堆中的代理对象
     * 上的方法，再由代理处理所有网络通信的细节。
     *
     * 也就是说，需要设计一个支持远程方法调用的系统。而 Java 自带的 RMI 正好
     * 派上用场（RMI，即 远程方法调用 Remote Method Invocation）。
     *
     * 可以把糖果机变成远程服务，提供一些可以被远程调用的方法。然后，将创建一个
     * 能和远程的糖果机沟通的代理，这需要用到 RMI，最后结合糖果监视器，就大功告
     * 成了。
     *
     * 注：
     * （1）本地对象 = 客户对象
     * （2）远程对象 = 服务对象
     * （3）远程代理 = 远程对象的代理 = 远程对象的本地代表 = 代理对象
     */
    public static void main(String[] args) {

    }

}
