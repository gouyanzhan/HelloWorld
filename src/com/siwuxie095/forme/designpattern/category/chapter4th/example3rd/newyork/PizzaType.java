package com.siwuxie095.forme.designpattern.category.chapter4th.example3rd.newyork;

/**
 * 比萨类型
 *
 * @author Jiajing Li
 * @date 2019-10-12 10:36:25
 */
enum PizzaType {

    /**
     * 比萨类型
     */
    CHEESE("cheese", "芝士比萨"),

    GREEK("greek", "希腊比萨"),

    PEPPERONI("pepperoni", "腊肠比萨"),

    CLAM("clam", "蛤蜊比萨"),

    VEGGIE("veggie", "素食比萨"),

    ;

    private String value;

    private String desc;

    PizzaType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
