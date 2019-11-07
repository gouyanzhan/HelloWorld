package com.siwuxie095.forme.designpattern.category.chapter9th.example10th;

/**
 * 菜单项（个别 - 叶子节点）
 *
 * @author Jiajing Li
 * @date 2019-11-06 21:53:30
 */
class MenuItem extends MenuComponent {

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
     *
     */
    private boolean vegetarian;

    private double price;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
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
}
