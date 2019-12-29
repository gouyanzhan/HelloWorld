package com.siwuxie095.forme.designpattern.category.chapter9th.example12th;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 菜单（组合 - 非叶子节点）
 *
 * @author Jiajing Li
 * @date 2019-11-06 21:54:11
 */
class Menu extends MenuComponent {

    /*
     * 菜单中覆盖了一些对它有意义的方法，
     * 例如增加删除菜单项（或其它菜单）。
     */

    /**
     * 菜单中的组件（菜单项 或 其它菜单）
     */
    private List<MenuComponent> menuComponents;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单描述
     */
    private String description;

    Menu(String name, String description) {
        this.menuComponents = new ArrayList<>();
        this.name = name;
        this.description = description;
    }

    @Override
    void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    String getDescription() {
        return description;
    }

    @Override
    void print() {
        System.out.println(name + " " + description);
        System.out.println("----------------------");

        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            // 如果是菜单项，直接调用菜单项的方法打印；如果是菜单，则进行递归调用
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }

    /**
     * CompositeIterator 知道如何遍历任何组合。将目前组合的迭代器传入它的构造器。
     * 它的工作是遍历组件内的菜单项，而且确保所有的子菜单（以及子子菜单...）都被包
     * 括进来。
     */
    @Override
    Iterator createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }
}
