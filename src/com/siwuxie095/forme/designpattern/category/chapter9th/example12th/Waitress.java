package com.siwuxie095.forme.designpattern.category.chapter9th.example12th;

import java.util.Iterator;

/**
 * 女招待（客户）
 *
 * @author Jiajing Li
 * @date 2019-11-06 22:33:39
 */
class Waitress {

    /*
     * 女招待将使用菜单组件接口访问菜单和菜单项。
     */

    /**
     * 最顶层菜单（包含其它所有菜单）
     */
    private MenuComponent allMenus;

    Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    /**
     * 只需要调用最顶层菜单的 print() 方法，就可以
     * 打印整个菜单层次，包括所有菜单以及所有菜单项。
     */
    void printMenu() {
        allMenus.print();
    }

    /**
     * 打印素食菜单
     *
     * 这里使用了 try/catch 来处理那些不支持 isVegetarian() 方法的菜单的逻辑。
     * 但似乎使用 try/catch 不是一个好的编程形式。
     *
     * 一般来说，try/catch 是一种错误处理的方法，而不是程序逻辑的方法。但如果不
     * 这么做，还能有以下选择：
     * （1）在 调用 isVegetarian() 之前，用 instanceof 来检查菜单组件但运行
     * 时类型，以确定它是菜单项。但是这么做就会因为无法统一处理菜单和菜单项而失去
     * 透明性。
     * （2）改写 Menu 的 isVegetarian()，让它返回 false。这提供了一个简单的
     * 解决方案，同时也保持了透明性。
     *
     * 这里之所以用 try/catch 是为了表达 isVegetarian() 是 Menu 没有支持的
     * 操作。这和说 Menu 的 isVegetarian() 是 false 意义不同。同时，这样做
     * 也允许后来人去为 Menu 实现一个合理的 isVegetarian()，而我们不必再为此
     * 修改这里的代码了。
     */
    void printVegetarianMenu() {
        // 用 allMenus 的迭代器来作为 CompositeIterator
        Iterator iterator = allMenus.createIterator();
        while (iterator.hasNext()) {
            // 如果 menuComponent 是菜单，将会抛异常，捕获之后，什么都不做即可
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {}
        }
    }
}
