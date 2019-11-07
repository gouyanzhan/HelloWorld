package com.siwuxie095.forme.designpattern.category.chapter9th.example8th;

import java.util.Calendar;
import java.util.Iterator;

/**
 * 交替的午餐菜单迭代器
 *
 * @author Jiajing Li
 * @date 2019-11-06 08:35:05
 */
class AlternatingLunchMenuIterator implements Iterator {

    /**
     * 菜单项
     */
    private MenuItem[] menuItems;

    /**
     * 当前遍历的位置
     */
    private int position = 0;

    AlternatingLunchMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
        Calendar rightNow = Calendar.getInstance();
        position = rightNow.get(Calendar.DAY_OF_WEEK) % 2;
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
        position = position + 2;
        return menuItem;
    }

    /**
     * 注意：此迭代器不支持删除
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Alternating Lunch Menu Iterator does not support remove()");
    }
}
