package com.siwuxie095.forme.designpattern.category.chapter5th.example3rd;

/**
 * 巧克力锅炉
 *
 * @author Jiajing Li
 * @date 2019-10-22 14:16:29
 */
class ChocolateBoiler {

    /**
     * 锅炉是否为空
     */
    private boolean empty;

    /**
     * 锅炉是否煮沸
     */
    private boolean boiled;

    /**
     * 开始时，锅炉是空的，且没有煮沸
     */
    public ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    /**
     * 填入原料：此时锅炉必须是空的。一旦填入原料，就把
     * empty 和 boiled 两个标志设置好。
     */
    public void fill() {
        if (isEmpty()) {
            // 在锅炉内填满巧克力和牛奶的混合物
            empty = false;
            boiled = false;
        }
    }

    /**
     * 煮沸：煮混合物时，锅炉必须是满的，而且是没有煮过的。
     * 一旦煮沸后，就把 boiled 标志设置好。
     */
    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // 将锅炉内混合物煮沸
            boiled = true;
        }
    }

    /**
     * 排空锅炉：锅炉排出时，必须是满的，而且是煮过的。
     * 排出完毕后，把 empty 标志设置好。
     */
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // 排出煮沸的巧克力和牛奶
            empty = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
