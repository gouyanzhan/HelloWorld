package com.siwuxie095.forme.designpattern.summary.pattern7th.command.example2nd;

/**
 * 接收者
 *
 * @author Jiajing Li
 * @date 2019-10-29 09:52:35
 */
class Receiver {

    /**
     * 正向动作
     */
    void actionPositively() {
        System.out.println("接收者做正向动作");
    }

    /**
     * 逆向动作
     */
    void actionNegatively() {
        System.out.println("接收者做逆向动作");
    }

}
