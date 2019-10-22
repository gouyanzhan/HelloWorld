package com.siwuxie095.forme.designpattern.category.chapter5th.example7th;

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
     * 记录唯一实例的静态变量
     *
     * volatile 防止指令重排，确保当 uniqueInstance 变量被初始化
     * 成 ChocolateBoiler 实例时，多个线程正确地处理 uniqueInstance
     * 变量。
     */
    private volatile static ChocolateBoiler uniqueInstance;

    /**
     * 开始时，锅炉是空的，且没有煮沸
     */
    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    /**
     * 获取唯一实例
     *
     * 双重检查加锁
     */
    public static ChocolateBoiler getInstance() {
        // 检查实例，如果不存在，就进入同步代码块。
        if (null == uniqueInstance) {
            // 注意：只有第一次会彻底执行这里的代码。
            synchronized (ChocolateBoiler.class) {
                // 进入区块后，再检查一次。如果仍是空，才创建实例。
                if (null == uniqueInstance) {
                    uniqueInstance = new ChocolateBoiler();
                }
            }
        }
        return uniqueInstance;
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
