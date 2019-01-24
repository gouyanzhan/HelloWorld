package com.siwuxie095.foryou.clazz;

/**
 * 关于静态变量和静态方法
 *
 * @author Jiajing Li
 * @date 2019-01-24 18:35:21
 */
public class Tank {

    /**
     * 总炮弹数
     */
    public static int totalShellCount;

    /**
     * 坦克编号
     */
    public String serialNumber;

    /**
     * 每辆坦克射出的炮弹数
     */
    public int singleShellCount;

    public Tank(String serialNumber) {
        this.serialNumber = serialNumber;
        this.singleShellCount = 0;
    }

    /**
     * 发射
     */
    public void shoot() {
        if (totalShellCount <= 0) {
            System.out.println(serialNumber + " 号坦克表示：已经弹尽粮绝啦～请尽快补充炮弹！");
            return;
        }
        totalShellCount--;
        singleShellCount++;
        System.out.println(serialNumber + " 号坦克发射了 " + singleShellCount + " 枚炮弹，还剩下 " + totalShellCount + " 枚炮弹！");
    }

    /**
     * 补充炮弹
     * @param count 补充炮弹的数量
     */
    public static void addShell(int count) {
        int existedShellCount = totalShellCount;
        totalShellCount += count;
        System.out.println("补充炮弹：原有炮弹 " + existedShellCount + " 枚，补充了 " + count + " 枚，现有炮弹 " + totalShellCount + " 枚！");
    }

}
