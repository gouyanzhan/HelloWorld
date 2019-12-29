package com.siwuxie095.forme.designpattern.category.chapter11th.example9th;

import java.lang.reflect.Proxy;

/**
 * @author Jiajing Li
 * @date 2019-11-09 18:04:45
 */
public class Main {

    /**
     * 利用 Java 的动态代理，创建一个保护代理
     *
     * 现在要做到：顾客不可以改变自己的 HotOrNot 评分，也不可以改变其他顾客的信息。
     *
     * 要做到这些，必须创建两个代理，一个访问自己的 PersonBean 对象，另一个访问另
     * 一顾客的 PersonBean 对象。这样代理就可以控制在每一种情况下允许哪一种请求。
     *
     * 由于 Java 的动态代理会为我们创建两个代理，这里只需要提供两个 InvocationHandler
     * 来处理代理转来的方法调用。
     *
     * 步骤一：
     * 创建两个 InvocationHandler。InvocationHandler 实现了代理的行为。
     *
     * 步骤二：
     * 写代码创建动态代理。
     *
     * 步骤三：
     * 利用适当的代理包装任何 PersonBean 对象。
     * 当需要使用 PersonBean 对象时，如果不是顾客自己（这种情况下，称为拥有者），
     * 就是另一个顾客正在查看某顾客信息或打分（这种情况下，称为非拥有者）。
     * 不管是哪一种情况，都为 PersonBean 创建适合的代理。
     *
     *
     * 疑问与解答：
     *
     * 问：
     * 到底 "动态代理" 动态在哪里？是不是指在运行时才将它实例化并和 handler 联系
     * 起来？
     * 答：
     * 不是的。动态代理之所以被称为动态，是因为运行时才将它的类创建出来。代码开始
     * 执行时，还没有 Proxy 类，它是根据需要从你传入的接口集创建的。
     *
     * 问：
     * 我的 InvocationHandler 看起来像一个很奇怪的 Proxy，它没有实现所代理类的
     * 任何方法。
     * 答：
     * 这是因为 InvocationHandler 根本就不是 Proxy，它只是一个帮助 Proxy 的类，
     * Proxy 会把调用转发给它处理。Proxy 本身是利用静态的 Proxy.newProxyInstance()
     * 方法在运行时动态地创建的。
     *
     * 问：
     * 有没有办法知道某个类是不是代理类呢？
     * 答：
     * 可以。代理类有一个静态方法，叫做 isProxyClass()。此方法的返回值如果是 true，
     * 表示这是一个动态代理类。除此之外，代理类还会实现特定的某些接口。
     *
     * 问：
     * 对于我能传入 newProxyInstance() 的接口类型，有没有什么限制？
     * 答：
     * 是有一些限制，我们总是传给 newProxyInstance() 一个接口数组，此数组内只能
     * 有接口，不能有类。如果接口不是 public，就必须属于同一个 package，不同的接
     * 口内，不可以有名称和参数完全一样的方法。还有一些比较细微的限制，可以仔细看一
     * 下 javadoc。
     *
     *
     *
     * 其实还有一些其他的代理：
     * （1）防火墙代理（Firewall Proxy）：
     * 控制网络资源的访问，保护主题免于 "坏客户" 的侵害。
     *
     * （2）智能引用代理（Smart Reference Proxy）：
     * 当主题被引用时，进行额外的动作，例如，计算一个对象被引用的次数。
     *
     * （3）缓存代理（Caching Proxy）：
     * 为开销大的运算结果提供暂时存储：它也允许多个客户共享结果，以减少计算或网络延迟。
     *
     * （4）同步代理（Synchronization Proxy）：
     * 在多线程的情况下为主题提供安全的访问。
     *
     * （5）复杂隐藏代理（Complexity Hiding Proxy）：
     * 用来隐藏一个类的复杂集合的复杂度，并进行访问控制。有时候也称为外观代理（Facade Proxy）。
     * 这不难理解。复杂隐藏代理和外观模式是不一样的，因为代理控制访问，而外观模式只提供另一组
     * 接口。
     *
     * （6）写入时复制代理（Copy-On-Write Proxy）：
     * 用来控制对象的复制，方法是延迟对象的复制，直到客户真的需要为止。这是虚拟代理的变体。
     */
    public static void main(String[] args) {
        // 初始化数据
        PersonBean jack = new PersonBeanImpl();
        jack.setName("Jack");
        jack.setGender("男");
        jack.setInterests("打篮球");
        jack.setHotOrNotRating(5);

        PersonBean tom = new PersonBeanImpl();
        tom.setName("Tom");
        tom.setGender("男");
        tom.setInterests("下围棋");
        tom.setHotOrNotRating(6);

        // 顾客 Jack 在看 Jack 的信息
        PersonBean ownerProxy = getOwnerProxy(jack);
        System.out.println("Name is " + ownerProxy.getName());
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());
        System.out.println();

        // 其他顾客在看 Jack 的信息
        PersonBean nonOwnerProxy = getNonOwnerProxy(jack);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("打保龄球");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());


    }

    /**
     * 获取拥有者的代理（创建动态代理）
     */
    private static PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new OwnerInvocationHandler(personBean));
    }

    /**
     * 获取非拥有者的代理（创建动态代理）
     */
    private static PersonBean getNonOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(personBean));
    }

}
