package com.siwuxie095.foryou.clazz;

/**
 * 关于访问控制符
 *
 * @author Jiajing Li
 * @date 2019-01-20 22:15:53
 */
public class Human {

    /*
     * 关于访问控制符，也称访问修饰符
     *
     * 权限大小：public（公开的） > protected（受保护的） > default（默认的，即 什么都不写） > private（私有的）
     *
     *  public      即 当前项目可见
     *  protected   即 当前包以及子类可见
     *  default     即 当前包可见
     *  private     即 当前类可见
     */

    /**
     * 姓名
     */
    public String name;

    /**
     * 性别
     */
    public String sex;

    /**
     * 年龄
     */
    public int age;

    /**
     * 自我介绍
     */
    public void selfIntroduce() {
        System.out.println("我是" + name + "，性别：" + sex + "，今年" + age + "岁。");
    }

    /**
     * 工作
     */
    protected void work() {
        System.out.println(name + "正在工作。");
    }

    /**
     * 吃饭
     */
    void eat() {
        System.out.println(name + "正在吃饭。");
    }

    /**
     * 睡觉
     */
    private void sleep() {
        System.out.println(name + "正在睡觉。");
    }

    String getState(int time) {
        String state;
        if (time >= 0 && time <= 24) {
            if (time >= 8 && time < 17) {
                state = "我在工作！";
            } else if (time >= 17 && time < 22) {
                state = "我在学习！";
            } else {
                state = "我在睡觉！";
            }
        } else {
            state = "错误的时间！";
        }
        return state;
    }

}

