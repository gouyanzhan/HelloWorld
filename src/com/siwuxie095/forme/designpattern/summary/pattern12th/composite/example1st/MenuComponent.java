package com.siwuxie095.forme.designpattern.summary.pattern12th.composite.example1st;

/**
 * 菜单组件（组件 - 根节点）
 *
 * @author Jiajing Li
 * @date 2019-11-06 21:47:55
 */
abstract class MenuComponent {

    /*
     * 菜单组件提供了一个接口，让菜单和菜单项共同使用。
     * 因为希望能够为这些方法提供默认的实现，所以这里
     * 使用了抽象类。
     *
     * 有些方法只对菜单项有意义，而有些则只对菜单有意
     * 义，默认实现是抛出 UnsupportedOperationException
     * 异常。这样，如果菜单项或菜单不支持某个操作时，
     * 它们就不需做任何事情，直接继承默认实现即可。
     *
     * 即：
     * （1）当菜单项或者菜单不想实现某些方法的时候，
     * 就可以不实现这些方法。
     * （2）由于菜单项和菜单的角色不同，所以对于不
     * 适用的方法，最好是抛出运行时异常。
     *
     *
     */

    /**
     * 新增菜单组件
     */
    void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 删除菜单组件
     */
    void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取菜单组件
     */
    MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    String getName() {
        throw new UnsupportedOperationException();
    }

    String getDescription() {
        throw new UnsupportedOperationException();
    }

    boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    double getPrice() {
        throw new UnsupportedOperationException();
    }

    void print() {
        throw new UnsupportedOperationException();
    }

}
