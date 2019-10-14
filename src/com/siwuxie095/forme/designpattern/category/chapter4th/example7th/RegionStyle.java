package com.siwuxie095.forme.designpattern.category.chapter4th.example7th;

/**
 * 地区风味
 *
 * @author Jiajing Li
 * @date 2019-10-14 11:00:05
 */
enum RegionStyle {

    /**
     * 地区风味
     */
    NEW_YORK_STYLE("new_york_style", "纽约风味"),

    CHICAGO_STYLE("chicago_style", "芝加哥风味"),

    CALIFORNIA_STYLE("california_style", "加州风味")
    ;

    private String value;

    private String desc;

    RegionStyle(String value, String desc) {
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
