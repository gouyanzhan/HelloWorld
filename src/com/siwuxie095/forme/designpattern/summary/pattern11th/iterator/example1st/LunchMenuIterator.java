package com.siwuxie095.forme.designpattern.summary.pattern11th.iterator.example1st;

/**
 * 午餐菜单迭代器
 *
 * @author Jiajing Li
 * @date 2019-11-06 08:35:05
 */
class LunchMenuIterator implements Iterator {

    /**
     * 菜单项
     */
    private MenuItem[] menuItems;

    /**
     * 当前遍历的位置
     */
    private int position = 0;

    LunchMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.length ||  null == menuItems[position]) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems[position];
        position = position + 1;
        return menuItem;
    }
}
