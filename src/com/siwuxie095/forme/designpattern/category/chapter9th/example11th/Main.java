package com.siwuxie095.forme.designpattern.category.chapter9th.example11th;

/**
 * @author Jiajing Li
 * @date 2019-11-06 23:48:31
 */
public class Main {

    /**
     * 组合模式
     *
     * 组件 Component 为组合模式中的所有对象定义一个接口，不管是
     * 组合对象 Composite 还是个别对象 Leaf。
     *
     * 客户 Client 使用 Component 接口操作组合模式中的对象。
     *
     * Component 可以为 add()、remove()、getChild() 和它的操
     * 作，以实现一些默认的行为。
     *
     * 请注意，Leaf 也继承了像 add()、remove() 和 getChild()
     * 这样的方法，这些方法或许对 Leaf 没有意义。
     * Leaf 通过实现 Composite 支持的操作，定义了组合内元素的行
     * 为。
     *
     * Composite 的角色是要定义组件的行为，而这样的组件具有子节点。
     *
     * 同样的，Composite 也实现了 Leaf 相关的操作。其中有一些操作
     * 可能对于 Composite 意义不大，因此在这个情况下可能产生异常。
     */
    public static void main(String[] args) {
        Component allComponents = new Composite();

        Component compositeA = new Composite();
        Component compositeB = new Composite();
        Component compositeC = new Composite();

        allComponents.add(compositeA);
        allComponents.add(compositeB);
        allComponents.add(compositeC);

        Component leafA1st = new Leaf();
        Component leafA2nd = new Leaf();
        Component leafA3rd = new Leaf();

        compositeA.add(leafA1st);
        compositeA.add(leafA2nd);
        compositeA.add(leafA3rd);

        Client client = new Client(allComponents);
        client.doSomething();
    }

}
