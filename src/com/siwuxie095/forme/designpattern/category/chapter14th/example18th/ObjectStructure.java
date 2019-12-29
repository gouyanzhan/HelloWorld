package com.siwuxie095.forme.designpattern.category.chapter14th.example18th;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 对象结构
 *
 * @author Jiajing Li
 * @date 2019-11-11 23:52:47
 */
class ObjectStructure {

    private List<Element> elements = new ArrayList<>();

    void accept(Visitor visitor) {
        Iterator iterator = elements.iterator();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            element.accept(visitor);
        }
    }

    void add(Element element) {
        elements.add(element);
    }

    void remove(Element element) {
        elements.remove(element);
    }

}
