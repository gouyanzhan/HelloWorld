package com.siwuxie095.forme.designpattern.category.chapter9th.example6th;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 晚餐菜单迭代器
 *
 * @author Jiajing Li
 * @date 2019-11-06 08:39:30
 */
class DinnerMenuIterator implements Iterator {

    /**
     * 菜单项
     */
    private List<MenuItem> menuItems;

    /**
     * 当前遍历的位置
     */
    private int position;

    DinnerMenuIterator(Map<String, MenuItem> menuItems) {
        this.menuItems = new ArrayList<>(menuItems.values());
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
