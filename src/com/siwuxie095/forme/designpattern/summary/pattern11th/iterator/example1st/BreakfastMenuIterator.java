package com.siwuxie095.forme.designpattern.summary.pattern11th.iterator.example1st;

import java.util.List;

/**
 * 早餐菜单迭代器
 *
 * @author Jiajing Li
 * @date 2019-11-06 08:39:30
 */
class BreakfastMenuIterator implements Iterator {

    /**
     * 菜单项
     */
    private List<MenuItem> menuItems;

    /**
     * 当前遍历的位置
     */
    private int position;

    BreakfastMenuIterator(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.size() ||  null == menuItems.get(position)) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems.get(position);
        position = position + 1;
        return menuItem;
    }
}
