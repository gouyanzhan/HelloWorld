package com.siwuxie095.forme.designpattern.summary.pattern18th.flyweight.example2nd;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 *
 * @author Jiajing Li
 * @date 2019-11-11 18:28:31
 */
class FlyweightFactory {

    private static Map<String, Flyweight> pool = new HashMap<>();

    static Flyweight getFlyweight(String intrinsic) {
        Flyweight flyweight = null;
        if (pool.containsKey(intrinsic)) {
            flyweight = pool.get(intrinsic);
            System.out.println("已有 " + intrinsic + " 直接从享元池中取出");
        } else {
            flyweight = new ConcreteFlyweight(intrinsic);
            pool.put(intrinsic, flyweight);
            System.out.println("创建 " + intrinsic + " 并从享元池中取出");
        }
        return flyweight;
    }

}
