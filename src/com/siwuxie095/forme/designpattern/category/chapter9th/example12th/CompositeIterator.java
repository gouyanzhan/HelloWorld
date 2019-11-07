package com.siwuxie095.forme.designpattern.category.chapter9th.example12th;

import java.util.Iterator;
import java.util.Stack;

/**
 * 组合迭代器
 *
 * @author Jiajing Li
 * @date 2019-11-07 20:23:16
 */
class CompositeIterator implements Iterator {

    private Stack<Iterator> stack = new Stack<>();

    /**
     * 将要遍历的顶层组合的迭代器传入。将它放进一个栈中。
     */
    CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    /**
     * 想要知道是否还有下一个元素，先检查栈是否被清空。如果已经空了，就表示
     * 没有下一个元素了。否则，就从栈顶取出迭代器，看看是否还有下一个元素。
     * 如果它没有元素（即 菜单项），将它弹出栈中，然后递归调用 hasNext()。
     */
    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    /**
     * 当客户想要取得下一个元素的时候，先调用 hasNext() 来确定是否
     * 还有下一个。如果还有下一个元素，就从栈中取出目前的迭代器，然
     * 后取得它的下一个元素。如果下一个元素是一个菜单，就有了另一个
     * 需要被包含进遍历中的组合，所以将它丢进栈中。不管是不是菜单，
     * 都返回该组件。
     */
    @Override
    public Object next() {
        if (hasNext()) {
            Iterator iterator = stack.peek();
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            if (menuComponent instanceof Menu) {
                stack.push(menuComponent.createIterator());
            }
            return menuComponent;
        } else {
            return null;
        }
    }

    /**
     * 不支持删除，这里只有遍历。
     */
    @Override
    public void remove() {

    }
}
