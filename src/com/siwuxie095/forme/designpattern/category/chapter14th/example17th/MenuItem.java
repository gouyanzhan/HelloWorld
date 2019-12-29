package com.siwuxie095.forme.designpattern.category.chapter14th.example17th;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单项（个别 - 叶子节点）
 *
 * @author Jiajing Li
 * @date 2019-11-11 22:52:04
 */
class MenuItem extends MenuComponent {

    /**
     * 菜单项的原料
     */
    private List<MenuComponent> materials;

    /*
     * 菜单项中覆盖了一些对它有意义的方法，至于那些没有意义的方法，
     * 就置之不理。例如 add() 之所以没意义，是因为菜单项已经是叶
     * 子节点，它的下面不能再有任何组件。
     */

    /**
     * 菜单项名称
     */
    private String name;

    /**
     * 菜单项描述
     */
    private String description;

    /**
     * 是否素食
     */
    private boolean vegetarian;

    /**
     * 价格
     */
    private double price;

    MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price) {
        this.materials = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    void add(MenuComponent menuComponent) {
        if (menuComponent instanceof Material) {
            materials.add(menuComponent);
        }
    }

    @Override
    void remove(MenuComponent menuComponent) {
        if (menuComponent instanceof Material) {
            materials.remove(menuComponent);
        }
    }

    @Override
    MenuComponent getChild(int i) {
        return materials.get(i);
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
    boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    double getPrice() {
        return price;
    }

    @Override
    void print() {
        System.out.println(name + " $" + price + " "
                + description + " " + (vegetarian ? "(v)" : ""));
    }

    @Override
    void getState(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    String getIngredient() {
        return "菜单项的成分";
    }
}
