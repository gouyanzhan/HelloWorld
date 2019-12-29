package com.siwuxie095.forme.designpattern.summary.pattern12th.composite.example2nd;

/**
 * 组件（根节点）
 *
 * @author Jiajing Li
 * @date 2019-11-06 23:39:51
 */
abstract class Component {

    void add(Component component) {
        throw new UnsupportedOperationException();
    }

    void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    Component getChild(int i) {
        throw new UnsupportedOperationException();
    }

    void operation() {
        throw new UnsupportedOperationException();
    }

}
