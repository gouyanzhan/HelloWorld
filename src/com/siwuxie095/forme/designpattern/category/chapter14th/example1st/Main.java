package com.siwuxie095.forme.designpattern.category.chapter14th.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-11 14:14:01
 */
public class Main {

    /**
     * 桥接模式
     *
     * 不只改变你的实现，也改变你的抽象。
     *
     *
     * 现在有两部遥控器，也有两台电视，希望任意一部遥控器可以操控任意
     * 一台电视，即 任意两两组合。
     *
     * 但是现在遥控器（抽象）可能会改变，而电视（实现）也可能会改变。
     *
     * 桥接模式通过将实现和抽象放在两个不同的层次中而使它们可以独立改变。
     *现在有了两个层次结构，其中一个是遥控器，而另一个是不同品牌的电视实
     * 现。有了桥接的存在，就可以独立地改变这两个层次。
     *
     *
     * 桥接的优点：
     * （1）将实现予以解耦，让它和抽象之间不再永久绑定。
     * （2）抽象和实现可以独立扩展，不会影响到对方。
     * （3）对于 "具体的抽象类" 所做的改变，不会影响到客户。
     *
     * 桥接的用途和缺点：
     * （1）当需要用不同的方式改变接口和实现时，桥接模式很好用。
     * （2）桥接模式的缺点是增加了复杂度。
     */
    public static void main(String[] args) {
        TV sharpTV = new SharpTV();
        TV sonyTV = new SonyTV();

        RemoteControl remoteControl1st = new ConcreteRemoteControl1st(sharpTV);
        RemoteControl remoteControl2nd = new ConcreteRemoteControl2nd(sharpTV);

        remoteControl1st.setChannel(10);
        remoteControl1st.previousChannel();

        System.out.println();

        remoteControl2nd.setChannel(20);
        remoteControl2nd.nextChannel();
    }

}
