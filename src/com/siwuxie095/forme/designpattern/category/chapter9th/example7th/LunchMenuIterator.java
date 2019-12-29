package com.siwuxie095.forme.designpattern.category.chapter9th.example7th;

import java.util.Iterator;

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

    /**
     * 因为使用的是固定长度的数组，所以在 remove() 被调用时，
     * 将后面所有的元素往前移动一个位置。
     */
    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove an item until you've done at least one next()");
        }
        if (null != menuItems[position - 1]) {
            for (int i = position - 1; i < menuItems.length - 1; i++) {
                menuItems[i] = menuItems[i + 1];
            }
        }
        menuItems[menuItems.length - 1] = null;
    }
}
