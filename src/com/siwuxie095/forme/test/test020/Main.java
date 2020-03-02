package com.siwuxie095.forme.test.test020;

import java.util.UUID;

/**
 * @author Jiajing Li
 * @date 2020-03-02 10:18:24
 */
public class Main {

    /**
     * 说明的问题：
     * 1、UUID 的长度是 36，中间有 4 个横杠。
     * 2、UUID 中字母数字混合体的分布：8 + 4 + 4 + 12。
     */
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        System.out.println(uuid.length());
        System.out.println();

        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
    }

}
