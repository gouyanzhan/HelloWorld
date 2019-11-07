package com.siwuxie095.forme.designpattern.category.chapter9th.example11th;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 组合（非叶子节点）
 *
 * @author Jiajing Li
 * @date 2019-11-06 23:40:56
 */
class Composite extends Component {

    private List<Component> components;

    Composite() {
        this.components = new ArrayList<>();
    }

    @Override
    void add(Component component) {
        components.add(component);
    }

    @Override
    void remove(Component component) {
        components.remove(component);
    }

    @Override
    Component getChild(int i) {
        return components.get(i);
    }

    @Override
    void operation() {
        // do something ...
        Iterator iterator = components.iterator();
        while (iterator.hasNext()) {
            /*
             * 当 component 是个别对象时，直接执行对应操作即可；
             * 当 component 是组合对象时，则进行递归调用；
             */
            Component component = (Component) iterator.next();
            component.operation();
        }
    }
}
