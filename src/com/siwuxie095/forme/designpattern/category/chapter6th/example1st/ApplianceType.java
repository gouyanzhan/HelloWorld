package com.siwuxie095.forme.designpattern.category.chapter6th.example1st;

/**
 * 家电类型
 *
 * @author Jiajing Li
 * @date 2019-10-28 11:20:08
 */
enum ApplianceType {

    /**
     * 家电类型
     */
    CEILING_FAN("吊扇"),

    GARAGE_DOOR("车库门"),

    HOTTUB("热水浴缸"),

    LIGHT("灯"),

    SPRINKLER("洒水器"),

    STEREO("音响"),

    TV("电视");

    private String desc;

    ApplianceType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getValue() {
        return name();
    }
}
