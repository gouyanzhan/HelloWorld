package com.siwuxie095.forme.designpattern.category.chapter9th.example3rd;

/**
 * 女招待
 *
 * @author Jiajing Li
 * @date 2019-11-06 10:18:23
 */
class Waitress {

    private Menu breakfastMenu;

    private Menu lunchMenu;

    Waitress(Menu breakfastMenu, Menu lunchMenu) {
        this.breakfastMenu = breakfastMenu;
        this.lunchMenu = lunchMenu;
    }

    /**
     * 打印出菜单上的每一项
     */
    void printMenu() {
        Iterator breakfastMenuIterator = breakfastMenu.createIterator();
        printMenu(breakfastMenuIterator);

        Iterator lunchMenuIterator = lunchMenu.createIterator();
        printMenu(lunchMenuIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 只打印早餐项
     */
    void printBreakfastMenu() {
        Iterator breakfastMenuIterator = breakfastMenu.createIterator();
        printMenu(breakfastMenuIterator);
    }

    /**
     * 只打印午餐项
     */
    void printLunchMenu() {
        Iterator lunchMenuIterator = lunchMenu.createIterator();
        printMenu(lunchMenuIterator);
    }

    /**
     * 打印所有的素食菜单项
     */
    void printVegetarianMenu() {
        Iterator breakfastMenuIterator = breakfastMenu.createIterator();
        while (breakfastMenuIterator.hasNext()) {
            MenuItem menuItem = (MenuItem) breakfastMenuIterator.next();
            if (menuItem.isVegetarian()) {
                System.out.println(menuItem);
            }
        }

        Iterator lunchMenuIterator = lunchMenu.createIterator();
        while (lunchMenuIterator.hasNext()) {
            MenuItem menuItem = (MenuItem) lunchMenuIterator.next();
            if (menuItem.isVegetarian()) {
                System.out.println(menuItem);
            }
        }
    }

    /**
     * 判断指定项是否是素食
     */
    boolean isItemVegetarian(String name) {
        Iterator breakfastMenuIterator = breakfastMenu.createIterator();
        while (breakfastMenuIterator.hasNext()) {
            MenuItem menuItem = (MenuItem) breakfastMenuIterator.next();
            if (menuItem.getName().equals(name) && menuItem.isVegetarian()) {
                return true;
            }
        }

        Iterator lunchMenuIterator = lunchMenu.createIterator();
        while (lunchMenuIterator.hasNext()) {
            MenuItem menuItem = (MenuItem) lunchMenuIterator.next();
            if (menuItem.getName().equals(name) && menuItem.isVegetarian()) {
                return true;
            }
        }
        return false;
    }
}
