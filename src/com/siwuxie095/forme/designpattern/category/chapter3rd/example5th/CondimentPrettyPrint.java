package com.siwuxie095.forme.designpattern.category.chapter3rd.example5th;

import java.util.HashMap;
import java.util.Map;

/**
 * 调料美化打印（具体装饰者）
 *
 * @author Jiajing Li
 * @date 2019-10-10 15:24:19
 */
public class CondimentPrettyPrint extends Condiment {

    CondimentPrettyPrint(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        String desc = beverage.getDescription();
        String[] arr = desc.split(",");
        Map<String, Integer> map = new HashMap<>();
        for (String val : arr) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String val : arr) {
            if (map.containsKey(val)) {
                res.append(val);
                res.append("(");
                res.append(map.get(val));
                res.append(")");
                res.append(", ");
            }
            map.remove(val);
        }
        return res.toString().substring(0, res.toString().lastIndexOf(","));
    }

    @Override
    public double cost() {
        return beverage.cost();
    }
}
