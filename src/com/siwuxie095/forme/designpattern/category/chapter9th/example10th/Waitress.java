package com.siwuxie095.forme.designpattern.category.chapter9th.example10th;

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
}
