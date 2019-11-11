package com.siwuxie095.forme.designpattern.category.chapter14th.example7th;

import java.util.HashMap;
import java.util.Map;

/**
 * 树管理器
 *
 * @author Jiajing Li
 * @date 2019-11-11 17:14:05
 */
class TreeManager {

    private Map<String, Tree> treeMap = new HashMap<>();

    Tree getTree(int x, int y, int age) {
        Tree tree = treeMap.get(x + "-" + y);
        if (null != tree) {
            tree.setAge(age);
            return tree;
        } else {
            tree = new Tree(x, y, age);
            treeMap.put(x + "-" + y, tree);
            return tree;
        }
    }

}
