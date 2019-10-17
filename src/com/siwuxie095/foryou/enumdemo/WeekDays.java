package com.siwuxie095.foryou.enumdemo;

/**
 * @author Jiajing Li
 * @date 2019-10-08 21:40:23
 */
public enum WeekDays {

    /**
     * 枚举（关键字：enum）
     *
     * 是一种特殊的类。
     */

    SUNDAY(0, "SUNDAY", "星期天"),

    MONDAY(1, "MONDAY", "星期一"),

    TUESDAY(2, "TUESDAY", "星期二"),

    WEDNESDAY(3, "WEDNESDAY", "星期三"),

    THURSDAY(4, "THURSDAY", "星期四"),

    FRIDAY(5, "FRIDAY", "星期五"),

    SATURDAY(6, "SATURDAY", "星期六")
    ;

    private int key;

    private String value;

    private String desc;

    WeekDays(int key, String value, String desc) {
        this.key = key;
        this.value = value;
        this.desc = desc;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
